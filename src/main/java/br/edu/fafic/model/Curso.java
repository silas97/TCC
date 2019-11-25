package br.edu.fafic.model;

public class Curso {

    private Long idCurso;
    private String nome;

    public Curso() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long id) {
        this.idCurso = id;
    }
}
