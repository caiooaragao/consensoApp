package consensoProjeto.consenso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import consensoProjeto.consenso.model.TipoUsuario;
import consensoProjeto.consenso.service.TipoUsuarioService;

@RestController
public class TipoUsuarioController {
    @PostMapping("/tipousuario")

    public ResponseEntity<Object> criarNovoUsuario(@RequestBody TipoUsuario TipoUsuario) {
        try {
            if (TipoUsuario.getNome().equalsIgnoreCase("cliente")
                    || TipoUsuario.getNome().equals("prestador")) {
                tipoUsuarioService.save(TipoUsuario);
                return ResponseEntity.status(HttpStatus.CREATED).body(TipoUsuario);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(TipoUsuario.getNome());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());// string
        }
    }

    @GetMapping("/tipousuario")
    public List<TipoUsuario> obterTodosTipoUsuarios() {
        return tipoUsuarioService.findAll();
    }

    @GetMapping("/tipousuario/{id}")
    public ResponseEntity<Object> obterUsuarioPeloId(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tipoUsuarioService.findById(id).get());
        } catch (RuntimeException erro) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro.getMessage());
        }
    }

    @DeleteMapping("/tipousuario/{id}")
    public ResponseEntity<Object> deletarUsuarioPeloId(@PathVariable("id") Integer id) {
        tipoUsuarioService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/tipousuario/{id}")
    public ResponseEntity<TipoUsuario> atualizarTipoUsuario(@PathVariable Integer id,
            @RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.findByIdTipoUsuario(id).map(record -> {
            record.setNome(tipoUsuario.getNome());
            TipoUsuario updated = tipoUsuarioService.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());

    }

    @Autowired
    private TipoUsuarioService tipoUsuarioService;
}
