package com.jm.apistudent.mapper;
import com.jm.apistudent.dto.CourseDTO;
import com.jm.apistudent.entity.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CourseMapper {


    CourseDTO fromCourseEntityToCourseDTO(CourseEntity courseEntity);


    CourseEntity fromCourseDTOToCourseEntity(CourseDTO courseDTO);


}
