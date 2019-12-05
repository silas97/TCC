package br.edu.fafic.model;

import java.util.List;

public class DisciplinaCursada {

    private Long idDisciplinaCursada;
    private String instituicaoOrigem;
    private String curso;
    private String disciplina;
    private String creditos;
    private String horasCursadas;
    private List<DisciplinaCursada> disciplinaCursadas;
    private DispensaDisciplina dispensaDisciplina;

    public DisciplinaCursada() {
    }

    public List<DisciplinaCursada> getDisciplinaCursadas() {
        return disciplinaCursadas;
    }

    public void setDisciplinaCursadas(List<DisciplinaCursada> disciplinaCursadas) {
        this.disciplinaCursadas = disciplinaCursadas;
    }

    public Long getIdDisciplinaCursada() {
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

    public void setIdDisciplinaCursada(Long idDisciplinaCursada) {
        this.idDisciplinaCursada = idDisciplinaCursada;
    }


    public DispensaDisciplina getDispensaDisciplina() {
        return this.dispensaDisciplina;
    }

    public void setDispensaDisciplina(DispensaDisciplina dispensaDisciplina) {
        this.dispensaDisciplina = dispensaDisciplina;
    }

}
