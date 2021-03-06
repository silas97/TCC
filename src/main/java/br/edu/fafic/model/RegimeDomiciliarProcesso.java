package br.edu.fafic.model;

import java.util.Date;

public class RegimeDomiciliarProcesso {

    private Long idRegimeDomiciliarProcesso;
    private Date dataProcesso;
    private Date dataEncerramento;
    private String status;
    private String visibilidade;
    private Processos processos;
    private RegimeDomiciliar regimeDomiciliar;

    public RegimeDomiciliarProcesso() {
    }

    public Long getIdRegimeDomiciliarProcesso() {
        return idRegimeDomiciliarProcesso;
    }

    public RegimeDomiciliar getRegimeDomiciliar() {
        return regimeDomiciliar;
    }

    public void setRegimeDomiciliar(RegimeDomiciliar regimeDomiciliar) {
        this.regimeDomiciliar = regimeDomiciliar;
    }

    public Processos getProcessos() {
        return processos;
    }

    public void setProcessos(Processos processos) {
        this.processos = processos;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Date getDataProcesso() {
        return dataProcesso;
    }

    public void setDataProcesso(Date dataProcesso) {
        this.dataProcesso = dataProcesso;
    }

    public void setIdRegimeDomiciliarProcesso(Long idRegimeDomiciliarProcesso) {
        this.idRegimeDomiciliarProcesso = idRegimeDomiciliarProcesso;
    }
}