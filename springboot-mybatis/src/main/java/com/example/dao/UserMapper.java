package com.example.dao;

import com.example.dao.provider.SqlProvider;
import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    public List<User> findByName(@Param("name") String name);

    @Select("SELECT * FROM USER")
    public List<User> queryAll();

    @Insert({"INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})"})
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert({"INSERT INTO USER(NAME, AGE) VALUES(#{user.name}, #{user.age})"})
    @Options(useGeneratedKeys = true,keyProperty = "user.id",keyColumn = "id")
    public int insertPojo(@Param("user") User user);

    @InsertProvider(type = SqlProvider.class,method = "insert")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public int insertProvider(Object obj);

    @Delete({"DELETE FROM USER"})
    public boolean clear();

}
