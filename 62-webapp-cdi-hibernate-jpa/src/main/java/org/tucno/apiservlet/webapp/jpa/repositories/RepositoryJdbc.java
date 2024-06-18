package org.tucno.apiservlet.webapp.jpa.repositories;

import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, FIELD, METHOD, PARAMETER, TYPE})
public @interface RepositoryJdbc {
}
