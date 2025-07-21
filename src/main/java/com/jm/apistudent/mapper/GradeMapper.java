package com.jm.apistudent.mapper;

import com.jm.apistudent.dto.GradeDTO;
import com.jm.apistudent.entity.GradeEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GradeMapper {

    // Al convertir de Entity a DTO: extraer IDs
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "courseId", source = "course.id")
    GradeDTO fromGradeEntityToGradeDTO(GradeEntity gradeEntity);

    // Al convertir de DTO a Entity: ignorar las relaciones (las asignamos en el servicio)
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "course", ignore = true)
    GradeEntity fromGradeDTOToGradeEntity(GradeDTO gradeDTO);
}
