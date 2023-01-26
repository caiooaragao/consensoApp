package consensoProjeto.consenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import consensoProjeto.consenso.model.TipoUsuario;






public interface TipoUsuarioService extends JpaRepository<TipoUsuario, Integer> {
    
}