package br.edu.fafic.model;

public class RegimeDisciplina {

    private Long idRegimeDisciplina;
    private RegimeDomiciliar regimeDomiciliar;
    private Disciplina disciplina;

    public RegimeDisciplina() {
    }

    public Long getIdRegimeDisciplina() {
        return this.idRegimeDisciplina;
    }

    public void setIdRegimeDisciplina(Long idRegimeDisciplina) {
        this.idRegimeDisciplina = idRegimeDisciplina;
    }

    public RegimeDomiciliar getRegimeDomiciliar() {
        return this.regimeDomiciliar;
    }

    public void setRegimeDomiciliar(RegimeDomiciliar regimeDomiciliar) {
        this.regimeDomiciliar = regimeDomiciliar;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}