package org.example.medico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Medico {

    private String nome;
    private String crm;
    private Especialidade especialidade;
    private LocalDateTime dataConsulta;
    private LocalDateTime horarioDisponivel;
    private LocalDateTime horarioDescanso;



    public Medico(MedicoDto dados){
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.horarioDisponivel = dados.horarioDisponivel();
        this.dataConsulta = dados.dataConsulta();
        this.horarioDescanso = dados.horarioDescanso();
    }


    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidade=" + especialidade +
                ", dataConsulta=" + dataConsulta +
                ", horarioDisponivel=" + horarioDisponivel +
                ", horarioDescanso=" + horarioDescanso +
                '}';
    }
}
