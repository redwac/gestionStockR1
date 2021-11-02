package com.reda.gestionStockR1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article {

    @Id
    @Column(name = "id")
    private Long id ;

    @Column(name = "nomArticle")
    private String nom;

    @Column(name = "quantie")
    private int quantite;

    @ManyToOne()
    @JoinColumn(name = "idCategory")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<LigneCommande> ligneCommande;


}
