package com.tfg.tourbooking.dto;

// Anotación de Lombok que genera automáticamente los getters, setters, equals, hashCode y toString
import lombok.Data;

/**
 * Clase que representa los datos que se envían o reciben desde el frontend
 * para registrar un nuevo usuario. Es un DTO (Data Transfer Object).
 */
@Data
public class UserDto {

    // Nombre del usuario
    private String name;

    // Email del usuario
    private String email;

    // Contraseña (en texto plano cuando se recibe del frontend)
    private String password;

    // Rol del usuario, por ejemplo: "TURISTA" o "PROPIETARIO"
    private String role;
}