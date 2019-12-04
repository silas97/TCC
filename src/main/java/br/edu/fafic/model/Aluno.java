package br.edu.fafic.model;

public class Aluno {

    private Long idAluno;
    private String matricula;
    private Curso curso;
    private Usuario usuario;

    public Aluno() {
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Aluno{" + "idAluno=" + idAluno + ", matricula=" + matricula + ", curso=" + curso + ", usuario=" + usuario + '}';
    }

    
}
