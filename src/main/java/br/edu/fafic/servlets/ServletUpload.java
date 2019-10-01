/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.DocumentoDAO;
import br.edu.fafic.model.Documento;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Init;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Silas
 */
@WebServlet("/upload")

public class ServletUpload extends HttpServlet {

    private static final long serialVersionUID = 1;

    private File arquivo = new File("C:\\Users\\uploads");
    private final DocumentoDAO documentoDAO = new DocumentoDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletContext().getRealPath("img") + File.separator;
    }
    
    

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
   String tipoArquivo = request.getParameter("tipo");

        if (!arquivo.exists()) {
            arquivo = new File("C:\\Users\\uploads");
        }

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                String value = "";
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
//                        item.write(new File(request.getServletContext().getRealPath("img") + File.separator + "uploadfile"));
                        item.write(new File(arquivo + File.separator + System.currentTimeMillis() + ".pdf"));
                    }

                    if (item.isFormField()) {  
                        value = (String) item.getFieldName();
                        if (value.equalsIgnoreCase("tipo")) {
                            value = (String) item.getString();
                        }

                        item.write(new File(arquivo + File.separator + System.currentTimeMillis()));

                    }
                }
                    documentoDAO.insert(new Documento(arquivo + File.separator + System.currentTimeMillis() + ".pdf", value.toUpperCase()));

                    request.setAttribute("message", "Arquivo carregado com sucesso!");
                }catch (Exception e) {
                request.setAttribute("message", "Upload de arquivo falhou!" + e);
            }
            }else {
            request.setAttribute("message", "Só lida com arquivos!");
        }

            request.getRequestDispatcher("upload.jsp").forward(request, response);
        }

    }
