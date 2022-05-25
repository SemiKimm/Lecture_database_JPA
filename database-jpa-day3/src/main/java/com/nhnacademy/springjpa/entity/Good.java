package com.nhnacademy.springjpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "good")
public class Good {
    @EmbeddedId
    private GoodPk pk;
}
