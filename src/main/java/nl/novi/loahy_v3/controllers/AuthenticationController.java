package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.payload.AuthenticationRequest;
import nl.novi.loahy_v3.payload.AuthenticationResponse;
import nl.novi.loahy_v3.services.CustomUserDetailsService;
import nl.novi.loahy_v3.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtl;


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid AuthenticationRequest authenticationRequest) throws Exception {

        String userEmail = authenticationRequest.getUserEmail();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userEmail, password)
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect e-mailadres or password", ex);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userEmail);

        final String jwt = jwtUtl.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}