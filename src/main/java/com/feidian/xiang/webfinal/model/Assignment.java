package com.feidian.xiang.webfinal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Assignment {
    @Id
    private Long id;

    private String name;

    private String description;

}
