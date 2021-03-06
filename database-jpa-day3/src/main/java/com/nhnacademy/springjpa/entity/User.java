package com.nhnacademy.springjpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", nullable = false)
    private Integer no;

    @Column(name = "user_id", nullable = false)
    private String id;
    @Column(name = "user_password", nullable = false)
    private String password;
    @Column(name = "user_nickname", nullable = false)
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "user_type_code", nullable = false)
    private UserType type;

    public static User create(String id, String password, String nickname, UserType type) {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setType(type);
        return user;
    }

}
