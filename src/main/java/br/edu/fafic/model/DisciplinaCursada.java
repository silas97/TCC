package br.edu.fafic.model;

public class DisciplinaCursada {

    private Integer idDisciplinaCursada;
    private String instituicaoOrigem;
    private String curso;
    private String disciplina;
    private String creditos;
    private String horasCursadas;

    public DisciplinaCursada() {
    }

    public Integer getIdDisciplinaCursada() {
        return idDisciplinaCursada;
    }

    public String getHorasCursadas() {
        return horasCursadas;
    }

    public void setHorasCursadas(String horasCursadas) {
        this.horasCursadas = horasCursadas;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInstituicaoOrigem() {
        return instituicaoOrigem;
    }

    public void setInstituicaoOrigem(String instituicaoOrigem) {
        this.instituicaoOrigem = instituicaoOrigem;
    }

    public void setIdDisciplinaCursada(Integer idDisciplinaCursada) {
        this.idDisciplinaCursada = idDisciplinaCursada;
    }
}