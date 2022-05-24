package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardTypeRepository extends JpaRepository<BoardType,Integer> {
}
