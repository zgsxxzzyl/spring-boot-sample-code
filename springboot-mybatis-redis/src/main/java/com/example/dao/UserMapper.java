package com.example.dao;

import com.example.dao.provider.SqlProvider;
import com.example.entity.User;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    List<User> findByName(@Param("name") String name);

//    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
//    int insert(@Param("name") String name, @Param("age") Integer age);

    @InsertProvider(type = SqlProvider.class, method = "insert")
    int insert(Object obj);
}
