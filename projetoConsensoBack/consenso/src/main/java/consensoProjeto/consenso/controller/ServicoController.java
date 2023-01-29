package consensoProjeto.consenso.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import consensoProjeto.consenso.model.Servico;
import consensoProjeto.consenso.service.ServicoService;

@RestController
@CrossOrigin
public class ServicoController {
    @PostMapping("/servico")
    public ResponseEntity<Object> criarNovoServico(@RequestBody Servico servico) {
        try {
            Servico savedServico = servicoService.save(servico);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedServico);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar novo serviço");
        } // corrigido

    }

    @GetMapping("/servico")
    public ResponseEntity<Object> obterTodosServicos() {
        try {
            List<Servico> servicos = servicoService.findAll();
            return ResponseEntity.status(HttpStatus.CREATED).body(servicos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/servico/{id}")
    public Servico obterServicosPeloId(@PathVariable("id") Integer id) {
        try {
            return servicoService.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Servico não encontrado.", e);
        }
    }

    @GetMapping("/servico/usuario/{id}")
    public List<Servico> listadeServicosPorID(@PathVariable Integer id) {
        return servicoService.findServicoByusuarioPrestadorIdUsuario(id);
    }

    @DeleteMapping("/servico/{id}")
    public String deletarContatoPeloId(@PathVariable("id") Integer id) {
        servicoService.deleteById(id);

        return "Servico deletado com sucesso!";
    }

    @PutMapping("/servico")
    public Servico atualizarServico(@RequestBody Servico servico) {
        Servico servicoBD = servicoService.findById(servico.getIdServico()).get();

        servicoBD.setNome(servico.getNome());
        servicoBD.setDescricao(servico.getDescricao());

        servicoBD = servicoService.save(servicoBD);

        return servicoBD;
    }

    @Autowired
    private ServicoService servicoService;

}
