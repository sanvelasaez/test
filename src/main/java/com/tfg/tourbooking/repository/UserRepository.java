package com.tfg.tourbooking.repository;

import com.tfg.tourbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repositorio para la entidad User. Esta interfaz permite acceder a la base de datos
 * para realizar operaciones relacionadas con los usuarios.
 * 
 * Al extender JpaRepository, hereda métodos como:
 * - save()
 * - findById()
 * - findAll()
 * - deleteById()
 * - etc.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por su email.
     * @param email Email del usuario a buscar.
     * @return Un Optional que puede contener un usuario si existe, o estar vacío si no se encuentra.
     */
    Optional<User> findByEmail(String email);

    /**
     * Verifica si ya existe un usuario con un determinado email.
     * @param email Email que se quiere comprobar.
     * @return true si ya existe un usuario con ese email, false en caso contrario.
     */
    boolean existsByEmail(String email);
}