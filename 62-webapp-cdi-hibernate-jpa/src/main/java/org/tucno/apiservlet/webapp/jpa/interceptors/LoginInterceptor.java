package org.tucno.apiservlet.webapp.jpa.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Logging
@Interceptor
public class LoginInterceptor {
    @Inject
    private Logger logger;

    // @AroundInvoke: Anotación que indica que el método es un método de intercepción.
    @AroundInvoke
    public Object logging(InvocationContext context) throws Exception {
        logger.info(STR."******** Entrando antes de invocar al método \{context.getMethod().getName()} ********");
        Object resultado = context.proceed();
        logger.info(STR."******** Saliendo después de invocar al método \{context.getMethod().getName()} ********");
        return resultado;
    }
}
