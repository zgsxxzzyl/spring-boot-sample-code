package com.master.mapper;

import com.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

//@Mapper //配置了@MapperScan可以省略
public interface MasterUserMapper {

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
