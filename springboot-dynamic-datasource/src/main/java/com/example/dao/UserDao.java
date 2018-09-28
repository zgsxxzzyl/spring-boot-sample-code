package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserDao {
    /**
     * 绑定枚举类型
     *
     * @return
     */
    @Select("SELECT * FROM USER")
    @Results(
            @Result(property = "sex", column = "sex", javaType = User.Sex.class, jdbcType = JdbcType.VARCHAR)
    )
    public List<User> queryAll();
}
