package org.tucno.apiservlet.webapp.auth.services;

import jakarta.enterprise.inject.Alternative;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

// Alternativa de LoginService que obtiene el nombre de usuario de una cookie
//@Alternative
public class LoginServiceCookieImpl implements LoginService {
    @Override
    public Optional<String> getUserName(HttpServletRequest req) {
        // Se obtiene la lista de cookies de la petición actual
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("username"))
                .map(Cookie::getValue) //cookie -> cookie.getValue()
                .findFirst();
    }
}
