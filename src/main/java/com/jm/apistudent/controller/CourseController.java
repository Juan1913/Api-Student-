package com.jm.apistudent.controller;

import com.jm.apistudent.dto.CourseDTO;
import com.jm.apistudent.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @GetMapping
    public List<CourseDTO> findAll() {
        return courseService.findAll();
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Validated @RequestBody CourseDTO courseDTO) {
        CourseDTO savedCourse = courseService.save(courseDTO);
        return ResponseEntity.ok(savedCourse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.ok().build();

    }
}
