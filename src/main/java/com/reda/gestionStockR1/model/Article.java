package com.reda.gestionStockR1.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@Entity
@Table(name = "article")
public class Article {

    @Id
    @Column(name = "id")
    private Long id ;

    @Column(name = "nomArticle")
    private String nom;

    @Column(name = "quantie")
    private BigDecimal quantite;

    @ManyToOne()
    @JoinColumn(name = "idCategory")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<LigneCommande> ligneCommande;


}
