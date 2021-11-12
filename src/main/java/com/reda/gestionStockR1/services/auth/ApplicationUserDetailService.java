package com.reda.gestionStockR1.services.auth;

import com.reda.gestionStockR1.dto.UtilisateurDto;
import com.reda.gestionStockR1.exception.ErrorsCode;
import com.reda.gestionStockR1.exception.NotFoundException;
import com.reda.gestionStockR1.model.Utilisateurs;
import com.reda.gestionStockR1.repository.UtilisateurRepository;
import com.reda.gestionStockR1.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserDetailService implements UserDetailsService {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

/*
        Utilisateurs utilisateurs = utilisateurRepository.findUtilisateursByEmail(email).orElseThrow(()->
                new NotFoundException("Aucun utilisateur avec l'email fournit n'existe ", ErrorsCode.UTILISATEUR_NOT_FOUND)
        );
        return new User(utilisateurs.getEmail(),utilisateurs.getMotDePasse(), Collections.emptyList());
        return new User("reda","reda", Collections.emptyList());
 */
        UtilisateurDto utilisateurDto = utilisateurService.findByEmail(email);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        utilisateurDto.getRoles().forEach(rolesDto -> authorities
                .add(
                new SimpleGrantedAuthority(rolesDto.getRoleName())
                ));

        return new User(utilisateurDto.getEmail(), utilisateurDto.getMotDePass(),authorities);
    }
}
