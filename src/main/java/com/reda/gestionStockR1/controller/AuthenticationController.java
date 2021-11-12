package com.reda.gestionStockR1.controller;

import com.reda.gestionStockR1.dto.authentication.AuthenticationRequest;
import com.reda.gestionStockR1.dto.authentication.AuthenticationResponse;
import com.reda.gestionStockR1.services.auth.ApplicationUserDetailService;
import com.reda.gestionStockR1.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static com.reda.gestionStockR1.utils.Constant.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/auth")
public class AuthenticationController {


    // il faut cree un bean pour authentification manager dans la classe spring config
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailService userDetailService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
       authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        final UserDetails userDetails = userDetailService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(AuthenticationResponse.builder().accesToken(jwt).build());
    }
}
