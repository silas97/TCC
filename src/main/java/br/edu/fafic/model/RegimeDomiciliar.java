package br.edu.fafic.model;

import java.util.Date;

public class RegimeDomiciliar {

    private Integer idRegimeDomiciliar;
    private Date dataInicio;
    private Date dataFim;
    private Date dataCadastro;
    private String situacao;
    private String tipo;
    private Disciplina disciplina;

    public RegimeDomiciliar() {
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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

    public Integer getIdRegimeDomiciliar() {
        return idRegimeDomiciliar;
    }

    public void setIdRegimeDomiciliar(Integer idRegimeDomiciliar) {
        this.idRegimeDomiciliar = idRegimeDomiciliar;
    }
}