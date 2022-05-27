package com.nhnacademy.springjpa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    void findAll() {
        List<Post> result = postRepository.findAll();
        assertThat(result.size()).isEqualTo(7);
    }

    @Test
    void findAllByDeleteFlag_isFalse(){
        List<PostDto> result = postRepository.findAllByDeleteFlag(false, Pageable.unpaged());
        assertThat(result).isNotEmpty().hasSize(6);
    }

    @Test
    void findAllByDeleteFlag_isTrue(){
        List<PostDto> result = postRepository.findAllByDeleteFlag(true, Pageable.unpaged());
        assertThat(result).isNotEmpty().hasSize(1);
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

    @Test
    void getPostsByUserAndGood_isEmpty(){
        User user = userRepository.findById(2).orElse(null);

        List<Post> result = postRepository.getPostsByUserAndGood(user);
        assertThat(result).isEmpty();
    }

    @Test
    void getPostsByUserAndGood_isExist(){
        User user = userRepository.findById(1).orElse(null);

        List<Post> result = postRepository.getPostsByUserAndGood(user);
        assertThat(result).isNotEmpty().hasSize(2);
    }

    @Test
    void getPostDtoByUserAndGood(){
        User user = userRepository.findById(1).orElse(null);

        List<PostDto> result = postRepository.getPostDtoByUserAndGood(user);
        assertThat(result).isNotEmpty().hasSize(2);
    }

    @Test
    void updateDeletedFlag(){
        int result = postRepository.updateDeletedFlag(3);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void updatePost(){
        int result = postRepository.updatePost(3,"제목수정", "내용수정");
        PostDto updatedPost = postRepository.getPostByNo(3).orElse(null);
        assertThat(result).isEqualTo(1);
        assertThat(updatedPost).isNotNull();
        assertThat(updatedPost.getTitle()).isEqualTo("제목수정");
        assertThat(updatedPost.getContent()).isEqualTo("내용수정");
    }
}