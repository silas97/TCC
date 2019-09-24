/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
    private File uploads = new File("C:\\Users\\uploads");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String path = request.getServletContext().getRealPath("img") + File.separator;

        File files = new File(path);
        response.setContentType("image/jpge");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        // item.write(new File(request.getServletContext().getRealPath("img") +
                        // File.separator + item.getName()));
                        if (!uploads.exists()) {
                            uploads = new File("C:\\Users\\uploads");
                        }
                        item.write(new File(uploads + File.separator + System.currentTimeMillis()));
                    }
                }
                request.setAttribute("message", "Arquivo carregado com sucesso!");
            } catch (Exception e) {
                request.setAttribute("message", "Upload de arquivo falhou!" + e);
            }
        } else {
            request.setAttribute("message", "Só lida com arquivos!");
        }
        request.getRequestDispatcher("upload.jsp").forward(request, response);
    }
}
