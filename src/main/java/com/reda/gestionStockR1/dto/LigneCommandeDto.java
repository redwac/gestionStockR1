package com.reda.gestionStockR1.dto;

import com.reda.gestionStockR1.model.Article;
import com.reda.gestionStockR1.model.Client;
import com.reda.gestionStockR1.model.CommandeClient;
import com.reda.gestionStockR1.model.LigneCommande;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeDto {

    private Long id;

    private int quantite;

    private ArticleDto articleDto;

    private CommandeClientDto commandeClientDto;

    public static LigneCommandeDto fromEntity(LigneCommande ligneCommande){
        if (ligneCommande == null){
            return null;
        }
        return LigneCommandeDto.builder()
                .id(ligneCommande.getId())
                .quantite(ligneCommande.getQuantite())
                .articleDto(ArticleDto.fromEntity(ligneCommande.getArticle()))
                .commandeClientDto(CommandeClientDto.fromEntity(ligneCommande.getCommandeClient()))
                .build();
    }

    public static LigneCommande toEntity(LigneCommandeDto ligneCommandeDto){
        if (ligneCommandeDto == null){
            return null;
        }
        LigneCommande ligneCommande = new LigneCommande();

        ligneCommande.setId(ligneCommandeDto.getId());
        ligneCommande.setQuantite(ligneCommandeDto.getQuantite());
        ligneCommande.setArticle(ArticleDto.toEntity(ligneCommandeDto.getArticleDto()));
        ligneCommande.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeDto.getCommandeClientDto()));
        return ligneCommande;
    }
}
