package com.jm.apistudent.repository;

import com.jm.apistudent.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, Long> {


}
