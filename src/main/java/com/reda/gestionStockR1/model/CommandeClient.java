package com.reda.gestionStockR1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commandeClient")
public class CommandeClient {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "numCommande")
    private String numCommande;

    @Column(name = "totalPrix")
    private Double totalPrix;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommande> ligneCommande;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

}
