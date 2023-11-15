package com.sertec.tallerapires02.model;

import com.sertec.tallerapires02.model.Course;

public record ResponseCourses(Long id, String title, Float price) {
    public ResponseCourses(Course course){
        this(course.getId(), course.getTitle(), course.getPrice());
    }
}
