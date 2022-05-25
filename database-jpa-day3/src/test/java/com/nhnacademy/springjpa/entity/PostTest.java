package com.nhnacademy.springjpa.entity;


import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.repository.BoardTypeRepository;
import com.nhnacademy.springjpa.repository.PostRepository;
import com.nhnacademy.springjpa.repository.UserRepository;
import com.nhnacademy.springjpa.repository.UserTypeRepository;
import java.sql.Timestamp;
import java.util.Date;
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
    UserTypeRepository userTypeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardTypeRepository boardTypeRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    public void testPostEntity(){
        UserType userType1 = new UserType();
        userType1.setCode(1);
        userType1.setValue("관리자");
        userTypeRepository.save(userType1);

        User user1 = new User();
        user1.setId("admin1");
        user1.setNickname("관리자1");
        user1.setPassword("1234");
        user1.setType(userType1);
        userRepository.save(user1);

        BoardType boardType1 = new BoardType();
        boardType1.setCode(1);
        boardType1.setValue("일반게시판");
        boardTypeRepository.save(boardType1);

        Post post1 = new Post();
        post1.setTitle("제목");
        post1.setContent("본문내용");
        post1.setWriteDateTime(new Timestamp(new Date().getTime()));
        post1.setUser(user1);
        post1.setReplyOrder(0);
        post1.setType(boardType1);
        post1.setDeleteFlag(false);
        postRepository.save(post1);

        assertThat(post1.getUser().getId()).isEqualTo(user1.getId());
    }
}