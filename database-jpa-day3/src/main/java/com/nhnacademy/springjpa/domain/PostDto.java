package com.nhnacademy.springjpa.domain;

import java.time.LocalDateTime;

public interface PostDto {
    Integer getNo();
    String getTitle();
    String getContent();
    LocalDateTime getWriteDateTime();
    UserDto getUser();
    ModifierDto getModifier();

    interface UserDto{
        String getNickname();
    }

    interface ModifierDto{
        String getNickname();
    }
}
