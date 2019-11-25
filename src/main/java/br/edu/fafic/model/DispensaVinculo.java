package br.edu.fafic.model;

public class DispensaVinculo {
    private Long idDispensaVinculo;
    private DispensaDisciplina dispensaDisciplina;
    private DisciplinaAtual disciplinaAtual;
    private DisciplinaCursada disciplinaCursada;

    public DispensaVinculo() {
    }

    public Long getIdDispensaVinculo() {
        return this.idDispensaVinculo;
    }

    public void setIdDispensaVinculo(Long idDispensaVinculo) {
        this.idDispensaVinculo = idDispensaVinculo;
    }

    public DispensaDisciplina getDispensaDisciplina() {
        return this.dispensaDisciplina;
    }

    public void setDispensaDisciplina(DispensaDisciplina dispensaDisciplina) {
        this.dispensaDisciplina = dispensaDisciplina;
    }

    public DisciplinaAtual getDisciplinaAtual() {
        return this.disciplinaAtual;
    }

    public void setDisciplinaAtual(DisciplinaAtual disciplinaAtual) {
        this.disciplinaAtual = disciplinaAtual;
    }

    public DisciplinaCursada getDisciplinaCursada() {
        return this.disciplinaCursada;
    }

    public void setDisciplinaCursada(DisciplinaCursada disciplinaCursada) {
        this.disciplinaCursada = disciplinaCursada;
    }

}