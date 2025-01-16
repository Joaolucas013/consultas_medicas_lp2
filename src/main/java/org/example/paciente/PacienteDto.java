package org.example.paciente;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record PacienteDto(

        @NotBlank
        String nome,
        @NotBlank
        String sexo,

        @NotNull
        @Positive
        int idade,
        @NotNull
        @Future
        LocalDateTime consulta) {

    public PacienteDto(Paciente p){
        this(p.getNome(), p.getSexo(), p.getIdade(), p.getConsulta());
    }
}
