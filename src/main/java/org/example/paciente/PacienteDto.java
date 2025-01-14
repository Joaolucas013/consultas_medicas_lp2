package org.example.paciente;

import java.time.LocalDateTime;

public record PacienteDto(String nome, String sexo, int idade, LocalDateTime consulta){

    public PacienteDto(Paciente p){
        this(p.getNome(), p.getSexo(), p.getIdade(), p.getConsulta());
    }
}
