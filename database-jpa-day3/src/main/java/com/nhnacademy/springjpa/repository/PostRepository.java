package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends PostRepositoryCustom, JpaRepository<Post, Integer> {
    List<PostDto> findAllByDeleteFlag(boolean deleteFlag, Pageable pageable);

    List<PostDto> findAllByTitleContaining(String searchKeyword);

    List<PostDto> findAllByUser(User user);

    @Query("select g "
        + "from Good g "
        + "inner join fetch g.pk.post p where g.pk.user = ?1")
    List<PostDto> getPostDtoByUserAndGood(User user);

    Optional<PostDto> getPostByNo(Integer postNo);

    @Transactional
    @Modifying
    @Query("update Post p set p.deleteFlag = 1 where p.no = :postNo")
    int updateDeletedFlag(@Param("postNo") Integer postNo);

    @Transactional
    @Modifying
    @Query("update Post p set p.title = :title, p.content = :content where p.no = :postNo")
    int updatePost(@Param("postNo") Integer postNo,
                   @Param("title") String title,
                   @Param("content") String content);

}
