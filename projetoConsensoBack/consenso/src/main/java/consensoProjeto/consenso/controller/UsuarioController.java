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

import consensoProjeto.consenso.model.Usuario;
import consensoProjeto.consenso.service.UsuarioService;

@RestController
public class UsuarioController {
    @PostMapping("/usuario")

    public ResponseEntity<Object> criarNovoUsuario(@RequestBody Usuario usuario) {

        if (usuario.getTipoUsuario().getNome().equalsIgnoreCase("cliente")
                || usuario.getTipoUsuario().getNome().equals("prestador")) {
            usuarioService.save(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuario.getTipoUsuario().getNome());

    }

    @GetMapping("/usuario")
    public List<Usuario> obterTodosUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object> obterUsuarioPeloId(@PathVariable("id") Integer id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id).get());
        } catch (RuntimeException erro) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro.getMessage());

        }

    }

    @DeleteMapping("/usuario/{id}")
    public String deletarUsuarioPeloId(@PathVariable("id") Integer id) {
        usuarioService.deleteById(id);

        return "Usuario deletado com sucesso!";
    }

    @PutMapping("/usuario")
    public Usuario atualizarContato(@RequestBody Usuario usuario) {
        Usuario usuarioBD = usuarioService.findById(usuario.getIdUsuario()).get();

        usuarioBD.setNome(usuario.getNome());
        usuarioBD.setSobrenome(usuario.getSobrenome());

        usuarioBD.setEmail(usuario.getEmail());

        usuarioBD.setSenha(usuario.getSenha());
        usuarioBD.setTipoUsuario(usuario.getTipoUsuario());

        usuarioBD = usuarioService.save(usuario);

        return usuarioBD;
    }

    @Autowired
    private UsuarioService usuarioService;

}
