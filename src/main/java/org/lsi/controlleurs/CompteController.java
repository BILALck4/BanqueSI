package org.lsi.controlleurs;

import org.lsi.entities.Compte;
import org.lsi.services.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping("/accounts")
    public String showAccounts(Model model) {
        List<Compte> accounts = compteService.getAllAccounts();
        model.addAttribute("accounts", accounts);
        return "account/list";
    }

    @PostMapping("/accounts/add")
    public String addAccount(@ModelAttribute Compte compte) {
        compteService.addAccount(compte);
        return "redirect:/accounts";
    }

    // Other methods for account operations.
}
