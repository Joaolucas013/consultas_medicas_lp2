package org.example.demo.armazenamento;


import org.example.demo.medico.Medico;
import org.example.demo.paciente.Paciente;
import org.example.demo.service.MedicoService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ArmazenamentoMedico {

    public static Scanner scanner = new Scanner(System.in);
    public static Set<Medico> listMedicosCadastrado = new HashSet<>();
    public static Set<Medico> list = new HashSet<>();
    public static MedicoService medicoService = new MedicoService();


    public void salvarMedicos() {
        listMedicosCadastrado = medicoService.retornaMedicos().stream()
                .map(e -> new Medico(e.getNome(), e.getCrm(), e.getEspecialidade(), e.getDataConsulta(), e.getHorarioDisponivel(), e.getHorarioDescanso()))
                .collect(Collectors.toSet());
        salvarMedicoArquivo("medico.txt");
    }

    private   void salvarMedicoArquivo(String arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Medico medico:listMedicosCadastrado) {
                writer.write(medico.toString());
                writer.newLine();
            }
            System.out.println("medicos salvos no arquivo: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar medico: " + e.getMessage());
        }
    }


    public void salvarMedico(Medico medico) {
     list.add(medico);
     adicionarMedico("medicos.txt", medico);
    }

    private void adicionarMedico(String file, Medico medico) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(medico.toString());
            bufferedWriter.newLine();

                System.out.println("Médico salvo com sucesso no arquivo: " + file);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar médicos no arquivo: " + e.getMessage(), e);
        }
    }


}
