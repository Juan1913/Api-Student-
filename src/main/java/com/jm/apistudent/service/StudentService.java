package com.jm.apistudent.service;

import com.jm.apistudent.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO save(StudentDTO studentDTO);

    List<StudentDTO> findAll();

    StudentDTO findById(Long id);

    StudentDTO update(Long id, StudentDTO studentDTO);

    void delete(Long id);
}
