package org.lsi.dao;

import org.lsi.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CompteRepository extends JpaRepository<Compte, String> {
}
