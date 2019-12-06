/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.DispensaDisciplinaProcessoDAO;
import br.edu.fafic.dao.DocumentoDAO;
import br.edu.fafic.model.DispensaDisciplinaProcesso;
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
    private DispensaDisciplinaProcessoDAO dispensaDAO = new DispensaDisciplinaProcessoDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletContext().getRealPath("img") + File.separator;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tipoArquivo = request.getParameter("tipo");
        String idDoProcesso = request.getParameter("id_processo");
        System.out.println("Id do Processo: " + idDoProcesso);
        DispensaDisciplinaProcesso ddp = new DispensaDisciplinaProcesso();
        ddp = dispensaDAO.selectByIdProcesso((Long) request.getSession().getAttribute("id_processo"));
        String path = "";

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
                        path = arquivo + File.separator + System.currentTimeMillis() + ".pdf";
                        item.write(new File(path));
                    }

//                    if (item.isFormField()) {  
//                        value = (String) item.getFieldName();
//                        if (value.equalsIgnoreCase("tipo")) {
//                            value = (String) item.getString();
//                        }
//
//                        item.write(new File(arquivo + File.separator + System.currentTimeMillis()));
//
//                    }
                }
//                    documentoDAO.insert(new Documento(arquivo + File.separator + System.currentTimeMillis() + ".pdf", value.toUpperCase()));
                ddp.setPahtDocumento(path);
                dispensaDAO.updateDispensaPathArquivo(ddp);

                
                request.setAttribute("message", "Arquivo enviado com sucesso!");
                request.setAttribute("classe", "alert alert-success alert-dismissible fade show");
            } catch (Exception e) {
                request.setAttribute("message", "Upload de arquivo falhou!" + e);
            }
        } else {
           request.setAttribute("message", "Erro ao salvar!");
           request.setAttribute("classe", "alert alert-warning alert-dismissible fade show");
        }

        request.getRequestDispatcher("/aluno/upload.jsp").forward(request, response);
    }

}



