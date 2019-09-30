/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fafic.dao.CancelamentoMatriculaDAO;
import br.edu.fafic.model.CancelamentoMatricula;

/**
 *
 * @author Silas
 */
@WebServlet("/cancelamentoMatricula")
public class ServletCancelamentoMatricula extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String justificativa = req.getParameter("justificativa");
        
        CancelamentoMatriculaDAO dao = new CancelamentoMatriculaDAO();
        CancelamentoMatricula sCancelamentoMatricula;
        String param = req.getParameter("param");
        if (param.equals("cadastrar")) {
            sCancelamentoMatricula = new CancelamentoMatricula();
            sCancelamentoMatricula.setJustificativa(justificativa);

            if (dao.insert(sCancelamentoMatricula)) {
                req.setAttribute("message", "CancelamentoMatricula salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("/aluno/cadastrar-cancelamento-matricula.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            CancelamentoMatricula cancelamentoMatricula = new CancelamentoMatricula();
            cancelamentoMatricula.setIdCancelamentoMatricula(id);
            sCancelamentoMatricula = dao.selectID(cancelamentoMatricula);
            req.getSession().setAttribute("sCancelamentoMatricula", sCancelamentoMatricula);
            req.getRequestDispatcher("aluno/alterar-cancelamento-matricula.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sCancelamentoMatricula = new CancelamentoMatricula();
            sCancelamentoMatricula.setJustificativa(justificativa);
            sCancelamentoMatricula.setIdCancelamentoMatricula(id);
            dao.update(sCancelamentoMatricula);
            resp.sendRedirect("aluno/listar-cancelamento-matricula.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sCancelamentoMatricula = new CancelamentoMatricula();
            sCancelamentoMatricula.setIdCancelamentoMatricula(id);
            dao.delete(sCancelamentoMatricula);
            resp.sendRedirect("aluno/listar-cancelamento-matricula.jsp");
        }
    }
}
