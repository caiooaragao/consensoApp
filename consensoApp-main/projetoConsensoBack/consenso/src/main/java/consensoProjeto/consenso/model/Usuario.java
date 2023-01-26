package consensoProjeto.consenso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(unique = true, nullable = false)
    private String nome;

    private String sobrenome;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    private String senha;

    @OneToOne
    private TipoUsuario tipoUsuario;

}
