package consensoProjeto.consenso.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import consensoProjeto.consenso.model.Servico;
import consensoProjeto.consenso.model.Usuario;
import consensoProjeto.consenso.service.ServicoService;
import consensoProjeto.consenso.service.UsuarioService;

@RestController
@CrossOrigin
public class ServicoController {
    @PostMapping("/servico")
    public ResponseEntity<Object> criarNovoServico(@RequestBody Servico servico,
            @RequestHeader("idUsuario") Integer idUsuario) throws Exception {
        try {
            Optional<Usuario> usuarioLogado = usuarioService.findById(idUsuario);
            if (!usuarioLogado.isPresent()) {
                throw new Exception("usuario nao logado");
            }
            if (usuarioLogado.get().getTipoUsuario().getIdTipoUsuario() != 2) {
                throw new Exception("não autorizado");

            }
            Servico savedServico = servicoService.save(servico);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedServico);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar novo serviço");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

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
    public ResponseEntity<List<Servico>> listadeServicosPorID(@PathVariable Integer id) {
        try {
            List<Servico> testeServicoDB = servicoService.findByUsuarioPrestadorIdUsuario(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(testeServicoDB);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping("/servico/{id}")
    public ResponseEntity<Object> deletarServicoPeloId(@PathVariable("id") Integer id) {
        try {
            servicoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @CrossOrigin
    @PutMapping("/servico/{id}")
    public ResponseEntity<Object> atualizarServico(@PathVariable Integer id, @RequestBody Servico servico) {

        return servicoService.findByIdServico(id).map(record -> {
            record.setNome(servico.getNome());
            record.setDescricao(servico.getDescricao());
            servicoService.save(record);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioService usuarioService;

}
