package br.edu.fafic.model;

public class DispensaDisciplina {

    private Long idDispensaDisciplina;
    private Aluno aluno;

    public DispensaDisciplina() {
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
