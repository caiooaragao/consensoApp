package consensoProjeto.consenso.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    public TipoUsuario criarNovoUsuario(@RequestBody TipoUsuario TipoUsuario){
         return tipoUsuarioService.save(TipoUsuario);
    }
 
    @GetMapping("/tipousuario")
    public List<TipoUsuario> obterTodosTipoUsuarios(){
     return tipoUsuarioService.findAll();
    }
    @GetMapping("/tipousuario/{id}")
    public TipoUsuario obterUsuarioPeloId(@PathVariable("id") Integer id) {
        return tipoUsuarioService.findById(id).get();
    }
    
    @DeleteMapping("/tipousuario/{id}")
    public String deletarUsuarioPeloId(@PathVariable("id") Integer id) {
        tipoUsuarioService.deleteById(id);

        return "TipoUsuario deletado com sucesso!";
    }

    @PutMapping("/tipousuario")
    public TipoUsuario atualizarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarioBD = tipoUsuarioService.findById(tipoUsuario.getIdTipoUsuario()).get();
        

        tipoUsuarioBD.setNome(tipoUsuario.getNome());
        tipoUsuarioBD.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
        

        tipoUsuarioBD = tipoUsuarioService.save(tipoUsuario);

        return tipoUsuarioBD;
    }
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
}
