package com.nhnacademy.springjpa.service.impl;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import com.nhnacademy.springjpa.repository.BoardTypeRepository;
import com.nhnacademy.springjpa.repository.PostRepository;
import com.nhnacademy.springjpa.repository.UserRepository;
import com.nhnacademy.springjpa.request.PostRegisterRequest;
import com.nhnacademy.springjpa.service.PostService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultPostService implements PostService {
    private final BoardTypeRepository boardTypeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public DefaultPostService(
        BoardTypeRepository boardTypeRepository,
        PostRepository postRepository,
        UserRepository userRepository) {
        this.boardTypeRepository = boardTypeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostDto findPostBy(Integer postNo) {
        PostDto post = postRepository.getPostByNo(postNo).orElse(null);
        if (Objects.isNull(post)) {
            throw new NoSuchElementException();
        }
        return post;
    }

    @Override
    public List<PostDto> findPostsNotDeleted(Pageable pageable) {
        return postRepository.findAllByDeleteFlag(false, pageable);
    }

    @Override
    public List<PostDto> findPostsDeleted(Pageable pageable) {
        return postRepository.findAllByDeleteFlag(true, pageable);
    }

    @Override
    public Integer deletePost(Integer postNo) {
        return postRepository.updateDeletedFlag(postNo);
    }

    @Override
    public Integer modifyPost(Integer postNo, String title, String content) {
        if (!hasPost(postNo)) {
            throw new NoSuchElementException();
        }
        return postRepository.updatePost(postNo, title, content);
    }

    @Transactional
    @Override
    public Post registerPost(Integer userNo, PostRegisterRequest request) {
        User writer = userRepository.findById(userNo).orElse(null);
        if (Objects.isNull(writer)) {
            throw new RuntimeException();
        }
        Post post = Post.create(request.getTitle(), request.getContent(), writer,
            boardTypeRepository.findById(1).orElse(null));
        return postRepository.save(post);
    }

    private boolean hasPost(Integer postNo) {
        return Objects.nonNull(postRepository.getPostByNo(postNo).orElse(null));
    }
}
