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

import consensoProjeto.consenso.model.Servico;
import consensoProjeto.consenso.service.ServicoService;

@RestController
public class ServicoController {
    @PostMapping("/servico")
    public Servico criarNovoServico(@RequestBody Servico servico) {
        return servicoService.save(servico);
    }

    @GetMapping("/servico")
    public List<Servico> obterTodosServicos() {
        return servicoService.findAll();
    }

    @GetMapping("/servico/{id}")
    public Servico obterServicosPeloId(@PathVariable("id") Integer id) {
        return servicoService.findById(id).get();
    }

    @DeleteMapping("/servico/{id}")
    public String deletarContatoPeloId(@PathVariable("id") Integer id) {
        servicoService.deleteById(id);

        return "Servico deletado com sucesso!";
    }

    @PutMapping("/servico")
    public Servico atualizarServico(@RequestBody Servico servico){
        Servico servicoBD = servicoService.findById(servico.getIdServico()).get();

        servicoBD.setNome(servico.getNome());
        servicoBD.setDescricao(servico.getDescricao());
       

        servicoBD = servicoService.save(servicoBD);

        return servicoBD;
    }

    @Autowired
    private ServicoService servicoService;
    
}
