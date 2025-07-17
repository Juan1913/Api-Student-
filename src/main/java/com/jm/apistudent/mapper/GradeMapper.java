package com.jm.apistudent.mapper;
import com.jm.apistudent.dto.GradeDTO;
import com.jm.apistudent.entity.GradeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface GradeMapper {

    GradeDTO fromGradeEntityToGradeDTO(GradeEntity gradeEntity);
    GradeEntity fromGradeDTOToGradeEntity(GradeDTO gradeDTO);
}
