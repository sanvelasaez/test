// Paquete donde se encuentra la interfaz del servicio
package com.tfg.tourbooking.service;

// Importación de los DTOs (objetos de transferencia de datos) y el modelo de usuario
import com.tfg.tourbooking.dto.LoginDto;
import com.tfg.tourbooking.dto.UserDto;
import com.tfg.tourbooking.model.User;

// Interfaz que define los métodos que debe implementar cualquier clase que ofrezca servicios relacionados con usuarios
public interface UserService {

    // Comprueba si ya existe un usuario registrado con el email dado
    boolean existsByEmail(String email);

    // Registra un nuevo usuario con los datos recibidos desde un UserDto
    void registerUser(UserDto userDto);

    // Autentica un usuario a partir de un LoginDto (email y contraseña), y puede lanzar una excepción si algo falla
    User authenticate(LoginDto loginDto) throws IllegalArgumentException;
}
