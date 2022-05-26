package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.PostWithCommentCountDto;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.QComment;
import com.nhnacademy.springjpa.entity.QGood;
import com.nhnacademy.springjpa.entity.QPost;
import com.nhnacademy.springjpa.entity.User;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {
    public PostRepositoryImpl() {
        super(Post.class);
    }

    @Override
    public List<Post> getPostsByUserAndGood(User user) {
        QGood good = QGood.good;
        QPost post = QPost.post;
        return from(good).innerJoin(good.pk.post, post).where(good.pk.user.eq(user)).select(post)
            .fetch();
    }

    @Override //fixme
    public List<PostWithCommentCountDto> getPostsWithCommentCount() {
        QPost post = QPost.post;
        QComment comment = QComment.comment;

        return from(comment).groupBy(comment.post).select(
            Projections.bean(PostWithCommentCountDto.class
                , post.count()
                , post
                , post.user
                , post.modifier)).fetch();
    }
}
