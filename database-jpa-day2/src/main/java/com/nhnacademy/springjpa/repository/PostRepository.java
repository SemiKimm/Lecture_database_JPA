package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
