package br.edu.fafic.model;

public class Master {

    private Long idMaster;
    private Usuario usuario;

    public Master() {
    }

    public Long getIdMaster() {
        return idMaster;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setIdMaster(Long idMaster) {
        this.idMaster = idMaster;
    }
}
