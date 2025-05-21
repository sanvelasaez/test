package com.tfg.tourbooking.controller;

// Importaciones necesarias para manejar respuestas HTTP y peticiones REST
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.tourbooking.dto.LoginDto;
import com.tfg.tourbooking.dto.UserDto;
import com.tfg.tourbooking.model.User;
import com.tfg.tourbooking.service.UserService;

import lombok.RequiredArgsConstructor;

// Indica que esta clase es un controlador REST (maneja peticiones HTTP en formato JSON)
@RestController
// Ruta base para todas las peticiones manejadas por este controlador
@RequestMapping("/api")
// Lombok: genera automáticamente un constructor con los atributos `final` (como `userService`)
@RequiredArgsConstructor
public class UserController {

    // Inyección del servicio de usuario, usado para manejar lógica de autenticación y registro
    private final UserService userService;

    // Endpoint para registrar un nuevo usuario (POST /api/register)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        // Verifica si el email ya existe
        if (userService.existsByEmail(userDto.getEmail())) {
            return ResponseEntity.badRequest().body("El email ya está registrado");
        }

        // Si no existe, registra el nuevo usuario
        userService.registerUser(userDto);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }

    // Endpoint para login (POST /api/login)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            // Autentica al usuario (verifica email y contraseña)
            User user = userService.authenticate(loginDto);

            // Por seguridad, elimina la contraseña del objeto devuelto al frontend
            user.setPassword(null);

            // Devuelve el usuario autenticado
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            // Si falla la autenticación, devuelve error 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}