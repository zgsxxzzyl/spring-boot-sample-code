package com.domain.order;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "orders")        //order这个名字会报错
@Data
@EqualsAndHashCode(exclude = {"id"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false)
    private Integer code;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
