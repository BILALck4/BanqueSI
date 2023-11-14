package org.lsi.controlleurs;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.lsi.dao.ClientRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Groupe;
import org.lsi.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class GroupeController {

    @Autowired
    private GroupeService groupeService;
    @Autowired
    private GroupeRepository groupeRepository;


    @GetMapping("/groups")
    public String showGroups(Model model) {
        List<Groupe> groups = groupeService.getAllGroups();
        model.addAttribute("groups", groups);
        return "Groupe/groupe";
    }

    @PostMapping("/groups/add")
    public String addGroup(@ModelAttribute Groupe groupe) {
        groupeService.addGroup(groupe);
        return "redirect:/groups";
    }
    @GetMapping("/groups/GroupeForm")
    public String formGroup(Model model){
        model.addAttribute("group",new Groupe());
        return "Groupe/GroupForm";
    }

    @PostMapping(path = "groups/save")
    public String save(Model model, @Valid Groupe groupe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "GroupForm";
        }

        groupeRepository.save(groupe);

        return "redirect:/groups";
    }


    // Other methods for employee-group assignment, etc.
}
