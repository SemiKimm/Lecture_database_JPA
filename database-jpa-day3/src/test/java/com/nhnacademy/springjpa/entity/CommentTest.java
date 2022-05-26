package com.nhnacademy.springjpa.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.repository.BoardTypeRepository;
import com.nhnacademy.springjpa.repository.CommentRepository;
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
class CommentTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void testCommentEntity(){
        UserType userType = new UserType();
        userType.setValue("일반");

        User user1 = User.create("user1", "1234", "사용자", userType);

        BoardType boardType1 = new BoardType();
        boardType1.setValue("일반게시판");

        Post post1 = Post.create("제목", "내용", user1, boardType1);

        Comment comment = Comment.create("내용", user1, post1);
        commentRepository.saveAndFlush(comment);

        Comment result = commentRepository.findById(comment.getNo()).orElse(null);
        assertThat(result).isNotNull();
        assertThat(result.getNo()).isEqualTo(comment.getNo());
        assertThat(result.getContent()).isEqualTo(comment.getContent());
        assertThat(result.getUser().getNo()).isEqualTo(user1.getNo());
        assertThat(result.getPost().getNo()).isEqualTo(post1.getNo());
    }
}