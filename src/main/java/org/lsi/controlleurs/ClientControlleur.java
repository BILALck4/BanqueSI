package org.lsi.controlleurs;

import lombok.AllArgsConstructor;
import org.lsi.dao.ClientRepository;
import org.lsi.services.ClientService;

import org.lsi.entities.Client;
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
@AllArgsConstructor
public class ClientControlleur {

    @Autowired
    private ClientRepository clientRepository;

    private ClientService clientService;


    @GetMapping(path = "/index")
    public String client(Model model,
                          @RequestParam(name="page",defaultValue = "0") int page,
                          @RequestParam(name="size",defaultValue = "5")int size,
                          @RequestParam(name="keyword",defaultValue = "")String keyword
    ){
        Page<Client> pageClient= clientRepository.findByNomClientContains(keyword, PageRequest.of(page,size));
        model.addAttribute("ListeClient",pageClient.getContent());
        model.addAttribute("pages",new int[pageClient.getTotalPages()] );
        model.addAttribute("current",page);
        model.addAttribute("keyword",keyword);

        return "clients";
    }
    @GetMapping("/clients")
    public String showClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "client/list";
    }

    @PostMapping("/clients/add")
    public String addClient(@ModelAttribute Client client) {
        clientService.addClient(client);
        return "redirect:/clients";
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping("/formClient")
    public String formPatients(Model model){
        model.addAttribute("patient",new Client());
        return "formClient";
    }
}