package org.lsi.controlleurs;

import jakarta.validation.Valid;
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

//    @PostMapping(path = "/save")
//    public String save(Model model, @Valid Employe employe, int page, String keyword, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "formPatients";
//        }
//
//        if (patient.getId() != 0) {
//            Patient existingPatient = patientRepository.findById(patient.getId()).orElse(null);
//            if (existingPatient != null) {
//                existingPatient.setNom(patient.getNom());
//                existingPatient.setDateNaissance(patient.getDateNaissance());
//                existingPatient.setMalade(patient.isMalade());
//                existingPatient.setScore(patient.getScore());
//
//                patientRepository.save(existingPatient);
//            }
//        } else {
//            patientRepository.save(patient);
//        }
//
//        return "redirect:/index?page="+page+"&keyword="+keyword;
//    }


    // Other methods for employee-group assignment, etc.
}

