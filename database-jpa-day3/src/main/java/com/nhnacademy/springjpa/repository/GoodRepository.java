package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Good;
import com.nhnacademy.springjpa.entity.GoodPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, GoodPk> {
}
