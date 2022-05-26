package com.nhnacademy.springjpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.domain.PostDto;
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
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void findAllBy() {
        List<Post> result = postRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void findAllByDeleteFlag_isFalse(){
        List<PostDto> result = postRepository.findAllByDeleteFlag(false);
        assertThat(result).isNotEmpty().hasSize(2);
    }

    @Test
    void findAllByDeleteFlag_isTrue(){
        List<PostDto> result = postRepository.findAllByDeleteFlag(true);
        assertThat(result).isEmpty();
    }

    @Test
    void findAllByTitleContaining(){
        List<PostDto> result = postRepository.findAllByTitleContaining("안");
        assertThat(result).isNotEmpty().hasSize(1);
    }

    @Test
    void findAllByUser(){
        List<PostDto> result = postRepository.findAllByUser(userRepository.findById(1).orElse(null));
        assertThat(result).isNotEmpty().hasSize(3);
    }
}