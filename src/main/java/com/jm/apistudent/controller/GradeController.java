package com.jm.apistudent.controller;


import com.jm.apistudent.dto.GradeDTO;
import com.jm.apistudent.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/grades")
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("/{id}")
    public GradeDTO findById(@PathVariable Long id) {
        return gradeService.findById(id);
        }
}

