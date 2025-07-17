package com.jm.apistudent.service.impl;

import com.jm.apistudent.dto.StudentDTO;
import com.jm.apistudent.repository.CourseEntityRepository;
import com.jm.apistudent.repository.GradeEntityRepository;
import com.jm.apistudent.repository.StudentEntityRepository;
import com.jm.apistudent.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentEntityRepository studentEntityRepository;
    private final GradeEntityRepository gradeEntityRepository;
    private final CourseEntityRepository courseEntityRepository;


    @Override
    public void save(StudentDTO studentDTO) {

    }

    @Override
    public List<StudentDTO> findAll() {
        return List.of();
    }

    @Override
    public StudentDTO findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
