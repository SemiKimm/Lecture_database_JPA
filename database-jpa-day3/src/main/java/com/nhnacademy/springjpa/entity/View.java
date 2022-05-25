package com.nhnacademy.springjpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "view")
public class View {
    @EmbeddedId
    private ViewPk pk;
}
