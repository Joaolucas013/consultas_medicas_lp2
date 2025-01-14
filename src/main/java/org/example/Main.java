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



    private static PacienteService pacienteService = new PacienteService();
    private static MedicoService medicoService = new MedicoService();
    private static ConsultaService consultaService = new ConsultaService();

    public static void main(String[] args) {
        boolean continuar = true;
       exibir();

        while (continuar) {
            menu();
            int opcao = new Scanner(System.in).nextInt();
            switch (opcao) {
                case 1:
                    agendarConsulta();
                    break;
                case 2:
                    bloquearHorario();
                    break;
                case 3:
                    consultarPorEspecialidade();
                    break;
                case 4:
                    cadastrarMedico();
                    break;
                case 5:
                    cadastrarPaciente();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    continuar= false;
                    break;
            }
        }
    }

    private static void cadastrarPaciente() {
        pacienteService.cadastrarPaciente();
    }

    private static void cadastrarMedico() {
        medicoService.cadastrarMedico();

    }

    private static void bloquearHorario() {
    }

    private static void consultarPorEspecialidade() {
        consultaService.buscarEspecialidade();
    }

    private static void exibirAgenda() {
      var medicos =  medicoService.retornaMedicos();
      medicos.stream().forEach(System.out::println);
    }

    private static void menu() {
        System.out.println(""" 
             
                1 - Marcar consulta
                2 - Bloquear horario
                3 - Consultar por especialidade
                4 - Sair
                """);
    }


    private static void agendarConsulta() {
        consultaService.agendar();
    }

    private static void exibir(){
        System.out.println("*** Listando médicos ***");
        medicoService.iniciarMedicos();
        exibirAgenda();
    }

}
