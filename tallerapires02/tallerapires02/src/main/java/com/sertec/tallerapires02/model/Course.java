package com.sertec.tallerapires02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    @NotBlank
    private String title;
    @Column(name = "price")
    @NotNull
    @Positive
    private Float price;
    @Column(name = "active")
    private Boolean active;

    public Course(Long id, String title, Float price) {
        this.active=true;
        this.id=id;
        this.title=title;
        this.price=price;
    }


    public void deactivate(Course course) {
        this.active=false;
    }

    public void updateCourse(DataUpdateCourse dataUpdateCourse) {
        if(this.id!= dataUpdateCourse.id()){
            this.id= dataUpdateCourse.id();
        }
        if(this.title!= dataUpdateCourse.title()){
            this.title= dataUpdateCourse.title();
        }
        if(this.price!= dataUpdateCourse.price()){
            this.price= dataUpdateCourse.price();
        }

    }
}
