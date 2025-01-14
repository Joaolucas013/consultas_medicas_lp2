package org.example.medico;

import java.time.LocalDateTime;

public record  MedicoDto( String nome, String crm, Especialidade especialidade,
                        LocalDateTime dataConsulta,
                        LocalDateTime horarioDisponivel,
                              LocalDateTime horarioDescanso) {

   public MedicoDto(Medico medico){
       this(medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getDataConsulta(),
      medico.getHorarioDisponivel(), medico.getHorarioDescanso());
   }
}
