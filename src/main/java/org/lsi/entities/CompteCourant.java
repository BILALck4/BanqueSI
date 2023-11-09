package org.lsi.entities;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

    public double getDecouvert() {
        return decouvert;
    }
    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
    private double decouvert;
    public CompteCourant(String codeCompte, Date dateCreation, double solde,
                         double decouvert) {
        super(codeCompte, dateCreation, solde);
        this.decouvert = decouvert;
    }
    public CompteCourant() {
        super();
// TODO Auto-generated constructor stub
    }
}
