package com.devsuperior.bds01.controllers;

import com.devsuperior.bds01.dto.DepartamentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.services.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartamentController {

  @Autowired
  private DepartamentService departamentService;

  @GetMapping
  public ResponseEntity<List<DepartamentDTO>> index() {
    List<DepartamentDTO> departamentDTOS = departamentService.index();
    return ResponseEntity.ok().body(departamentDTOS);
  }
}
