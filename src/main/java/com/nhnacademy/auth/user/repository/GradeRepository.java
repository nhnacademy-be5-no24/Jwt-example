package com.nhnacademy.auth.user.repository;

import com.nhnacademy.auth.user.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Long> {
}
