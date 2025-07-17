package com.jm.apistudent.repository;

import com.jm.apistudent.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEntityRepository extends JpaRepository<CourseEntity, Long> {
}
