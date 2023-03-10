package consensoProjeto.consenso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServico;
    private String nome;
    private String descricao;

    @ManyToOne
    private Usuario usuarioPrestador;
}
