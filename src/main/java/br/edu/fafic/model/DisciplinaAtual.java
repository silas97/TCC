package br.edu.fafic.model;

public class DisciplinaAtual {

    private Long idDisciplinaAtual;
    private DispensaDisciplina dispensaDisciplina;
    private Disciplina disciplina;

    public DisciplinaAtual() {
    }

    public Long getIdDisciplinaAtual() {
        return this.idDisciplinaAtual;
    }

    public void setIdDisciplinaAtual(Long idDisciplinaAtual) {
        this.idDisciplinaAtual = idDisciplinaAtual;
    }

    public DispensaDisciplina getDispensaDisciplina() {
        return this.dispensaDisciplina;
    }

    public void setDispensaDisciplina(DispensaDisciplina dispensaDisciplina) {
        this.dispensaDisciplina = dispensaDisciplina;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}