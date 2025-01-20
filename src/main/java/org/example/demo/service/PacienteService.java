package org.example.demo.service;



import org.example.demo.paciente.Paciente;
import org.example.demo.armazenamento.ArmazenamentoPaciente;
import org.example.demo.exception.ExceptionConsultas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacienteService {

    Scanner scanner = new Scanner(System.in);
     List<Paciente> pacienteList = new ArrayList<>();
    ArmazenamentoPaciente armazenamentoPaciente = new ArmazenamentoPaciente();

    public Paciente cadastrarPaciente() {
        System.out.println("Informe o  nome do paciente:");
        String nome = scanner.nextLine().trim();
        System.out.println("Informe a sua idade:");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o sexo:");
        String sexo = scanner.nextLine().trim();
        System.out.println("Informe o data e horario da consulta:");
        LocalDateTime horario = LocalDateTime.parse(scanner.nextLine().trim());


        Paciente paciente = new Paciente(nome,sexo, idade, horario);
        validar(paciente);
        pacienteList.add(paciente);
        armazenamentoPaciente.salvarPaciente();

        return paciente;
    }

    private void validar(Paciente paciente) {
        List<Paciente> listPaciente= pacienteList;
       var pac =  paciente.getConsulta().getDayOfWeek();

        for (int i = 0; i <listPaciente.size(); i++) {
            Paciente p = listPaciente.get(i);
            if(p.getConsulta().getDayOfWeek().equals(pac)){
                System.out.println("Erro! já existe uma consulta agendada para o dia: " + paciente.getConsulta());
                System.out.println("Escolha outro dia:");
                System.out.println("Informe o data e horario da consulta:");
                LocalDateTime horario = LocalDateTime.parse(scanner.nextLine().trim());
                paciente.setConsulta(horario);

            }
        }
    }

    public List<Paciente> retornaListaPaciente() {
        return pacienteList;
    }

    public Paciente buscarPaciente(String nomePaciente) {
        List<Paciente> pacienteList = retornaListaPaciente();
        boolean encontrado = false;

        if (pacienteList.isEmpty()) {
            throw new ExceptionConsultas("Lista de paciente esta vazia.");
        }

        for (Paciente p : pacienteList) {
            if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                encontrado = true;
                return p;
            }
        }
        if (!encontrado) {
            System.out.println("Paciente não foi encontrado!!!");
        }
        return null;
    }

}
