package com.nhnacademy.springjpa.domain;

public interface CommentDto {
    Integer getNo();
    String getContent();
    UserDto getUser();

    interface UserDto{
        String getNickname();
    }
}
