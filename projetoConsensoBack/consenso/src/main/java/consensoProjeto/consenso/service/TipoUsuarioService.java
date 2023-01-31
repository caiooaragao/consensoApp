package consensoProjeto.consenso.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import consensoProjeto.consenso.model.TipoUsuario;

public interface TipoUsuarioService extends JpaRepository<TipoUsuario, Integer> {
    Optional<TipoUsuario> findByIdTipoUsuario(Integer id);
}