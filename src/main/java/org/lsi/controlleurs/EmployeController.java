package org.lsi.controlleurs;

import org.lsi.entities.Employe;
import org.lsi.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/employees")
    public String showEmployees(Model model) {
        List<Employe> employees = employeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "Employee/list";
    }
//
//
//    @PostMapping("/employees/add")
//    public String addEmployee(@ModelAttribute Employe employe) {
//        employeService.addEmployee(employe);
//        return "redirect:/employees";
//    }
//
    @GetMapping("/index")
    public String home1() {
        return "index";
    }


    // Other methods for employee-group assignment, etc.
}

