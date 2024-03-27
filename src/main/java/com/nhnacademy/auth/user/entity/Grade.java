package com.nhnacademy.auth.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_id")
    private Long gradeId;
    @Column(name = "grade_name")
    private String gradeName;
    @Column(name = "accumulate_rate")
    private Long accumulateRate;
}
