// Indica que esta clase es un servicio de Spring (componente que contiene lógica de negocio)
package com.tfg.tourbooking.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tfg.tourbooking.dto.LoginDto;
import com.tfg.tourbooking.dto.UserDto;
import com.tfg.tourbooking.model.User;
import com.tfg.tourbooking.repository.UserRepository;
import com.tfg.tourbooking.service.UserService;

import lombok.RequiredArgsConstructor;

// Anotación que marca esta clase como un bean de servicio
@Service
// Lombok: genera un constructor con los atributos `final` para inyección de dependencias
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    // Repositorio para acceder a la base de datos de usuarios
    private final UserRepository userRepository;

    // Componente que se usa para encriptar y verificar contraseñas
    private final PasswordEncoder passwordEncoder;

    // Método que comprueba si un usuario ya está registrado por email
    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    // Registra un nuevo usuario con los datos del DTO
    @Override
    public void registerUser(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        // Encripta la contraseña antes de guardarla
        user.setPassword(passwordEncoder.encode(dto.getPassword())); 

        user.setRole(dto.getRole());
        userRepository.save(user); // Guarda el usuario en la base de datos
    }

    // Autentica al usuario comparando email y contraseña
    @Override
    public User authenticate(LoginDto dto) {
        // Busca el usuario por email
        User user = userRepository.findByEmail(dto.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Compara la contraseña ingresada con la guardada (encriptada)
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }

        return user; // Si todo está bien, devuelve el usuario autenticado
    }
}
