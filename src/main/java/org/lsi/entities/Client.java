package org.lsi.entities;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.*;
@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codeClient;
    private String nomClient;
    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private Collection<Compte> comptes;
    public Long getCodeClient() {
        return codeClient;
    }
    public void setCodeClient(Long codeClient) {
        this.codeClient = codeClient;
    }
    public String getNomClient() {
        return nomClient;
    }
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
    public Collection<Compte> getComptes() {
        return comptes;
    }
    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
    public Client(String nomClient) {
        super();
        this.nomClient = nomClient;
    }
    public Client() {
        super();
    }
}
