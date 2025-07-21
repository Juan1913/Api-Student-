package com.jm.apistudent.service.impl;

import com.jm.apistudent.dto.GradeDTO;
import com.jm.apistudent.entity.GradeEntity;
import com.jm.apistudent.exception.NotFoundException;
import com.jm.apistudent.mapper.GradeMapper;
import com.jm.apistudent.repository.CourseEntityRepository;
import com.jm.apistudent.repository.GradeEntityRepository;
import com.jm.apistudent.repository.StudentCourseEntityRepository;
import com.jm.apistudent.repository.StudentEntityRepository;
import com.jm.apistudent.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    final GradeEntityRepository gradeEntityRepository;
    final StudentEntityRepository studentEntityRepository;
    final CourseEntityRepository courseEntityRepository;
    private final GradeMapper gradeMapper;
    private final StudentCourseEntityRepository studentCourseEntityRepository;


    @Override
    public void save(GradeDTO gradeDTO) {
        GradeEntity gradeEntity = gradeMapper.fromGradeDTOToGradeEntity(gradeDTO);

        gradeEntity.setStudent(studentEntityRepository.findById(gradeDTO.getStudentId())
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));

        gradeEntity.setCourse(courseEntityRepository.findById(gradeDTO.getCourseId())
                .orElseThrow(() -> new NotFoundException("Curso no encontrado")));

        gradeEntityRepository.save(gradeEntity);
    }




    @Override
    public GradeDTO findById(Long id) {

        return gradeMapper.fromGradeEntityToGradeDTO(gradeEntityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException ("Calificación no encontrada" + id))
        );
    }

    @Override
    public List<GradeDTO> findAll() {
        return gradeEntityRepository.findAll().stream()
                .map(gradeMapper::fromGradeEntityToGradeDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!gradeEntityRepository.existsById(id)) {
            throw new NotFoundException("Calificación no encontrada con ID: " + id);
        }
        gradeEntityRepository.deleteById(id);
    }
}
