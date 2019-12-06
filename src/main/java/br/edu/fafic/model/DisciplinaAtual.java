package br.edu.fafic.model;

public class DisciplinaAtual {

    private Long idDisciplinaAtual;
    private DisciplinaCursada disciplinaCursada;
    private Disciplina disciplinaOfertada;
    private Processos processo;

    public DisciplinaAtual() {
    }

    public Long getIdDisciplinaAtual() {
        return this.idDisciplinaAtual;
    }

    public void setIdDisciplinaAtual(Long idDisciplinaAtual) {
        this.idDisciplinaAtual = idDisciplinaAtual;
    }

    public DisciplinaCursada getDisciplinaCursada() {
        return disciplinaCursada;
    }

    public void setDisciplinaCursada(DisciplinaCursada disciplinaCursada) {
        this.disciplinaCursada = disciplinaCursada;
    }
        
    public Disciplina getDisciplinaOfertada() {
        return this.disciplinaOfertada;
    }

    public void setDisciplinaOfertada(Disciplina disciplinaOfertada) {
        this.disciplinaOfertada = disciplinaOfertada;
    }

    public Processos getProcesso() {
        return processo;
    }

    public void setProcesso(Processos processo) {
        this.processo = processo;
    }
    
    

}