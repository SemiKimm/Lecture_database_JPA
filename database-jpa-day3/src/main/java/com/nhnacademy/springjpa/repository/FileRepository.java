package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {
}
