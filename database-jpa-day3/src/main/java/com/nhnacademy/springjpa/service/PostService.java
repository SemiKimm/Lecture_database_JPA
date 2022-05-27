package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.PostDto;
import java.util.List;

public interface PostService {
    PostDto findPostBy(Integer postNo);
    List<PostDto> findPostsNotDeleted();
    List<PostDto> findPostsDeleted();
    Integer deletePost(Integer postNo);
    Integer modifyPost(Integer postNo, String title, String content);
}
