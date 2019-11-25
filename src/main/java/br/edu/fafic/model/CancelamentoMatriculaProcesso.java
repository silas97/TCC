package br.edu.fafic.model;

import java.util.Date;

public class CancelamentoMatriculaProcesso {

    private Long idCancelamentoMatriculaProcesso;
    private Date dataProcesso;
    private Date dataEncerramento;
    private String status;
    private String visibilidade;
    private Processos processos;
    private CancelamentoMatricula cancelamentoMatricula;

    public CancelamentoMatriculaProcesso() {
    }

    public Long getIdCancelamentoMatriculaProcesso() {
        return idCancelamentoMatriculaProcesso;
    }

    public CancelamentoMatricula getCancelamentoMatricula() {
        return cancelamentoMatricula;
    }

    public void setCancelamentoMatricula(CancelamentoMatricula cancelamentoMatricula) {
        this.cancelamentoMatricula = cancelamentoMatricula;
    }

    public Processos getProcessos() {
        return processos;
    }

    public void setProcessos(Processos processos) {
        this.processos = processos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
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

    public void setIdCancelamentoMatriculaProcesso(Long idCancelamentoMatriculaProcesso) {
        this.idCancelamentoMatriculaProcesso = idCancelamentoMatriculaProcesso;
    }

}
