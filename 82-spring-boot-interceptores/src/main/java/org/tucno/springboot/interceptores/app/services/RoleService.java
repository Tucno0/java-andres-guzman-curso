package org.tucno.springboot.interceptores.app.services;

import org.tucno.springboot.interceptores.app.models.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> listar();
    public Role obtenerPorId(Integer id);
}
