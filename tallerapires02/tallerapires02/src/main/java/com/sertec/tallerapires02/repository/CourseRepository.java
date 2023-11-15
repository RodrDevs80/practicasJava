package com.sertec.tallerapires02.repository;

import com.sertec.tallerapires02.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Page<Course> findByActiveTrue(Pageable pageable);
}
