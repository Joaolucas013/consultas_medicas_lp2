package org.example.medico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record  MedicoDto(

        @NotBlank
        String nome,
        @Pattern(regexp = "\\d{4,6}") // crm deve ter de 4 a 6 dígitos
        String crm,
        @NotNull
        Especialidade especialidade,

        @NotNull
        @Future
        LocalDateTime dataConsulta,
        @NotNull
        @Future
        LocalDateTime horarioDisponivel,
        @NotNull
        @Future
        LocalDateTime horarioDescanso) {

   public MedicoDto(Medico medico){
       this(medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getDataConsulta(),
      medico.getHorarioDisponivel(), medico.getHorarioDescanso());
   }
}
