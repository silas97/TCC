package br.edu.fafic.model;

import java.util.Date;

public class Arquivo {

    private Integer idArquivo;
    private String caminho;
    private Date dataArquivoEnviado;
    private Date dataArquivoRecebido;
    private Aluno aluno;
    private Master master;
    private String status;

    public Arquivo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataArquivoRecebido() {
        return dataArquivoRecebido;
    }

    public void setDataArquivoRecebido(Date dataArquivoRecebido) {
        this.dataArquivoRecebido = dataArquivoRecebido;
    }

    public Date getDataArquivoEnviado() {
        return dataArquivoEnviado;
    }

    public void setDataArquivoEnviado(Date dataArquivoEnviado) {
        this.dataArquivoEnviado = dataArquivoEnviado;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Integer getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(Integer idArquivo) {
        this.idArquivo = idArquivo;
    }
}
