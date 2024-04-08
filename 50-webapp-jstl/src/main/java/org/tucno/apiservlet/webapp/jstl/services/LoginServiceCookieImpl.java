package org.tucno.apiservlet.webapp.jstl.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

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
