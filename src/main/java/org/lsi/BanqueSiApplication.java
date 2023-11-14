package org.lsi;

import org.lsi.dao.ClientRepository;
import org.lsi.dao.CompteRepository;
import org.lsi.dao.EmployeRepository;
import org.lsi.dao.OperationRepository;
import org.lsi.entities.Client;
import org.lsi.entities.CompteCourant;
import org.lsi.entities.Employe;
import org.lsi.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BanqueSiApplication {
    public static void main(String[] args){
        SpringApplication.run(BanqueSiApplication.class,args);
    }


    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository,
                                        CompteRepository compteRepository,
                                        OperationRepository operationRepository){
        return args->{

            Stream.of("HASSAN","YASSIN","AICHA").forEach(name->{
            Client client=new Client();
            client.setNomClient(name);

            });
            clientRepository.findAll().forEach(client->{
                CompteCourant compteCourant=new CompteCourant();
                compteCourant.setDecouvert(Math.random()*23000);
                compteCourant.setDateCreation(new Date());
                compteCourant.setClient(client);
                compteCourant.setSolde(200000);
                compteCourant.setCodeCompte(UUID.randomUUID().toString());
                compteRepository.save(compteCourant);
            });


        };
    }

}
