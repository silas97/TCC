/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.model;

import java.util.List;

/**
 *
 * @author Luciano
 */
public class DisciplinaCursadaAluno {
    
    private Long id;
    private Aluno aluno;
    private List<DisciplinaCursada> disciplinasCursadas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<DisciplinaCursada> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public void setDisciplinasCursadas(List<DisciplinaCursada> disciplinasCursadas) {
        this.disciplinasCursadas = disciplinasCursadas;
    }
    
    
    
    
}
