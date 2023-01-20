package consensoProjeto.consenso.model;

import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

@Data
@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamento;
    @FutureOrPresent
    private Date data;
    @FutureOrPresent
    private LocalTime hora;
    @OneToOne
    private Usuario usuario;
    @OneToOne
    private Servico servico;

}
