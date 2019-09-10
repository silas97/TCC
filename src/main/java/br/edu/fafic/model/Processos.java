package br.edu.fafic.model;

public class Processos{
    
    private Integer idProcessos;
    private Aluno aluno;

    public Processos() {
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getIdProcessos() {
        return idProcessos;
    }

    public void setIdProcessos(Integer idProcessos) {
        this.idProcessos = idProcessos;
    }
}