package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.PostDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDto findPostBy(Integer postNo);
    List<PostDto> findPostsNotDeleted(Pageable pageable);
    List<PostDto> findPostsDeleted(Pageable pageable);
    Integer deletePost(Integer postNo);
    Integer modifyPost(Integer postNo, String title, String content);
}
