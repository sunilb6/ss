package com.example.securesaving.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AuthServiceImpl implements AuthService{

    @Override
    public Map<String, String> getAccessToken(String token) {
        verifyRefreshToken(token);
        return null;
    }

    private void verifyRefreshToken(String token) {
        verifyToken(token, "refresh");
    }

    private void verifyToken(String token, String tokenType) {
        String JWT_SECRETS_ACCESS_TOKEN = "ngty9i4XX478wBWIYOK1IaEq6hcL539XQgqTG3iRPjprB4qp5tzPWkOYbQUnlvg5";
        String key = tokenType.equals("refresh") ? "refreshToken" : "accessToken";

        Claims claims = Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(JWT_SECRETS_ACCESS_TOKEN))
                .build().parseClaimsJws(token).getBody();

        System.out.println(claims.toString());
    }
}
