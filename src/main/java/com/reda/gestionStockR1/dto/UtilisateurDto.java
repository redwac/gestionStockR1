package com.reda.gestionStockR1.dto;


import com.reda.gestionStockR1.model.Utilisateurs;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {

    public Long id;

    public String nom;

    public String prenom;

    public String email;

    private String motDePass;

    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateurs utilisateurs){
        if (utilisateurs == null){
            return null;
        }
        return UtilisateurDto.builder()
                .id(utilisateurs.getId())
                .nom(utilisateurs.getNom())
                .prenom(utilisateurs.getPrenom())
                .email(utilisateurs.getEmail())
                .motDePass(utilisateurs.getMotDePasse())
                .roles(
                        utilisateurs.getRoles() != null ?
                                utilisateurs.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();

    }
    public static Utilisateurs toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null){
            return null;
        }
        Utilisateurs utilisateurs = new Utilisateurs();
        utilisateurs.id = utilisateurDto.getId();
        utilisateurs.nom = utilisateurDto.getNom();
        utilisateurs.prenom = utilisateurDto.getPrenom();
        utilisateurs.email = utilisateurDto.getEmail();
        utilisateurs.motDePasse = utilisateurDto.getMotDePass();


        return utilisateurs;
    }
}
