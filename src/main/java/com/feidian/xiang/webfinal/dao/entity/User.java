package com.feidian.xiang.webfinal.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * @author xiang
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    private Long id;

    private String password;

    private short userType;

}
