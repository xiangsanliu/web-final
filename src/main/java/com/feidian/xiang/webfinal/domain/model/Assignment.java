package com.feidian.xiang.webfinal.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Assignment {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

}
