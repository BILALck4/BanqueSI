package org.lsi;

import org.lsi.dao.EmployeRepository;
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


    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args->{
            EmployeRepository.save(new Patient(1,"BILAL",new Date(),false,112));
            patientRepository.save(new Patient(2,"MOHAMMED",new Date(),false,211));
            patientRepository.save(new Patient(3,"BRAHIM",new Date(),false,331));
            patientRepository.save(new Patient(4,"HASSAN",new Date(),false,122));


            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }

}
