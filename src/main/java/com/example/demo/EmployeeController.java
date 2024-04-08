package com.example.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

  private final EmployeeRepository repository;

  private final EmployeeModelAssembler assembler;

  EmployeeController(EmployeeRepository repository, EmployeeModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/employees")
  CollectionModel<EntityModel<Employee>> all() {

    List<EntityModel<Employee>> employees = repository.findAll().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(employees,linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
  }
  // end::get-aggregate-root[]

  @PostMapping("/addemployees")
  Employee newEmployee (@ModelAttribute("employee") Employee newEmployee){
    
    return repository.save(newEmployee);
  }
  
  // tag::get-single-item[]
  @GetMapping("/employees/{id}")
  EntityModel<Employee> one(@PathVariable Long id) {

    Employee employee = repository.findById(id) //
        .orElseThrow(() -> new EmployeeNotFoundException(id));

    return assembler.toModel(employee);
  }
  // end::get-single-item[]

  @PutMapping("/putemployees")
  Employee replaceEmployee(@ModelAttribute("employee") Employee newEmployee) {

    Employee temp = new Employee();
    temp = newEmployee;

    long id = temp.getId();

    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/deleteemployees")
  ResponseEntity<?> deleteEmployee(@ModelAttribute("employee") Employee newEmployee) {

    Employee temp = new Employee();
    temp = newEmployee;

    long id = temp.getId();


    repository.deleteById(id);

    return ResponseEntity.noContent().build();
  }

}
