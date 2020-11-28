package com.dao;

import com.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("delete from User where username = :name")
    public void deleteUserByUsername(String name);

    @Query("update User set username = :name where id=:id")
    public void updateUserById(Long id, String name);
}
