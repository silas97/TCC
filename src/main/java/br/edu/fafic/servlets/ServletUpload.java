/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.DisciplinaCursadaDAO;
import br.edu.fafic.dao.DisciplinaDAO;
import br.edu.fafic.dao.DispensaDisciplinaProcessoDAO;
import br.edu.fafic.dao.DocumentoDAO;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.DispensaDisciplinaProcesso;
import br.edu.fafic.model.Usuario;
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

    private File arquivo = new File("C:\\Users\\uploads");
    private final DocumentoDAO documentoDAO = new DocumentoDAO();
    private DispensaDisciplinaProcessoDAO dispensaDAO = new DispensaDisciplinaProcessoDAO();
    private DisciplinaCursadaDAO daoDisciplinaCursada = new DisciplinaCursadaDAO();
    private DisciplinaDAO daoDisciplina = new DisciplinaDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletContext().getRealPath("img") + File.separator;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long idDoProcesso = (Long)request.getSession().getAttribute("id_processo");
       
//        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
//        Aluno a = daoDisciplinaCursada.getIdAlunoFromUsuario(usuario);
       

//        String tipoArquivo = request.getParameter("tipo");

        DispensaDisciplinaProcesso ddp = new DispensaDisciplinaProcesso();
        ddp = dispensaDAO.selectByIdProcesso(idDoProcesso);
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
                String link =  "<a href="+request.getContextPath()+"/aluno>Aqui</a>"; 
                dispensaDAO.updateDispensaPathArquivo(ddp);
                request.getSession().removeAttribute("id_processo");
                request.setAttribute("classe", "alert alert-success alert-dismissible fade show");
                request.setAttribute("titulo", "Operação realizada com sucesso!");
                request.setAttribute("message", "Sua solicitação foi realizada com sucesso. Acompanhe seu processo aqui");
                request.setAttribute("link", link);
                request.getRequestDispatcher("/aluno/uploadMessage.jsp").forward(request, response);
            } catch (Exception e) {
                request.getSession().removeAttribute("id_processo");
                request.setAttribute("classe", "alert alert-warning alert-dismissible fade show");
                request.setAttribute("titulo", "Operação não realizada!");
                request.setAttribute("message", "Um erro inesperado ocorreu.");
                request.getRequestDispatcher("/aluno/uploadMessage.jsp").forward(request, response);
            }
        } else {
                request.getSession().removeAttribute("id_processo");
                request.setAttribute("classe", "alert alert-warning alert-dismissible fade show");
                request.setAttribute("titulo", "Operação não realizada!");
                request.setAttribute("message", "Erro ao realizar o upload do arquivo.");
                request.getRequestDispatcher("/aluno/uploadMessage.jsp").forward(request, response);
        }

        
    }
    

}
