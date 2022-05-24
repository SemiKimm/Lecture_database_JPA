package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ViewPk implements Serializable {
    @Column(name = "user_no")
    private Integer userNo;

    @Column(name = "post_no")
    private Integer postNo;
}
