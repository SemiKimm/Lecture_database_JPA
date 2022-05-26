package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends PostRepositoryCustom, JpaRepository<Post, Integer> {
    List<PostDto> findAllByDeleteFlag(boolean deleteFlag);

    List<PostDto> findAllByTitleContaining(String searchKeyword);

    List<PostDto> findAllByUser(User user);

    @Query("select g "
        + "from Good g "
        + "inner join fetch g.pk.post p where g.pk.user = ?1")
    List<PostDto> getPostDtoByUserAndGood(User user);


}
