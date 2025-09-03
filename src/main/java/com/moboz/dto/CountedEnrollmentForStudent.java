package com.moboz.dto;

import com.moboz.entitites.Student;

public record CountedEnrollmentForStudent(
        String student,
        Long count
) {
}
