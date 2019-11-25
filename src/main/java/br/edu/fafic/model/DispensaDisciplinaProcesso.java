package br.edu.fafic.model;

import java.util.Date;

public class DispensaDisciplinaProcesso {

    private Long idDispensaDisciplinaProcesso;
    private Date dataProcesso;
    private Date dataEncerramento;
    private String status;
    private String visibilidade;
    private Processos processos;
    private DispensaDisciplina dispensaDisciplina;

    public Long getIdDispensaDisciplinaProcesso() {
        return idDispensaDisciplinaProcesso;
    }

    public DispensaDisciplina getDispensaDisciplina() {
        return dispensaDisciplina;
    }

    public void setDispensaDisciplina(DispensaDisciplina dispensaDisciplina) {
        this.dispensaDisciplina = dispensaDisciplina;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
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

    public void setIdDispensaDisciplinaProcesso(Long idDispensaDisciplinaProcesso) {
        this.idDispensaDisciplinaProcesso = idDispensaDisciplinaProcesso;
    }
}
