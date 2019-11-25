package br.edu.fafic.model;

public class DispensaDisciplina {

    private Long idDispensaDisciplina;
    private Aluno aluno;
    private DisciplinaCursada disciplinaCursada;
    private Disciplina disciplina;

    public DispensaDisciplina() {
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public DisciplinaCursada getDisciplinaCursada() {
        return disciplinaCursada;
    }

    public void setDisciplinaCursada(DisciplinaCursada disciplinaCursada) {
        this.disciplinaCursada = disciplinaCursada;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Long getIdDispensaDisciplina() {
        return idDispensaDisciplina;
    }

    public void setIdDispensaDisciplina(Long idDispensaDisciplina) {
        this.idDispensaDisciplina = idDispensaDisciplina;
    }
}
