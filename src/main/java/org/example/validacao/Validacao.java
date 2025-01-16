package org.example.validacao;

import org.example.consulta.ExceptionConsultas;
import org.example.medico.Medico;
import org.example.paciente.Paciente;

import java.time.DayOfWeek;

public class Validacao implements ValidacaoHorario{

    @Override
    public void validar(Medico medico, Paciente paciente) {
        var dadosPaciente = paciente.getConsulta();
        var domingo = dadosPaciente.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = dadosPaciente.getHour() < 7;
        var depoisDoFechamento = dadosPaciente.getHour() > 18;

        if(domingo || antesDaAbertura || depoisDoFechamento) {
           throw  new ExceptionConsultas("Não pode marcar consulta em feriado, nem antes das 7 e nem depois das 18");
        }
    }
}


// var dadosConsulta = dados;
//        var domingo = dados.data().getDayOfWeek().equals(DayOfWeek.SUNDAY);
//        var AntesDaAberturaClinica = dadosConsulta.data().getHour() < 7;
//        var DepoisDoFechamentoClinica = dadosConsulta.data().getHour() >18;