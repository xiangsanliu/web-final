package com.feidian.xiang.webfinal.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class User {

    private Long id;
    private String password;
    private short userType;
}
