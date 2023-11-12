package org.lsi.services;

import org.lsi.dao.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.lsi.entities.Compte;

import java.util.List;


@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> getAllAccounts() {
        return compteRepository.findAll();
    }

    public void addAccount(Compte compte) {
        compteRepository.save(compte);
    }

    // Other methods for account operations.
}
