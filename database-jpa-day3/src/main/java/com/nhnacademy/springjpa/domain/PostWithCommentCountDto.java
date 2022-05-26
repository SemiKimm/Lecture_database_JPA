package com.nhnacademy.springjpa.domain;

public interface PostWithCommentCountDto {
    PostDto getPostDto();
    Integer getCount();
}
