package org.lsi.controlleurs;

import org.lsi.entities.Compte;
import org.lsi.entities.CompteCourant;
import org.lsi.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping("/list")
    public String listComptes(Model model) {
        List<Compte> comptes = compteService.getAllAccounts();
        model.addAttribute("comptes", comptes);
        return "Compte/list";
    }

    @GetMapping("/addForm")
    public String showCompteForm(Model model) {
        model.addAttribute("compte", new CompteCourant());
        return "compte/CompteForm";
    }

    @PostMapping("/save")
    public String saveCompte(@ModelAttribute("compte") Compte compte) {
        compteService.addAccount(compte);
        return "redirect:/comptes/list";
    }


    // Additional methods for updating, deleting, etc., as needed

}
