package org.lsi.dao;

import org.lsi.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Import Pageable instead of PageRequest
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findByNomClientContains(String nom, Pageable pageable);
}
