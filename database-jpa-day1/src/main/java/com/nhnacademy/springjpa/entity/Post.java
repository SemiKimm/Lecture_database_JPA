package com.nhnacademy.springjpa.entity;

import java.util.Date;
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
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_no")
    private Integer no;
    @Column(name = "post_title")
    private String title;
    @Column(name = "post_content")
    private String content;
    @Column(name = "write_datetime")
    private Date writeDateTime;
    @Column(name = "reply_order")
    private Integer replyOrder;
    @Column(name = "modify_datetime")
    private Date modifyDateTime;
    @Column(name = "is_delete")
    private boolean deleteFlag;
}
