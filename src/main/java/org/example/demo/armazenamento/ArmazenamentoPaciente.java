package org.example.demo.armazenamento;


import org.example.demo.paciente.Paciente;
import org.example.demo.service.PacienteService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ArmazenamentoPaciente {

    public static Scanner scanner = new Scanner(System.in);
    public static Set<Paciente> lista = new HashSet<>();

    public void salvarPaciente(Paciente paciente) {
        lista.add(paciente);
        salvarPacienteArquivo("pacientes.txt");
    }

    private   void salvarPacienteArquivo(String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            for (Paciente paciente:lista) {
                writer.write(paciente.toString());
                writer.newLine();
            }
            System.out.println("Pacientes salvos no arquivo: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar pacientes: " + e.getMessage());
        }
    }


}
