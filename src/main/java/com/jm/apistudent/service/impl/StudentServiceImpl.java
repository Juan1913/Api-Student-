package com.jm.apistudent.service.impl;

import com.jm.apistudent.dto.StudentDTO;
import com.jm.apistudent.entity.StudentEntity;
import com.jm.apistudent.exception.NotFoundException;
import com.jm.apistudent.exception.NotSaveException;
import com.jm.apistudent.mapper.StudentMapper;
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
    private final StudentMapper studentMapper;


    @Override
    public void save(StudentDTO studentDTO) {

        try {
            StudentEntity studentEntity = studentMapper.fromStudentDTOToStudentEntity(studentDTO);
            studentEntityRepository.save(studentEntity);
        } catch (Exception e) {
            throw new NotSaveException("No se pudo guardar el estudiante: " + e.getMessage());
        }

    }

    @Override
    public List<StudentDTO> findAll() {
        return studentEntityRepository.findAll().stream()
                .map(studentMapper::fromStudentEntityToStudentDTO)
                .toList();
    }

    @Override
    public StudentDTO findById(Long id) {
        return studentMapper.fromStudentEntityToStudentDTO(
                studentEntityRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con ID: " + id))
        );
    }

    @Override
    public void delete(Long id) {
        if (!studentEntityRepository.existsById(id)) {
            throw new NotFoundException("Estudiante no encontrado con ID: " + id);
        }
        studentEntityRepository.deleteById(id);
    }
}
