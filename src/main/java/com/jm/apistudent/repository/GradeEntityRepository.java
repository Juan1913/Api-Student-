package com.jm.apistudent.repository;

import com.jm.apistudent.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeEntityRepository extends JpaRepository<GradeEntity,Long> {
}
