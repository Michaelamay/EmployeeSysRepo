package com.example.demo;

  /*
  List<Employee> all() {
    return repository.findAll();
  }*/

    /*
  @PostMapping("/addEmployee")
  Employee newEmployee (@RequestBody Employee newEmployee, @ModelAttribute("employee") Employee employee){


    //Employee employee = new Employee();

    //employee.addAttribute("employee", employee);

    return repository.save(newEmployee);
  }*/

    /*
  @RequestMapping(value = "/feedback", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
  public void handleBrowserSubmissions(@RequestBody Employee employee) throws Exception {

    repository.save(employee);

    //return "done.";
  }*/

  /*
  @PostMapping("/employees")
  Employee newEmployee (@RequestBody Employee newEmployee){
    return repository.save(newEmployee);
  }
  */

    /*
  @RequestMapping(value = "/addEmployee", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
  public void submit(@RequestBody Employee employee, BindingResult result, ModelMap model) {

    //employee.setFirstName(employee.getFirstName());
    //employee.setRole(employee.getRole());

    //model.addAttribute("firstName", employee.getName());
    //model.addAttribute("role", employee.getRole());

    //employeeMap.put(employee.getId(), employee);

    repository.save(employee);

    //return "employeeView";
  }
  */


  // Single item
  /*
  Employee one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }*/

  /*
    ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    Employee updatedEmployee = repository.findById(id) //
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return repository.save(employee);
        }) //
        .orElseGet(() -> {
          newEmployee.setId(id);
          return repository.save(newEmployee);
        });

    EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }
  */

  /*
  @PutMapping("/putemployees")
  Employee replaceEmployee(@ModelAttribute("employee") Employee newEmployee){

    
    Employee temp = new Employee();
    temp = newEmployee;

    long id = temp.getId();

    Employee updatedEmployee = repository.findById(id) //
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return repository.save(employee);
        }) //
        .orElseGet(() -> {
          newEmployee.setId(id);
          return repository.save(newEmployee);
        });

    EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
    

   return repository.save(newEmployee);
  }
  */