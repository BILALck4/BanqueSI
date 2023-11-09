package org.lsi.entities;

import jakarta.persistence.*;
@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {
}

