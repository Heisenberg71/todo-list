package com.example.todo_list_app.service;

import com.example.todo_list_app.dao.RegistrationDao;
import com.example.todo_list_app.domain.UserEntity;
import com.example.todo_list_app.request.AuthenticationRequest;
import com.example.todo_list_app.response.AuthenticationTokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final RegistrationDao registrationDao;

    @Override
    public AuthenticationTokenResponse authenticateUser(AuthenticationRequest authenticationRequest) {
        if (!registrationDao.isUserValid(authenticationRequest)) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = generateToken(authenticationRequest);

        System.out.println(token);

        registrationDao.saveToken(authenticationRequest, token);

        return AuthenticationTokenResponse.builder()
                .AuthenticationToken(token)
                .build();
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return registrationDao.getAllUsers();
    }

    String generateToken(AuthenticationRequest authenticationRequest) {

        return Jwts.builder()
                .setSubject(authenticationRequest.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignInKey() {
        String secretKey = "3cfa76ef14937c1c0ea519f8fc057a80fcd04a7420f8e8bcd0a7567c272e007b";
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
