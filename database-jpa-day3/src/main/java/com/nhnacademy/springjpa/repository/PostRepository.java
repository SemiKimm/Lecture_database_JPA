package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<PostDto> findAllByDeleteFlag(boolean deleteFlag);
    List<PostDto> findAllByTitleContaining(String searchKeyword);
    List<PostDto> findAllByUser(User user);
}
