package com.junjie.tryredis.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String cname;

    @Column(nullable = false, length = 10)
    private String age;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, length = 4)
    private String sex;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private java.sql.Timestamp birth;
}