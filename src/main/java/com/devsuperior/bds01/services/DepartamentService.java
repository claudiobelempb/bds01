package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartamentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  @Transactional(readOnly = true)
  public List<DepartamentDTO> index(){
    List<Department> departments = departmentRepository.findAll(Sort.by("name"));
    return departments.stream().map(DepartamentDTO::new).collect(Collectors.toList());
  }
}
