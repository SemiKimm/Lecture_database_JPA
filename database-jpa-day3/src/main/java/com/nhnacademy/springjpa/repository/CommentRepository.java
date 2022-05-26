package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.CommentDto;
import com.nhnacademy.springjpa.entity.Comment;
import com.nhnacademy.springjpa.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<CommentDto> getAllBy();
    List<CommentDto> getAllByPost(Post post);
}
