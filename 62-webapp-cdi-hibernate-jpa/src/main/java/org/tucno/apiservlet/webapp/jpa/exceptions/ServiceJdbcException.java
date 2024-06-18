package org.tucno.apiservlet.webapp.jpa.exceptions;

public class ServiceJdbcException extends RuntimeException {
    public ServiceJdbcException(String message) {
        super(message);
    }

    public ServiceJdbcException(String message, Throwable cause) {
        super(message, cause);
    }
}
