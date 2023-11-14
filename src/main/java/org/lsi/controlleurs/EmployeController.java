package org.lsi.controlleurs;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.services.EmployeService;
import org.lsi.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeController {

    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private EmployeService employeService;

    GroupeRepository groupeRepository;


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

    @GetMapping("/employees/addEmployeToGroupe")
    public String addEmployeGroupe(){
        return "/Employee/addEmployeGroupe";
    }

    @GetMapping("/employees/addToGroupForm")
    public String addToGroupForm(Model model) {
        model.addAttribute("employeeId", new Long(0)); // Set default values if needed
        model.addAttribute("groupId", new Long(0)); // Set default values if needed
        return "employee/addToGroupForm";
    }
    @PostMapping("/employees/addEmployeToGroupe")
    public String addEmployeeToGroup(@ModelAttribute("employeeId") Long employeeId, @ModelAttribute("groupId") Long groupId) {
        // Get the employee by ID
        Employe employee = employeRepository.findById(employeeId).orElse(null);

        // Get the group by ID
        Groupe group = groupeRepository.findById(groupId).orElse(null);

        // Check if both employee and group exist
        if (employee != null && group != null) {
            // Add the employee to the group
            Collection<Employe> collection=group.getEmploye();
            collection.add(employee);
            group.setEmploye(collection);
            // Save the updated group
            groupeRepository.save(group);

        }

        // Redirect to the employee details page or any other page as needed
        return "redirect:/employees";
    }

    // Other methods for employee-group assignment, etc.
}

