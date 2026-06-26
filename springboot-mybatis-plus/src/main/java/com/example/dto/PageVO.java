package com.example.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 通用分页返回对象
 */
@Data
public class PageVO<T> {
    /**
     * 当前页
     */
    private Long current;
    /**
     * 每页条数
     */
    private Long size;
    /**
     * 总条数
     */
    private Long total;
    /**
     * 总页数
     */
    private Long pages;
    /**
     * 分页数据
     */
    private List<T> records;

    /**
     * 封装MyBatis-Plus Page对象转PageVO
     */
    public static <T> PageVO<T> convert(Page<T> page) {
        PageVO<T> vo = new PageVO<>();
        vo.setCurrent(page.getCurrent());
        vo.setSize(page.getSize());
        vo.setTotal(page.getTotal());
        vo.setPages(page.getPages());
        vo.setRecords(page.getRecords());
        return vo;
    }
}