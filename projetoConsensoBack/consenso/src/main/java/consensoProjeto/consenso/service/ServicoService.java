package consensoProjeto.consenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import consensoProjeto.consenso.model.Servico;

public interface ServicoService extends JpaRepository<Servico, Integer>{
    
}
