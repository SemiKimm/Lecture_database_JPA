package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.PostWithCommentCountDto;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PostRepositoryCustom {
    List<Post> getPostsByUserAndGood(User user);

    List<PostWithCommentCountDto> getPostsWithCommentCount();
}
