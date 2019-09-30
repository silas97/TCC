package br.edu.fafic.model;

import java.util.Date;

public class CancelamentoMatricula {

    private Long idCancelamentoMatricula;
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

    public Long getIdCancelamentoMatricula() {
        return idCancelamentoMatricula;
    }

    public void setIdCancelamentoMatricula(Long idCancelamentoMatricula) {
        this.idCancelamentoMatricula = idCancelamentoMatricula;
    }
}