package com.devsuperior.bds01.controllers;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public ResponseEntity<Page<EmployeeDTO>> index(Pageable pageable) {
    PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name"));
    Page<EmployeeDTO> employeeDTOS = employeeService.index(pageRequest);
    return ResponseEntity.ok().body(employeeDTOS);
  }

  @PostMapping
  public ResponseEntity<EmployeeDTO> create(@RequestBody EmployeeDTO employeeDTO) {
    employeeDTO = employeeService.create(employeeDTO);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(employeeDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(employeeDTO);
  }
}
