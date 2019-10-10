package br.edu.fafic.model;

public class Processos {

    private Long idProcessos;
    private Aluno aluno;
    private String tipo;

    public Processos() {
    }

    public Long getIdProcessos() {
        return this.idProcessos;
    }

    public void setIdProcessos(Long idProcessos) {
        this.idProcessos = idProcessos;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
