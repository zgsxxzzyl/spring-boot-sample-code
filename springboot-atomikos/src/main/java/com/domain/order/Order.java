package com.domain.order;

import javax.persistence.*;

@Entity
@Table(name = "orders")        //order这个名字会报错
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false)
    private Integer code;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Order() {
    }

    public Order(Integer id, Integer code, Integer quantity) {
        this.id = id;
        this.code = code;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
