package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class GoodPk implements Serializable {
    @MapsId
    @OneToOne
    @JoinColumn(name = "post_no")
    private Post post;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_no")
    private User user;
}
