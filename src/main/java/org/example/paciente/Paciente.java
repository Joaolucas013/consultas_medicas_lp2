package org.example.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class Paciente {
    private String nome;
    private String sexo;
    private int idade;
    private LocalDateTime consulta;


    public Paciente(PacienteDto dados) {
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.idade = dados.idade();
        this.consulta = dados.consulta();
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", idade=" + idade +
                ", consulta=" + consulta +
                '}';
    }
}
