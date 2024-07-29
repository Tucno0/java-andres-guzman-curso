package org.tucno.springboot.app.error.exceptions;

public class UsuarioNoEncontradoException extends RuntimeException {
    // El serial version id es un número que se genera automáticamente y que se utiliza para identificar de manera única una clase
    private static final long serialVersionUID = 1L;

    public UsuarioNoEncontradoException(Integer id) {
        super("Usuario con id " + id + " no encontrado");
    }
}
