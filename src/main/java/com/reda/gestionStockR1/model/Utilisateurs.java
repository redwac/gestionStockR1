package com.reda.gestionStockR1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateurs {

    @Id
    @Column(name = "idUtilisateur")
    public Long id;

    @Column(name = "nom")
    public String nom;

    @Column(name = "prenom")
    public String prenom;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String motDePasse;

    @OneToMany()
    @JsonIgnore
    private List<Roles> roles;

}
