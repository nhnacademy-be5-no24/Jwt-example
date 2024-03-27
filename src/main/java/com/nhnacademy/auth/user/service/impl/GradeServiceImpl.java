package com.nhnacademy.auth.user.service.impl;

import com.nhnacademy.auth.user.dto.GradeCreateDto;
import com.nhnacademy.auth.user.entity.Grade;
import com.nhnacademy.auth.user.repository.GradeRepository;
import com.nhnacademy.auth.user.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;

    @Override
    public Grade getGrade(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    @Override
    public Grade createGrade(GradeCreateDto gradeCreateDto) {
        Grade grade = new Grade();
        grade.setGradeName(gradeCreateDto.getGradeName());
        grade.setAccumulateRate(gradeCreateDto.getAccumulateRate());
        return gradeRepository.save(grade);
    }

    @Override
    public Grade modifyGrade(Long id, GradeCreateDto gradeCreateDto) {
        Grade grade = gradeRepository.findById(id).orElse(null);
        grade.setGradeName(gradeCreateDto.getGradeName());
        grade.setAccumulateRate(gradeCreateDto.getAccumulateRate());
        return gradeRepository.save(grade);

    }

    @Override
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
