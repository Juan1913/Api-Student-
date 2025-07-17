package com.jm.apistudent.service;

import com.jm.apistudent.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    void save(StudentDTO studentDTO);

    List<StudentDTO> findAll();

    StudentDTO findById(Long id);

    void delete(Long id);
}
