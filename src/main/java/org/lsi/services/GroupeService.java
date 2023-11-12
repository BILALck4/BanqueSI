package org.lsi.services;

import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    public List<Groupe> getAllGroups() {
        return groupeRepository.findAll();
    }

    public void addGroup(Groupe groupe) {
        groupeRepository.save(groupe);
    }

    // Other methods for employee-group assignment, etc.
}
