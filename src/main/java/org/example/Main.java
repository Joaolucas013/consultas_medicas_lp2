package org.example;

import org.example.consulta.ConsultaService;
import org.example.medico.Medico;
import org.example.paciente.Paciente;
import org.example.medico.MedicoService;
import org.example.paciente.PacienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();
    private static PacienteService pacienteService = new PacienteService();
    private static MedicoService medicoService = new MedicoService();
    private static ConsultaService consultaService = new ConsultaService();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            consultaService.agendar();
            menu();
            int opcao = new Scanner(System.in).nextInt();
            switch (opcao) {
                case 1:
                    exibirAgenda();
                    break;
                case 2:
                    agendarConsulta();
                    break;
                case 3:
                    bloquearHorario();
                    break;
                case 4:
                    consultarPorEspecialidade();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    continuar= false;
                    break;
            }
        }
    }

    private static void bloquearHorario() {
    }

    private static void consultarPorEspecialidade() {
        consultaService.buscarEspecialidade();
    }

    private static void exibirAgenda() {
    }

    private static void menu() {
        System.out.println(""" 
                1 - exibir agenda de todos os médicos
                2 - marcar consulta
                3 - bloquear horario
                4 - consultar por especialidade
                5 - sair
                """);
    }


    private static void agendarConsulta() {
        consultaService.agendar();
    }

}
