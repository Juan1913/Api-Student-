package com.jm.apistudent.repository;

import com.jm.apistudent.entity.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentCourseEntityRepository extends JpaRepository<StudentCourseEntity, Long> {

    Optional<StudentCourseEntity> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
