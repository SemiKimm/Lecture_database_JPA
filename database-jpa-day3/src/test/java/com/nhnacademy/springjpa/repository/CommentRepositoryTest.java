package com.nhnacademy.springjpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.domain.CommentDto;
import com.nhnacademy.springjpa.entity.Comment;
import com.nhnacademy.springjpa.entity.Post;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;

    @Test
    void findAll(){
        List<Comment> result =  commentRepository.findAll();
        assertThat(result).isNotEmpty().hasSize(3);
    }

    @Test
    void getAllBy(){
        List<CommentDto> result =  commentRepository.getAllBy();
        assertThat(result).isNotEmpty().hasSize(3);
    }

    @Test
    void getAllByPost(){
        Post post = postRepository.findById(3).orElse(null);

        List<CommentDto> result = commentRepository.getAllByPost(post);
        assertThat(result).isNotEmpty().hasSize(2);
    }
}