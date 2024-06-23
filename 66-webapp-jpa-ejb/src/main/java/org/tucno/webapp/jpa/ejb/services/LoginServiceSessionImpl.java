package org.tucno.webapp.jpa.ejb.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@ApplicationScoped
public class LoginServiceSessionImpl implements LoginService {
    @Override
    public Optional<String> getUserName(HttpServletRequest request) {
        // Se obtiene la sesión actual
        HttpSession session = request.getSession();

        // Se obtiene el atributo "username" de la sesión, se hace un cast a String
        String username = (String) session.getAttribute("username");

        if (username != null) {
            return Optional.of(username);
        }

        return Optional.empty();
    }
}
