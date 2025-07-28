package com.moboz.dto;

import com.moboz.entitites.Student;

public record CountedEnrollmentForStudent(
        Student student,
        Long count
) {
}
