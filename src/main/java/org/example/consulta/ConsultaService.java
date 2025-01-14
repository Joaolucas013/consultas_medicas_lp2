package org.example.consulta;

import org.example.medico.Medico;
import org.example.medico.MedicoDto;
import org.example.medico.ExceptionConsultas;
import org.example.medico.MedicoService;
import org.example.paciente.Paciente;
import org.example.paciente.PacienteDto;
import org.example.paciente.PacienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaService {

    Scanner scanner = new Scanner(System.in);

    List<Consultas> consultasList = new ArrayList<>();

    MedicoService medicoService = new MedicoService();
    PacienteService pacienteService = new PacienteService();


    public MedicoDto procurarMedico(String nome) {
        // retorna uma lista de MedicosDto
        List<MedicoDto> medicos = medicoService.retornaMedicos();

        if (medicos.isEmpty()) {
            throw new ExceptionConsultas("Lista de medicos esta vazia.");
        }

        // percorre toda a lista ate achar o nome igual
        for (MedicoDto medico1 : medicos) {
            if (medico1.nome().equalsIgnoreCase(nome)) {
                return medico1;
            }
        }
        return null;
    }

    private PacienteDto buscarPaciente( String nomePaciente) {
        List<PacienteDto> pacienteList = pacienteService.retornaListaPaciente();

        if (pacienteList.isEmpty()) {
           throw new ExceptionConsultas("Lista de paciente esta vazia.");
        }

        for (PacienteDto pacienteDto:pacienteList){
           if(pacienteDto.nome().equalsIgnoreCase(nomePaciente)){
               return pacienteDto;
           }
       }

        return null;
    }


    public void agendar() {
        pacienteService.cadastrarPaciente();
        medicoService.cadastrarMedico();
        medicoService.retornaMedicos().stream().forEach(System.out::println);
        System.out.println("Informe o nome de algum medico para agendar consulta: ");
        String nome = scanner.nextLine();

        MedicoDto m = procurarMedico(nome);
        Medico medico = new Medico(m.nome(), m.crm(), m.especialidade(),
                m.dataConsulta(), m.horarioDisponivel(), m.horarioDescanso());

        pacienteService.retornaListaPaciente().stream().forEach(System.out::println);
        System.out.println("Informe o nome do paciente: ");
        String nomePaciente = scanner.nextLine();

        PacienteDto p = buscarPaciente(nomePaciente);
        Paciente paciente = new Paciente(p.nome(), p.sexo(), p.idade());

        Consultas consultas = new Consultas(medico.getDataConsulta(), medico, paciente);
        consultasList.add(consultas);
        consultasList.stream().forEach(System.out::println);

    }
}