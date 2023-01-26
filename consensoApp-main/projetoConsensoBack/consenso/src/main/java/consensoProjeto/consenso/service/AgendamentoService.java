package consensoProjeto.consenso.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import consensoProjeto.consenso.model.Agendamento;

public interface AgendamentoService extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findByUsuarioIdUsuario(Integer idusuario);
}
