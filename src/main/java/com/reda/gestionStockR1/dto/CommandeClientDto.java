package com.reda.gestionStockR1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reda.gestionStockR1.model.Client;
import com.reda.gestionStockR1.model.CommandeClient;
import com.reda.gestionStockR1.model.LigneCommande;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {

    private Long id;

    private String numCommande;

    private Double totalPrix;

    @JsonIgnore
    private List<LigneCommandeDto> ligneCommandeDto;

    private ClientDto clientDto;


    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if (commandeClient == null){
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .numCommande(commandeClient.getNumCommande())
                .totalPrix(commandeClient.getTotalPrix())
                .clientDto(ClientDto.fromEntity(commandeClient.getClient()))
                .build();
    }
    public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if (commandeClientDto == null){
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();

        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setNumCommande(commandeClientDto.getNumCommande());
        commandeClient.setTotalPrix(commandeClientDto.getTotalPrix());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClientDto()));

        return commandeClient;
    }
}
