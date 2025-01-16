package org.example.validacao;

import org.example.medico.Medico;
import org.example.paciente.Paciente;

public interface ValidacaoHorario {

    void validar(Medico medico, Paciente paciente);
}
