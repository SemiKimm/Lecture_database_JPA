package com.nhnacademy.springjpa.entity;

import java.time.LocalDateTime;
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
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no", nullable = false)
    private Integer no;
    @Column(name = "post_title", nullable = false)
    private String title;
    @Column(name = "post_content", nullable = false)
    private String content;
    @Column(name = "write_datetime", nullable = false)
    private LocalDateTime writeDateTime;
    @Column(name = "is_delete", nullable = false)
    private boolean deleteFlag;
    @Column(name = "modify_datetime", nullable = true)
    private LocalDateTime modifyDateTime;
    @Column(name = "top_post_no", nullable = true)
    private Integer topPostNo;
    @Column(name = "reply_order", nullable = true)
    private Integer replyOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_type_code", nullable = false)
    private BoardType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modifier_user_no", nullable = true)
    private User modifier;

    public static Post create(String title, String content, User user, BoardType type){
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setWriteDateTime(LocalDateTime.now());
        post.setDeleteFlag(false);
        post.setUser(user);
        post.setType(type);

        return post;
    }
}
