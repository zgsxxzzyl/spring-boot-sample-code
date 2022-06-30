package com.service;

import com.model.master.User;
import com.repository.master.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class SampleServiceImpl implements SampleService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private DataSource dataSource;

    @Override
    @Transactional
    public void saveDemo() {
        User user = new User();
        user.setAge(18);
        user.setName("zhang三");
        userRepository.save(user);
//        int i = 1 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, timeout = 3600)
    public void problem() throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user(age,name) values (?,?)");
            for (int i = 0; i < 10; i++) {
                preparedStatement.setInt(1, 18);
                preparedStatement.setString(2, "name");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
            connection.close();
        }
    }
}
