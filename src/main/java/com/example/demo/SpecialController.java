package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpecialController {
    @GetMapping(value="/")
    public String index(Model model){
        /*The Employee object to capture values of fields on the form. */
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "index";
    }
}
