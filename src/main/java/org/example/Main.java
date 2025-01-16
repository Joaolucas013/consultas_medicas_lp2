package org.example;

import org.example.consulta.ConsultaService;
import org.example.medico.MedicoService;
import org.example.paciente.PacienteService;

import java.util.Scanner;

public class Main {



    private static PacienteService pacienteService = new PacienteService();
    private static MedicoService medicoService = new MedicoService();
    private static ConsultaService consultaService = new ConsultaService();

    public static void main(String[] args) {
        boolean continuar = true;
       MedicoService.iniciarMedicos();
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
                    System.out.println("Bye...");
                    continuar= false;
                    break;
            }
        }
    }

    private static void cadastrarPaciente() {
       var paciente =  pacienteService.cadastrarPaciente();
        System.out.println("Paciente " + paciente.getNome() + " cadastrado com sucesso!");
    }

    private static void cadastrarMedico() {
      var medico =   medicoService.cadastrarMedico();
        System.out.println("Médico " + medico.getNome() + " cadastrado com sucesso!!!");

    }

    private static void bloquearHorario() {
    }

    private static void consultarPorEspecialidade() {
        consultaService.cadastrarPelaEspecialidade();
    }


    private static void menu() {
        System.out.println(""" 
             
                1 - Marcar consulta
                2 - Bloquear horario
                3 - Consultar por especialidade
                4 - cadastrar médico
                5 - cadastrar paciente
                6 - Sair
                """);
    }


    private static void agendarConsulta() {
        consultaService.agendar();
    }

    private static void exibir(){
        System.out.println("*** Listando médicos ***");
         medicoService.retornaMedicos().stream().forEach(System.out::println);


    }

}
