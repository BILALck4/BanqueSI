package org.lsi.controlleurs;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.lsi.dao.ClientRepository;
import org.lsi.services.ClientService;

import org.lsi.entities.Client;
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
@AllArgsConstructor
public class ClientControlleur {

    @Autowired
    private ClientRepository clientRepository;

    private ClientService clientService;


    @GetMapping(path = "/clients")
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

        return "Client/clients";
    }

    @PostMapping(path = "clients/save")
    public String save(Model model, @Valid Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formPatients";
        }

            clientRepository.save(client);

        return "redirect:/clients?keyword="+client.getNomClient();
    }


    @PostMapping("/clients/add")
    public String addClient(@ModelAttribute Client client) {
        clientService.addClient(client);
        return "redirect:/clients/ClientForm";
    }
    @GetMapping("/clients/ClientForm")
    public String formClient(Model model){
        model.addAttribute("client",new Client());
        return "Client/ClientForm";
    }
    @GetMapping("/clients/delete")
    public String Delete(Long id, int page,String keyword){
        clientRepository.deleteById(id);
        return "redirect:/clients?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }


}
