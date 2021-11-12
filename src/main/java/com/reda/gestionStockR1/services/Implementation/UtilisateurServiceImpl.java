package com.reda.gestionStockR1.services.Implementation;

import com.reda.gestionStockR1.dto.UtilisateurDto;
import com.reda.gestionStockR1.exception.ErrorsCode;
import com.reda.gestionStockR1.exception.NotFoundException;
import com.reda.gestionStockR1.repository.UtilisateurRepository;
import com.reda.gestionStockR1.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    UtilisateurRepository utilisateurRepository;

    UtilisateurDto utilisateurDto ;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        if (dto == null){
            return null;
        }
        return UtilisateurDto.fromEntity(
                (utilisateurRepository.save(UtilisateurDto.toEntity(dto)))
        );
    }

    @Override
    public UtilisateurDto findById(Long id) {

        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity).orElseThrow(()->
                    new NotFoundException("L'utilsateur n'existe pas", ErrorsCode.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurRepository.findUtilisateursByEmail(email)
                .map(UtilisateurDto::fromEntity).orElseThrow(()->
                        new NotFoundException("L'utilsateur n'existe pas", ErrorsCode.UTILISATEUR_NOT_FOUND));
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null){
            return ;
        }
        utilisateurRepository.deleteById(id);
    }


}
