package br.edu.fafic.model;

public class Master {

    private Integer idMaster;
    private String matricula;
    private Curso curso;
    private Usuario usuario;

    public Master() {
    }

    public Integer getIdMaster() {
        return idMaster;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setIdMaster(Integer idMaster) {
        this.idMaster = idMaster;
    }
}