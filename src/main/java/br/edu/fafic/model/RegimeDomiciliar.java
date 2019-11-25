package br.edu.fafic.model;

import java.util.Date;

public class RegimeDomiciliar {

    private Long idRegimeDomiciliar;
    private Date dataInicio;
    private Date dataFim;
    private Date dataCadastro;
    private String situacao;
    private String tipo;

    public RegimeDomiciliar() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Long getIdRegimeDomiciliar() {
        return idRegimeDomiciliar;
    }

    public void setIdRegimeDomiciliar(Long idRegimeDomiciliar) {
        this.idRegimeDomiciliar = idRegimeDomiciliar;
    }
}