package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_no")
    private Integer no;

    @Column(name = "user_id")
    private String id;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_nickname")
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "user_type_code")
    private UserType type;
}
