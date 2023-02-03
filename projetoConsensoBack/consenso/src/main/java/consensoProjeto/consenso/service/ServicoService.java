package consensoProjeto.consenso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import consensoProjeto.consenso.model.Servico;

public interface ServicoService extends JpaRepository<Servico, Integer> {

    List<Servico> findByUsuarioPrestadorIdUsuario(Integer idusuario);

    Optional<Servico> findByIdServico(Integer id);
}
