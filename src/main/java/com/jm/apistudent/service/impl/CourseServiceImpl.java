package com.jm.apistudent.service.impl;

import com.jm.apistudent.dto.CourseDTO;
import com.jm.apistudent.entity.CourseEntity;
import com.jm.apistudent.mapper.CourseMapper;
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
    private final CourseMapper courseMapper;

    @Override
    public void save( CourseDTO courseDTO) {

        CourseEntity courseEntity = courseMapper.fromCourseDTOToCourseEntity(courseDTO);

    }

    @Override
    public CourseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<CourseDTO> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
