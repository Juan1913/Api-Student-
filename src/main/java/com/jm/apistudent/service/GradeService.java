package com.jm.apistudent.service;

import com.jm.apistudent.dto.GradeDTO;

import java.util.List;

public interface GradeService {

    void save(GradeDTO gradeDTO);

    GradeDTO findById(Long id);

    List<GradeDTO> findAll();

    void delete(Long id);
}
