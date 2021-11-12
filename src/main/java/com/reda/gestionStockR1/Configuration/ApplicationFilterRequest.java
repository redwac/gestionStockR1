package com.reda.gestionStockR1.Configuration;

import com.reda.gestionStockR1.services.auth.ApplicationUserDetailService;
import com.reda.gestionStockR1.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import springfox.documentation.spi.service.contexts.SecurityContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApplicationFilterRequest extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils ;

    @Autowired
    private ApplicationUserDetailService applicationUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            final String authHeader = request.getHeader("Authorization");

            String userName = null;
            String jwt = null;

            if ((authHeader != null && authHeader.startsWith("Bearer "))){
                jwt = authHeader.substring(7);
                userName = jwtUtils.extractUsername(jwt);
            }

            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = applicationUserDetailService.loadUserByUsername(userName);
                if (jwtUtils.validateToken(jwt, userDetails)){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    usernamePasswordAuthenticationToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            filterChain.doFilter(request, response);

    }
}
