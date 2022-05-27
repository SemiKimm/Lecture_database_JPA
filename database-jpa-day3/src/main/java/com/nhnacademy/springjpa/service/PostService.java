package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.request.PostRegisterRequest;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDto findPostBy(Integer postNo);

    List<PostDto> findPostsNotDeleted(Pageable pageable);

    List<PostDto> findPostsDeleted(Pageable pageable);

    Integer deletePost(Integer postNo);

    Integer modifyPost(Integer postNo, String title, String content);

    Post registerPost(Integer userNo, PostRegisterRequest request);
}
