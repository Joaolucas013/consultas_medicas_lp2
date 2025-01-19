package org.example.demo.medico;

import java.time.LocalDateTime;


public class Medico {

    private String nome;
    private String crm;
    private Especialidade especialidade;
    private LocalDateTime dataConsulta;
    private LocalDateTime horarioDisponivel;
    private LocalDateTime horarioDescanso;
    private LocalDateTime bloqueado;


    public Medico(String nome, String crm, Especialidade especialidade, LocalDateTime dataConsulta, LocalDateTime horarioDisponivel, LocalDateTime horarioDescanso) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.dataConsulta = dataConsulta;
        this.horarioDisponivel = horarioDisponivel;
        this.horarioDescanso = horarioDescanso;
        this.bloqueado = null;
    }


    public LocalDateTime getBloqueado() {
        return bloqueado;
    }

    public LocalDateTime setBloqueado(LocalDateTime bloqueado) {
        this.bloqueado = bloqueado;
        return bloqueado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalDateTime getHorarioDisponivel() {
        return horarioDisponivel;
    }

    public void setHorarioDisponivel(LocalDateTime horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

    public LocalDateTime getHorarioDescanso() {
        return horarioDescanso;
    }

    public void setHorarioDescanso(LocalDateTime horarioDescanso) {
        this.horarioDescanso = horarioDescanso;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "nome='" + nome + '\'' +
                ", crm='" + crm + '\'' +
                ", especialidade=" + especialidade +
                ", dataConsulta=" + dataConsulta +
                ", horarioDisponivel=" + horarioDisponivel +
                ", horarioDescanso=" + horarioDescanso +
               ", bloqueado=" + bloqueado +
                '}';
    }

}
