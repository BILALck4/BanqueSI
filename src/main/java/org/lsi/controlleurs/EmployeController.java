package org.lsi.controlleurs;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.lsi.dao.EmployeRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Employe;
import org.lsi.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeController {

    @Autowired
    private EmployeRepository employeRepository;
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

    @GetMapping("/employees/EmployeeForm")
    public String formEmployee(Model model){
        model.addAttribute("Employee",new Employe());
        return "/Employee/employeeForm";
    }

    @PostMapping(path = "/employees/save")
    public String save(Model model, @Valid Employe employe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/Employee/employeeForm";
        }

        employeRepository.save(employe);

        return "redirect:/employees";
    }


    // Other methods for employee-group assignment, etc.
}

