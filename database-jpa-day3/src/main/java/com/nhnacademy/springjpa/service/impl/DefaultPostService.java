package com.nhnacademy.springjpa.service.impl;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.repository.PostRepository;
import com.nhnacademy.springjpa.service.PostService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class DefaultPostService implements PostService {
    private final PostRepository postRepository;

    public DefaultPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
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
    public List<PostDto> findPostsNotDeleted() {
        return postRepository.findAllByDeleteFlag(false);
    }

    @Override
    public List<PostDto> findPostsDeleted() {
        return postRepository.findAllByDeleteFlag(true);
    }

    @Override
    public Integer deletePost(Integer postNo) {
        return postRepository.updateDeletedFlag(postNo);
    }

    @Override
    public Integer modifyPost(Integer postNo, String title, String content) {
        if(!hasPost(postNo)){
            throw new NoSuchElementException();
        }
        return postRepository.updatePost(postNo, title, content);
    }

    private boolean hasPost(Integer postNo) {
        return Objects.nonNull(postRepository.getPostByNo(postNo).orElse(null));
    }
}
