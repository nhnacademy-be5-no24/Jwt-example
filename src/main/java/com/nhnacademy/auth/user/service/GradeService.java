package com.nhnacademy.auth.user.service;

import com.nhnacademy.auth.user.dto.GradeCreateDto;
import com.nhnacademy.auth.user.entity.Grade;

public interface GradeService {
    Grade getGrade(Long id);

    Grade createGrade(GradeCreateDto gradeCreateDto);

    Grade modifyGrade(Long id, GradeCreateDto gradeCreateDto);

    void deleteGrade(Long id);

}
