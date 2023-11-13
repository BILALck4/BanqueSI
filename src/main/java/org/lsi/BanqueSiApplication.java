package org.lsi;

import org.lsi.dao.EmployeRepository;
import org.lsi.entities.Employe;
import org.lsi.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
public class BanqueSiApplication {
    public static void main(String[] args){
        SpringApplication.run(BanqueSiApplication.class,args);
    }


//    @Bean
//    CommandLineRunner commandLineRunner(EmployeRepository employeRepository){
//        return args->{
//            employeRepository.save(new Employe(2,"BILAL CHEKHCHOU"));
//            employeRepository.save(new Employe(2,"MOHAMMED",new Date(),false,211));
//            employeRepository.save(new Employe(3,"BRAHIM",new Date(),false,331));
//            employeRepository.save(new Employe(4,"HASSAN",new Date(),false,122));
//
//
//            employeRepository.findAll().forEach(p->{
//                System.out.println(p.getNomEmploye());
//            });
//        };
//    }

}
