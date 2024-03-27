package com.nhnacademy.auth.user.controller;

import com.nhnacademy.auth.user.dto.GradeCreateDto;
import com.nhnacademy.auth.user.entity.Grade;
import com.nhnacademy.auth.user.repository.GradeRepository;
import com.nhnacademy.auth.user.service.GradeService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @GetMapping("/grade/{id}")
    public Grade getGrade(@PathVariable Long id) {
        return gradeService.getGrade(id);
    }

    @PostMapping("/grade/create")
    public Grade createGrade(@RequestBody GradeCreateDto gradeCreateDto) {
        return gradeService.createGrade(gradeCreateDto);
    }

    @PutMapping("/grade/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestBody GradeCreateDto gradeCreateDto) {
        return gradeService.modifyGrade(id, gradeCreateDto);
    }

    @DeleteMapping("/grade/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }
}
