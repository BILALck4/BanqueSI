package org.lsi.dao;

import org.lsi.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
