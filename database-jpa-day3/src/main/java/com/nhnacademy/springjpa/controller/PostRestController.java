package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.request.ModifyRequest;
import com.nhnacademy.springjpa.service.PostService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostRestController {
    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/view/{postNo}")
    public PostDto getPost(@PathVariable("postNo") Integer postNo) {
        return postService.findPostBy(postNo);
    }

    @GetMapping("/list/all")
    public List<PostDto> getPostsNotDeleted(Pageable pageable) {
        return postService.findPostsNotDeleted(pageable);
    }

    @GetMapping("/list/deleted")
    public List<PostDto> getPostsDeleted(Pageable pageable) {
        return postService.findPostsDeleted(pageable);
    }

    @GetMapping("/delete/{postNo}")
    public Integer doDeletePost(@PathVariable("postNo") Integer postNo) {
        return postService.deletePost(postNo);
    }

    @PostMapping("/modify/{postNo}")
    public Integer doUpdatePost(@PathVariable("postNo") Integer postNo,
                                @Valid @RequestBody ModifyRequest request) {
        return postService.modifyPost(postNo, request.getTitle(), request.getContent());
    }
}
