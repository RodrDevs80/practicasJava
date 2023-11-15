package com.sertec.tallerapires02.controller;

import com.sertec.tallerapires02.model.*;
import com.sertec.tallerapires02.repository.CourseRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
   private CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @GetMapping
    public ResponseEntity<Page<ResponseCourses>> listCourses(Pageable pageable){
      return ResponseEntity.ok(courseRepository.findByActiveTrue(pageable).map(ResponseCourses::new));
    }
    @PostMapping
    public ResponseEntity<ResponseCourses> createCourses
            (@RequestBody @Valid DataRegisterCourse dataRegisterCourse){
       Course course= courseRepository
                .save(new Course(dataRegisterCourse.id(),
                        dataRegisterCourse.title(), dataRegisterCourse.price()));
       ResponseCourses responseCourses=
               new ResponseCourses(course.getId(), course.getTitle(), course.getPrice());
        URI url= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(course.getId()).toUri();
       return ResponseEntity.created(url).body(responseCourses);

    }
    //logical deletion
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity  deleteCourseById(@PathVariable Long id){
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (!optionalCourse.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        Course course=optionalCourse.get();
        course.deactivate(optionalCourse.get());
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/deleteBD/{id}")
    public ResponseEntity  deleteCourseByIdDB(@PathVariable Long id){
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (!optionalCourse.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        courseRepository.deleteById(optionalCourse.get().getId());
        return ResponseEntity.noContent().build();

    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseCourseUpdate> updateCourse
            (@RequestParam Long id,@RequestBody DataUpdateCourse dataUpdateCourse){
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (!optionalCourse.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        Course course=optionalCourse.get();
        course.updateCourse(dataUpdateCourse);
        ResponseCourseUpdate responseCourseUpdate=
                new ResponseCourseUpdate(course.getId(), course.getTitle(), course.getPrice());
        return ResponseEntity.ok(responseCourseUpdate);
    }
    //listar active false.

}
