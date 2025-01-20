package org.example.demo.armazenamento;


import org.example.demo.consulta.Consultas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ArmazenamentoConsultas {

    Set<Consultas> consultasList = new HashSet<>();

    public void salvarConsultas(Consultas consultas) {
        consultasList.add(consultas);
        salvarConsultaEmArquivo( "consultas.txt");
    }

    private void salvarConsultaEmArquivo(String file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            for (Consultas consultas:consultasList) {
                bufferedWriter.write(consultas.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Consulta salva com sucess no arquivo:" + file);
    }



}
