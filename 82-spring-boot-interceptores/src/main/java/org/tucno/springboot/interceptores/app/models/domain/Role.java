package org.tucno.springboot.interceptores.app.models.domain;

public class Role {
    private Integer id;
    private String nombre;
    private String role;

    public Role() {
    }

    public Role(Integer id, String nombre, String role) {
        this.id = id;
        this.nombre = nombre;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    // Este método es necesario para que el PropertyEditor funcione correctamente en el formulario
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Role)) return false;
        Role role = (Role) o;
        return this.id != null && this.id.equals(role.getId());
    }
}
