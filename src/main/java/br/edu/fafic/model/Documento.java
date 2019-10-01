/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.model;

/**
 *
 * @author Luciano
 */
public class Documento {
    
    private Integer id;
    private String path;
    private String tipo;
    
    public Documento(){
        
    }

    public Documento(String path, String tipo) {
        this.path = path;
        this.tipo = tipo;
    }

    public Documento(Integer id, String path, String tipo) {
        this.id = id;
        this.path = path;
        this.tipo = tipo;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo.toUpperCase();
    }
    
    
    
    
    
}
