package com.jm.apistudent.service.impl;

import com.jm.apistudent.dto.CourseDTO;
import com.jm.apistudent.entity.CourseEntity;
import com.jm.apistudent.exception.NotFoundException;
import com.jm.apistudent.exception.NotSaveException;
import com.jm.apistudent.mapper.CourseMapper;
import com.jm.apistudent.mapper.GradeMapper;
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
    private final GradeMapper gradeMapper;

    @Override
    public void save(CourseDTO courseDTO) {
        try {
            CourseEntity courseEntity = courseMapper.fromCourseDTOToCourseEntity(courseDTO);
            courseEntityRepository.save(courseEntity);
        } catch (Exception e) {
            throw new NotSaveException("No se pudo guardar el curso: " + e.getMessage());
        }
    }

    @Override
    public CourseDTO findById(Long id) {
        return courseMapper.fromCourseEntityToCourseDTO(courseEntityRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Curso no encontrado con ID" + id))
        );
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseEntityRepository.findAll().stream()
                .map(courseMapper::fromCourseEntityToCourseDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!courseEntityRepository.existsById(id)) {
            throw new NotFoundException("Curso no encontrado con ID: " + id);
        }
        // Eliminar las calificaciones asociadas al curso antes de eliminar el curso
        //gradeEntityRepository.deleteAllByCourseId(id);
        courseEntityRepository.deleteById(id);
    }
}
