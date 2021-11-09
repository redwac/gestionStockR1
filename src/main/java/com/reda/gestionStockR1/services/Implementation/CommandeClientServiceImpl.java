package com.reda.gestionStockR1.services.Implementation;

import com.reda.gestionStockR1.dto.ClientDto;
import com.reda.gestionStockR1.dto.CommandeClientDto;
import com.reda.gestionStockR1.exception.ErrorsCode;
import com.reda.gestionStockR1.exception.InvalidEntityException2;
import com.reda.gestionStockR1.exception.NotFoundException;
import com.reda.gestionStockR1.model.Article;
import com.reda.gestionStockR1.model.Client;
import com.reda.gestionStockR1.model.CommandeClient;
import com.reda.gestionStockR1.repository.ArticleRepository;
import com.reda.gestionStockR1.repository.ClientRepository;
import com.reda.gestionStockR1.repository.CommandeClientRepository;
import com.reda.gestionStockR1.services.CommandeClientService;
import com.reda.gestionStockR1.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

    CommandeClientRepository commandeClientRepository;
    ClientRepository clientRepository;
    ArticleRepository articleRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validator(dto);
        /*if (!errors.isEmpty()){
            log.error("L'objet Commande_Client n'est pas valid");
            throw new InvalidEntityException2("Commande client n'est valid reverifier le infos",
                    ErrorsCode.COMMANDE_CLIENT_NOT_FOUND, errors);
        }*/
        Optional<Client> client = clientRepository.findById(dto.getClientDto().getId());
        if (client.isEmpty()){
            log.error("Le client n'existe pas dans la base donnees ");
            throw new NotFoundException("Le client n'existe pas dans DB", ErrorsCode.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();
        if (!dto.getLigneCommandeDto().isEmpty()){
            dto.getLigneCommandeDto().forEach(lignCmd -> {
                if (lignCmd.getArticleDto() != null){
                    Optional<Article> article = articleRepository.findById(lignCmd.getArticleDto().getId());
                    if (article.isEmpty()){
                        articleErrors.add("L'article n'existe pas" + lignCmd.getArticleDto().getId() + " Id donnee ");
                    }
                    /*  else if (article.equals(null)){
                            articleErrors.add("l'article ne doit pas etre null");
                          }
                    */
                }

            });
        }
        if (!articleErrors.isEmpty()){
            log.error("on peut pas enregistrer une commande avec article null ou n'existe pas ");
            throw new NotFoundException("article n'existe pas dans DB ou null", ErrorsCode.ARTICLE_NOT_FOUNT);
        }


        return CommandeClientDto.fromEntity(
                commandeClientRepository.save(
                        CommandeClientDto.toEntity(dto))
        );
    }

    @Override
    public CommandeClientDto findById(Long id) {
        if (id == null){
            log.error("Veuillez entrer un id commande");
            return null;
        }

        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity).orElseThrow(()->
                        new NotFoundException("Aucune commande avec l id " + id + " n'existe dans la base donnees",
                                ErrorsCode.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream().
                map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null){
            log.error("Veuillez entrer un id de la commande a supprimer ");
            return;
        }
        commandeClientRepository.deleteById(id);
    }
}
