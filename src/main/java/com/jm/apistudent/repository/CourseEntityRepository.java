package com.jm.apistudent.repository;

import com.jm.apistudent.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseEntityRepository extends JpaRepository<CourseEntity, Long> {

    Optional<CourseEntity> findByName(String name);
}
