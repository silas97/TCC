package br.edu.fafic.model;

public class Master {

    private Long idMaster;
    private String matricula;
    private Curso curso;
    private Usuario usuario;

    public Master() {
    }

    public Long getIdMaster() {
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

    public void setIdMaster(Long idMaster) {
        this.idMaster = idMaster;
    }
}