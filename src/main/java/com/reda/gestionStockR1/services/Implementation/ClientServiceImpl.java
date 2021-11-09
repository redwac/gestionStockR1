package com.reda.gestionStockR1.services.Implementation;

import com.reda.gestionStockR1.dto.ClientDto;
import com.reda.gestionStockR1.exception.ErrorsCode;
import com.reda.gestionStockR1.exception.InvalidEntityException2;
import com.reda.gestionStockR1.exception.NotFoundException;
import com.reda.gestionStockR1.model.Client;
import com.reda.gestionStockR1.repository.ClientRepository;
import com.reda.gestionStockR1.services.ClientService;
import com.reda.gestionStockR1.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
       /* List<String> errors = ClientValidator.validator(dto);
        if (!errors.isEmpty()){
            log.error("L'Objet Client n'est pas valid");
            throw new InvalidEntityException2("Le Client n'est pas valid" ,
                    ErrorsCode.CLIENT_NOT_FOUND, errors);
        }*/
        return ClientDto.fromEntity(
                clientRepository.save(
                        ClientDto.toEntity(dto)
                )
        );
    }

    @Override
    public ClientDto findById(Long id) {
        if (id == null){
            log.error("Veuillez entrer un id");
            return null;
        }
        return clientRepository.findById(id)
                .map(ClientDto::fromEntity).orElseThrow(()->
                        new NotFoundException("Le client avec l id " + id + " n'existe pas dans la base donnees ",
                                ErrorsCode.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {

        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null){
            log.error("Veuillez entrer un id");
            return ;
        }
        clientRepository.deleteById(id);
    }
}
