package consensoProjeto.consenso.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import consensoProjeto.consenso.model.Usuario;

public interface UsuarioService extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

}