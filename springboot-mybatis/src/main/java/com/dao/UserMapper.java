package com.dao;

import com.dao.provider.SqlProvider;
import com.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

//@Mapper //配置了@MapperScan可以省略
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    public List<User> findByName(@Param("name") String name);

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

    @Insert({"INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})"})
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(@Param("name") String name, @Param("age") Integer age);

    /**
     * 参数中包含enum
     *
     * @param user
     * @return
     */
    @Insert({"INSERT INTO USER(NAME, AGE,SEX) VALUES(#{user.name}, #{user.age},#{user.sex})"})
    @Options(useGeneratedKeys = true, keyProperty = "user.id", keyColumn = "id")
    public int insertPojo(@Param("user") User user);

    @InsertProvider(type = SqlProvider.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insertProvider(Object obj);

    @InsertProvider(type = SqlProvider.class, method = "insertNormal")
    @Options(useGeneratedKeys = true, keyProperty = "user.id", keyColumn = "id")
    public int insertDynamic(@Param("user") User user);

    @Delete({"DELETE FROM USER"})
    public boolean clear();
}
