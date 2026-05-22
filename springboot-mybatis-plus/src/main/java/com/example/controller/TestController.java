// ... existing code ...
package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserMapper userMapper;

    /**
     * LambdaQueryWrapper 使用示例
     */
    @GetMapping("/lambda-query")
    public List<User> lambdaQuery() {
        // 1. 基本用法 - 创建 LambdaQueryWrapper
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        // 2. 条件查询 - 使用 Lambda 表达式避免硬编码字段名
        wrapper.eq(User::getName, "张三")           // WHERE name = '张三'
                .gt(User::getAge, 18)                // AND age > 18
                .like(User::getEmail, "@qq.com");    // AND email LIKE '%@qq.com%'

        List<User> users = userMapper.selectList(wrapper);

        // 3. 链式调用 - 更简洁的写法
        List<User> users2 = userMapper.selectList(
                new LambdaQueryWrapper<User>()
                        .eq(User::getStatus, 1)
                        .orderByDesc(User::getCreateTime)
        );

        // 4. 动态条件 - 根据参数决定是否添加条件
        String name = "张三";
        Integer age = null;

        LambdaQueryWrapper<User> dynamicWrapper = new LambdaQueryWrapper<>();
        dynamicWrapper.eq(name != null, User::getName, name)  // name不为null时才添加条件
                .eq(age != null, User::getAge, age);      // age不为null时才添加条件

        List<User> users3 = userMapper.selectList(dynamicWrapper);

        // 5. 常用条件方法
        LambdaQueryWrapper<User> complexWrapper = Wrappers.lambdaQuery(User.class);
        complexWrapper
                .eq(User::getId, 1)                    // 等于
                .ne(User::getStatus, 0)                // 不等于
                .gt(User::getAge, 18)                  // 大于
                .ge(User::getAge, 18)                  // 大于等于
                .lt(User::getAge, 60)                  // 小于
                .le(User::getAge, 60)                  // 小于等于
                .between(User::getAge, 18, 60)         // 在...之间
                .like(User::getName, "张")              // 模糊查询
                .likeLeft(User::getName, "三")          // 左模糊 %三
                .likeRight(User::getName, "张")         // 右模糊 张%
                .in(User::getId, 1, 2, 3)              // IN 查询
                .notIn(User::getId, 4, 5)              // NOT IN 查询
                .isNull(User::getEmail)                // IS NULL
                .isNotNull(User::getName)              // IS NOT NULL
                .orderByAsc(User::getAge)              // 升序
                .orderByDesc(User::getCreateTime);     // 降序

        return users;
    }

    /**
     * LambdaUpdateWrapper 更新示例
     */
    @GetMapping("/lambda-update")
    public int lambdaUpdate() {
        // 更新条件
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper
                .eq(User::getId, 1)
                .set(User::getName, "李四")
                .set(User::getAge, 25);

        return userMapper.update(null, updateWrapper);
    }
}
// ... existing code ...
