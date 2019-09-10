package br.edu.fafic.model;

import java.util.Date;

public class CancelamentoMatricula {

    private Integer idCancelamentoMatricula;
    private String justificativa;
    private Date dataCadastro;

    public CancelamentoMatricula() {
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public Integer getIdCancelamentoMatricula() {
        return idCancelamentoMatricula;
    }

    public void setIdCancelamentoMatricula(Integer idCancelamentoMatricula) {
        this.idCancelamentoMatricula = idCancelamentoMatricula;
    }
}