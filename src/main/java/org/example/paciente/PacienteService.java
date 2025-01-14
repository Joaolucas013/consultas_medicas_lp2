package org.example.paciente;

import org.example.medico.Medico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PacienteService {
    Scanner scanner = new Scanner(System.in);
    List<Paciente> pacienteList = new ArrayList<>();

    public void cadastrarPaciente() {
        System.out.println("Informe o  nome do paciente:");
        String nome = new Scanner(System.in).nextLine().trim();
        System.out.println("Informe o sexo:");
        String sexo = new Scanner(System.in).nextLine().trim();
        System.out.println("Informe a sua idade:");
        int idade = scanner.nextInt();

        pacienteList.add(new Paciente(nome, sexo, idade));
    }

    public List<PacienteDto> retornaListaPaciente() {
        List<PacienteDto> pacienteDtos = pacienteList
                .stream().map(p -> new PacienteDto(p.getNome(), p.getSexo(), p.getIdade()))
                .collect(Collectors.toList());

        return pacienteDtos;
    }

}
