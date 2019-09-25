package br.edu.fafic.model;

public class Processos{
    
    private Long idProcessos;
    private Aluno aluno;

    public Processos() {
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Long getIdProcessos() {
        return idProcessos;
    }

    public void setIdProcessos(Long idProcessos) {
        this.idProcessos = idProcessos;
    }
}