package org.lsi.controlleurs;
import lombok.AllArgsConstructor;
import org.lsi.dao.ClientRepository;
import org.lsi.entities.Client;
import org.lsi.entities.Groupe;
import org.lsi.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/groups")
    public String showGroups(Model model) {
        List<Groupe> groups = groupeService.getAllGroups();
        model.addAttribute("groups", groups);
        return "group/list";
    }

    @PostMapping("/groups/add")
    public String addGroup(@ModelAttribute Groupe groupe) {
        groupeService.addGroup(groupe);
        return "redirect:/groups";
    }

    // Other methods for employee-group assignment, etc.
}
