package com.example;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        if ("MAN".equals(resultSet.getString("sex"))) {
            user.setSex(User.Sex.MAN);
        } else {
            user.setSex(User.Sex.WOMAN);
        }
        return user;
    }
}
