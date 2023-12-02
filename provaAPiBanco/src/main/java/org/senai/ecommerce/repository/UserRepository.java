package org.senai.ecommerce.repository;

import org.senai.ecommerce.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    @Query("SELECT u FROM Usuario u JOIN FETCH u.roles where u.username = :username")
    Usuario findByUsernameFetchRoles(@Param("username") String username);
}