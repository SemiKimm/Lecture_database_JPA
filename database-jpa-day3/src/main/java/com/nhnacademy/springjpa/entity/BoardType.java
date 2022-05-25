package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "board_type")
public class BoardType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_type_code")
    private Integer code;
    @Column(name = "board_code_value")
    private String value;
}
