package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class GoodPk implements Serializable {
    @MapsId
    @ManyToOne
    @JoinColumn(name = "post_no", nullable = false)
    private Post post;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "user_no", nullable = false)
    private User user;
}
