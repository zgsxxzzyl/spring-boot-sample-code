package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 参数中包含enum
     *
     * @param user
     * @return
     */
    @Transactional(readOnly = true)
    @Insert({"INSERT INTO USER(NAME, AGE,SEX) VALUES(#{user.name}, #{user.age},#{user.sex})"})
    @Options(useGeneratedKeys = true, keyProperty = "user.id", keyColumn = "id")
    public int insertPojo(@Param("user") User user);
}
