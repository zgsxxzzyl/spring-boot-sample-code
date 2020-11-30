package com.vo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_USERS")
@SequenceGenerator(name = "ID_SEQ", sequenceName = "seq_Id", allocationSize = 1)    //定义一个生成主键的序列
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
    private Long id;
    private String username;

    public User() {
    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
