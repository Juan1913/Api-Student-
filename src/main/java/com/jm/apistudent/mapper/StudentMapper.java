package com.jm.apistudent.mapper;

import com.jm.apistudent.dto.StudentDTO;
import com.jm.apistudent.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StudentMapper {

    StudentDTO fromStudentEntityToStudentDTO(StudentEntity studentEntity);

    StudentEntity fromStudentDTOToStudentEntity(StudentDTO studentDTO);

}
