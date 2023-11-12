package org.lsi.services;

import java.util.List;

import org.lsi.dao.ClientRepository;
import org.lsi.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    // Other methods for client-related operations.
}

//    @GetMapping(path = "/index")
//    public String client(Model model,
//                         @RequestParam(name="page",defaultValue = "0") int page,
//                         @RequestParam(name="size",defaultValue = "5")int size,
//                         @RequestParam(name="keyword",defaultValue = "")String keyword
//    ){
//        Page<Client> pageClient= clientRepository.findByNomContains(keyword, PageRequest.of(page,size));
//        model.addAttribute("ListeClient",pageClient.getContent());
//        model.addAttribute("pages",new int[pageClient.getTotalPages()] );
//        model.addAttribute("current",page);
//        model.addAttribute("keyword",keyword);
//
//        return "clients";
//    }
