package org.tucno.springboot.form.app.services;

import org.tucno.springboot.form.app.models.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> listar();
    public Role obtenerPorId(Integer id);
}
