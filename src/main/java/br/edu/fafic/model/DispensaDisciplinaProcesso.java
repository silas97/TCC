package br.edu.fafic.model;

import java.util.Date;
import java.util.List;

public class DispensaDisciplinaProcesso {

    private Long idDispensaDisciplinaProcesso;
    private Date dataProcesso;
    private Date dataEncerramento;
    private String status;
    private String visibilidade;
    private String pahtDocumento;
    private Processos processos;
    private DisciplinaCursadaAluno disciplinasCursadas;
    private List<Disciplina> disciplinasOfertadas;
    
    

    public Long getIdDispensaDisciplinaProcesso() {
        return idDispensaDisciplinaProcesso;
    }

   
    public String getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(String visibilidade) {
        this.visibilidade = visibilidade;
    }

    public Processos getProcessos() {
        return processos;
    }

    public void setProcessos(Processos processos) {
        this.processos = processos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Date getDataProcesso() {
        return dataProcesso;
    }

    public void setDataProcesso(Date dataProcesso) {
        this.dataProcesso = dataProcesso;
    }

    public void setIdDispensaDisciplinaProcesso(Long idDispensaDisciplinaProcesso) {
        this.idDispensaDisciplinaProcesso = idDispensaDisciplinaProcesso;
    }

    public DisciplinaCursadaAluno getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public void setDisciplinasCursadas(DisciplinaCursadaAluno disciplinasCursadas) {
        this.disciplinasCursadas = disciplinasCursadas;
    }

    public List<Disciplina> getDisciplinasOfertadas() {
        return disciplinasOfertadas;
    }

    public void setDisciplinasOfertadas(List<Disciplina> disciplinasOfertadas) {
        this.disciplinasOfertadas = disciplinasOfertadas;
    }

    public String getPahtDocumento() {
        return pahtDocumento;
    }

    public void setPahtDocumento(String pahtDocumento) {
        this.pahtDocumento = pahtDocumento;
    }
    
    
    
    
}
