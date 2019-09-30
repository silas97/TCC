/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.DocumentoDAO;
import br.edu.fafic.model.Documento;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luciano
 */
@WebServlet("/listar")
public class ServletListarArquivos extends HttpServlet {
    
    private final DocumentoDAO documentoDAO = new DocumentoDAO();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        List<Documento> documentos = documentoDAO.listaDocumentos();
        for(Documento doc : documentos){
            System.out.println("Documento: " +doc.getTipo());
        }
        req.setAttribute("documentos", documentos);
        req.getRequestDispatcher("secretaria/upload.jsp").forward(req, resp);
        
    }
    
    
    
}
