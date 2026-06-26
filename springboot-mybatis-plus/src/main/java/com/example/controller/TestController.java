// ... existing code ...
package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dto.PageVO;
import com.example.dto.UserDTO;
import com.example.entity.UserEntity;
import com.example.mapper.UserMapper;
import com.example.mapstruct.UserAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
@Tag(name = "测试模块")
public class TestController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserAssembler userAssembler;

    /**
     * LambdaQueryWrapper 使用示例
     */
    @GetMapping("/lambdaQuery")
    @Operation(summary = "查询用户")
    public List<UserDTO> lambdaQuery() {
        // 1. 基本用法 - 创建 LambdaQueryWrapper
        LambdaQueryWrapper<UserEntity> wrapper = new LambdaQueryWrapper<>();

        // 2. 条件查询 - 使用 Lambda 表达式避免硬编码字段名
        wrapper.eq(UserEntity::getName, "张三")           // WHERE name = '张三'
                .gt(UserEntity::getAge, 18)                // AND age > 18
                .like(UserEntity::getEmail, "@qq.com");    // AND email LIKE '%@qq.com%'

        List<UserEntity> users = userMapper.selectList(wrapper);

        // 3. 链式调用 - 更简洁的写法
        List<UserEntity> users2 = userMapper.selectList(
                new LambdaQueryWrapper<UserEntity>()
                        .eq(UserEntity::getStatus, 1)
                        .orderByDesc(UserEntity::getCreateTime)
        );

        // 4. 动态条件 - 根据参数决定是否添加条件
        String name = "张三";
        Integer age = null;

        LambdaQueryWrapper<UserEntity> dynamicWrapper = new LambdaQueryWrapper<>();
        dynamicWrapper.eq(name != null, UserEntity::getName, name)  // name不为null时才添加条件
                .eq(age != null, UserEntity::getAge, age);      // age不为null时才添加条件

        List<UserEntity> users3 = userMapper.selectList(dynamicWrapper);

        // 5. 常用条件方法
        LambdaQueryWrapper<UserEntity> complexWrapper = Wrappers.lambdaQuery(UserEntity.class);
        complexWrapper
                .eq(UserEntity::getId, 1)                    // 等于
                .ne(UserEntity::getStatus, 0)                // 不等于
                .gt(UserEntity::getAge, 18)                  // 大于
                .ge(UserEntity::getAge, 18)                  // 大于等于
                .lt(UserEntity::getAge, 60)                  // 小于
                .le(UserEntity::getAge, 60)                  // 小于等于
                .between(UserEntity::getAge, 18, 60)         // 在...之间
                .like(UserEntity::getName, "张")              // 模糊查询
                .likeLeft(UserEntity::getName, "三")          // 左模糊 %三
                .likeRight(UserEntity::getName, "张")         // 右模糊 张%
                .in(UserEntity::getId, 1, 2, 3)              // IN 查询
                .notIn(UserEntity::getId, 4, 5)              // NOT IN 查询
                .isNull(UserEntity::getEmail)                // IS NULL
                .isNotNull(UserEntity::getName)              // IS NOT NULL
                .orderByAsc(UserEntity::getAge)              // 升序
                .orderByDesc(UserEntity::getCreateTime);     // 降序

        return userAssembler.toUserDTOs(users);
    }

    /**
     * LambdaUpdateWrapper 更新示例
     */
    @GetMapping("/lambda-update")
    public int lambdaUpdate() {
        // 更新条件
        LambdaUpdateWrapper<UserEntity> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .eq(UserEntity::getId, 1)
                .set(UserEntity::getName, "李四")
                .set(UserEntity::getAge, 25);

        return userMapper.update(null, updateWrapper);
    }

    /**
     * 分页查询用户示例
     *
     * @param current 当前页，默认1
     * @param size    每页条数，默认10
     * @param name    模糊查询姓名（可选）
     * @param age     年龄（可选）
     * @return 分页DTO数据
     */
    @GetMapping("/pageUser")
    @Operation(summary = "分页查询用户（带动态条件）")
    public PageVO<UserDTO> pageUser(
            @RequestParam(defaultValue = "1") Long current,
            @RequestParam(defaultValue = "10") Long size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age
    ) {
        // 1. 构建分页对象
        Page<UserEntity> page = new Page<>(current, size);

        // 2. 构建动态查询条件
        LambdaQueryWrapper<UserEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.like(name != null, UserEntity::getName, name)
                .eq(age != null, UserEntity::getAge, age)
                .orderByDesc(UserEntity::getCreateTime);

        // 3. 分页查询
        Page<UserEntity> entityPage = userMapper.selectPage(page, wrapper);

        // 4. entity转DTO，封装分页VO返回
        List<UserDTO> dtoList = userAssembler.toUserDTOs(entityPage.getRecords());
        Page<UserDTO> dtoPage = new Page<>();
        dtoPage.setCurrent(entityPage.getCurrent());
        dtoPage.setSize(entityPage.getSize());
        dtoPage.setTotal(entityPage.getTotal());
        dtoPage.setPages(entityPage.getPages());
        dtoPage.setRecords(dtoList);

        return PageVO.convert(dtoPage);
    }
}