package com.devsuperior.bds01.dto;

import com.devsuperior.bds01.entities.Department;

import java.io.Serializable;

public class DepartamentDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;

  public DepartamentDTO(){}

  public DepartamentDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public DepartamentDTO(Department department) {
    id = department.getId();
    name = department.getName();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
