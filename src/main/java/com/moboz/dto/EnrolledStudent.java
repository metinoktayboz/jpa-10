package com.moboz.dto;

import com.moboz.entitites.Enrollment;
import com.moboz.entitites.Student;

public record EnrolledStudent (
        Student student,
        Enrollment enrollment
) {
}
