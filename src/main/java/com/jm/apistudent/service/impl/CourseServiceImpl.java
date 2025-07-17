package com.jm.apistudent.service.impl;

import com.jm.apistudent.dto.GradeDTO;
import com.jm.apistudent.repository.CourseEntityRepository;
import com.jm.apistudent.repository.GradeEntityRepository;
import com.jm.apistudent.repository.StudentEntityRepository;
import com.jm.apistudent.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    final CourseEntityRepository courseEntityRepository;
    final StudentEntityRepository studentEntityRepository;
    final GradeEntityRepository gradeEntityRepository;

    @Override
    public void save(GradeDTO gradeDTO) {

    }

    @Override
    public GradeDTO findById(Long id) {
        return null;
    }

    @Override
    public List<GradeDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
