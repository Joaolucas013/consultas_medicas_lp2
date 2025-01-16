package org.example.validacao;

import org.example.consulta.ExceptionConsultas;
import org.example.medico.Medico;
import org.example.paciente.Paciente;

import java.time.DayOfWeek;

public class Validacao implements ValidacaoHorario{

    @Override
    public void validar(Paciente paciente) {
        var dadosPaciente = paciente.getConsulta();
        var domingo = dadosPaciente.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dadosPaciente.getHour() < 7;
        var depoisDoFechamento = dadosPaciente.getHour() > 18;

        if(domingo || antesDaAbertura || depoisDoFechamento) {
           throw  new ExceptionConsultas("Não pode marcar consulta em feriado, nem antes das 7 e nem depois das 18");
        }
    }
}


