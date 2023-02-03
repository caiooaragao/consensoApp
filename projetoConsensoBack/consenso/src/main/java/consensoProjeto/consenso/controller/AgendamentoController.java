package consensoProjeto.consenso.controller;

import java.util.List;

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

import consensoProjeto.consenso.model.Agendamento;
import consensoProjeto.consenso.service.AgendamentoService;

@CrossOrigin
@RestController
public class AgendamentoController {

    @PostMapping("/agendamento")
    public ResponseEntity<Object> criarNovoAgendamento(@RequestBody Agendamento agendamento) {
        try {
            Agendamento savedAgendamento = agendamentoService.save(agendamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAgendamento);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar novo Agendamento");
        }
    }

    @GetMapping("/agendamento")
    public List<Agendamento> obterTodosAgendamento() {
        return agendamentoService.findAll();
    }

    @GetMapping("/agendamento/usuario/{id}")
    public List<Agendamento> obterTodosAgendamentosDoUsuario(@PathVariable("id") Integer idusuario) {
        return agendamentoService.findByUsuarioIdUsuario(idusuario);
    }

    @GetMapping("/agendamento/usuarioprestador/{id}")
    public List<Agendamento> obterTodosAgendamentosDoUsuarioPrestador(@PathVariable("id") Integer idusuario) {
        return agendamentoService.findByServicoUsuarioPrestadorIdUsuario(idusuario);
    }

    @GetMapping("/agendamento/{id}")
    public ResponseEntity<Agendamento> agendamentoUnico(@PathVariable("id") Integer id) {

        return agendamentoService.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/agendamento/{id}")
    public ResponseEntity<String> deletarAgendamentoPeloId(@PathVariable("id") Integer id) {
        try {
            agendamentoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/agendamento")
    public ResponseEntity<Agendamento> atualizarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento agendamentoBD = agendamentoService.findById(agendamento.getIdAgendamento()).get();
        try {
            agendamentoBD.setData(agendamento.getData());
            agendamentoBD.setHora(agendamento.getHora());

            agendamentoBD = agendamentoService.save(agendamentoBD);
            return ResponseEntity.status(HttpStatus.OK).body(agendamentoBD);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @Autowired
    private AgendamentoService agendamentoService;
}
