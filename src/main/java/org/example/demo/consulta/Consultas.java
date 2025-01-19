package org.example.demo.consulta;


import org.example.demo.medico.Medico;
import org.example.demo.paciente.Paciente;


import java.time.LocalDateTime;

public class Consultas {

    private LocalDateTime dataConsulta;
    private Medico medico;
    private Paciente paciente;

    public Consultas(LocalDateTime horario, Medico medico, Paciente paciente) {
        this.dataConsulta = paciente.getConsulta();
        this.medico = medico;
        this.paciente = paciente;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Consultas{" +
                "horario consulta=" + dataConsulta +
                ", medico=" + medico +
                ", paciente=" + paciente +
                '}';
    }


}
