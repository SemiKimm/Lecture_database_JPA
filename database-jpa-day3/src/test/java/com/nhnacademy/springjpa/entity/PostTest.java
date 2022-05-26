package com.nhnacademy.springjpa.entity;


import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.repository.BoardTypeRepository;
import com.nhnacademy.springjpa.repository.PostRepository;
import com.nhnacademy.springjpa.repository.UserRepository;
import com.nhnacademy.springjpa.repository.UserTypeRepository;
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
class PostTest {
    @Autowired
    PostRepository postRepository;

    @Test
    public void testPostEntity(){
        UserType userType1 = new UserType();
        userType1.setCode(1);
        userType1.setValue("관리자");

        User user1 = User.create("admin","1234","관리자", userType1);

        BoardType boardType1 = new BoardType();
        boardType1.setValue("일반게시판");

        Post post1 = Post.create("제목!", "내용!", user1, boardType1);
        postRepository.saveAndFlush(post1);

        Post result = postRepository.findById(post1.getNo()).orElse(null);
        assertThat(result).isNotNull();
        assertThat(result.getUser().getNo()).isEqualTo(user1.getNo());
    }
}