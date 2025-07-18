package com.jm.apistudent.service;

import com.jm.apistudent.dto.CourseDTO;


import java.util.List;

public interface CourseService {

    void save(CourseDTO courseDTO);

    CourseDTO findById(Long id);

    List<CourseDTO> findAll();

    void delete(Long id);
}
