package com.reda.gestionStockR1.dto.authentication;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {

    public String accesToken ;
}
