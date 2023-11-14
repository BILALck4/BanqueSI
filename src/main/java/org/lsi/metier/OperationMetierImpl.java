//package org.lsi.metier;
//
//
//import java.util.Date;
//
//import org.lsi.dao.CompteRepository;
//import org.lsi.dao.EmployeRepository;
//import org.lsi.dao.OperationRepository;
//import org.lsi.entities.Compte;
//import org.lsi.entities.Employe;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
////import org.springframework.data.domain.Page;
////import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.lsi.entities.Operation;
//import org.lsi.entities.Retrait;
//import org.lsi.entities.Versment;
//
//@Service
//public class OperationMetierImpl implements OperationMetier {
//
//    @Autowired
//    private OperationRepository operationRepository;
//    @Autowired
//    private CompteRepository compteRepository;
//    @Autowired
//    private EmployeRepository employeRepository;
//
//    @Override
//    @Transactional
//    public boolean verser(Long code, double montant, Long codeEmp) {
//
//        Compte cp=compteRepository.findById(code).orElse(null);
//        Employe e= employeRepository.findById(codeEmp).orElse(null);
//        Operation o = new Versment();
//        o.setDateOperation(new Date());
//        o.setMontant(montant);
//        o.setCompte(cp);
//        o.setEmploye(e);
//        operationRepository.save(o);
//        cp.setSolde(cp.getSolde()+montant);
//        return true;
//    }
//
//    @Override
//    @Transactional
//    public boolean retirer(Long code, double montant, Long codeEmp) {
//
//        Compte cp=compteRepository.findById(code).orElse(null);
//        if(cp.getSolde()<montant) throw new RuntimeException("!! Solde Insuffisant !!!");
//        Employe e= employeRepository.findById(codeEmp).orElse(null);
//        Operation o = new Retrait();
//        o.setDateOperation(new Date());
//        o.setMontant(montant);
//        o.setCompte(cp);
//        o.setEmploye(e);
//        operationRepository.save(o);
//        cp.setSolde(cp.getSolde()-montant);
//        return true;
//    }
//
//    @Override
//    @Transactional
//    public boolean virement(Long cpte1, Long cpte2, double montant, Long codeEmp) {
//        retirer(cpte1, montant, codeEmp);
//        verser(cpte2, montant, codeEmp);
//        return true;
//    }
//
//    @Override
//    public Operation saveOperation(Operation e) {
//        return operationRepository.save(e);
//    }
//
//    @Override
//    public Page<Operation> AllAcountOperations(String code,int page,int size) {
//        return  operationRepository.AllAcountOperations(code,PageRequest.of(page, size));
//    }
//
//
//
//}
