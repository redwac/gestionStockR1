package com.reda.gestionStockR1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reda.gestionStockR1.model.Client;
import com.reda.gestionStockR1.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class ClientDto {

    private Long id;

    private String nom;

    private String prenom;

    @JsonIgnore
    private List<CommandeClientDto> commandeClientDtos;

    public static ClientDto fromEntity(Client client){
        if (client == null){
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .build();
    }
    public static Client toEntity(ClientDto clientDto){
        if (clientDto == null){
            return null;
        }

        Client client = new Client();

        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());

        return client;
    }
}
