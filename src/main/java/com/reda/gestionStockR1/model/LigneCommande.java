package com.reda.gestionStockR1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "LigneCommande")
public class LigneCommande {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "quantite")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idCommande")
    private CommandeClient commandeClient;


}
