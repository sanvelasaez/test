// Paquete al que pertenece esta clase
package com.tfg.tourbooking.model;

// Importaciones necesarias para el mapeo JPA (Jakarta Persistence API)
import jakarta.persistence.*;

// Anotación que indica que esta clase es una entidad JPA (corresponde a una tabla en la base de datos)
@Entity
public class User {

    // Identificador único de cada usuario, se genera automáticamente con estrategia IDENTITY (autoincremental)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del usuario
    private String name;

    // Correo electrónico del usuario (debe ser único idealmente)
    private String email;

    // Contraseña del usuario (debería estar cifrada al guardarse)
    private String password;

    /**
     * Devuelve la contraseña del usuario.
     * @return password del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password nueva contraseña
     */
    public void setPassword(String password) {
        this.password = password;
    }

    // Rol del usuario: puede ser "TURISTA" o "PROPIETARIO"
    private String role;

    // Métodos getter y setter para el ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Métodos getter y setter para el nombre
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Métodos getter y setter para el email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos getter y setter para el rol
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
