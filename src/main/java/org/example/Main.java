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
            for (int i = 0; i <1 ; i++) {
                agendarConsulta();
            }
            System.out.println("Deseja continuar? (S/N)");
            String opcao = new Scanner(System.in).nextLine().toUpperCase();
            if (opcao.contains("S")) {
                continuar = true;
            } else {
                System.out.println("Saindo...");
                continuar = false;
            }
        }


    }


    private static void agendarConsulta() {
        consultaService.agendar();
    }

}
