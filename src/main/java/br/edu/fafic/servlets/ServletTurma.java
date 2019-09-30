/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.CursoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fafic.dao.TurmaDAO;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.Turma;

/**
 *
 * @author Silas
 */
@WebServlet("/turma")
public class ServletTurma extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String periodo = req.getParameter("periodo");
        String sigla = req.getParameter("sigla");

        TurmaDAO dao = new TurmaDAO();
        Turma sTurma;
        String param = req.getParameter("param");
        if (param.equals("cadastrar")) {
            Long idCurso_FK = Long.valueOf(req.getParameter("idCurso_FK"));
            sTurma = new Turma();
            sTurma.setPeriodo(periodo);
            sTurma.setSigla(sigla);
            CursoDAO cursoDao = new CursoDAO();
            Curso curso = new Curso();
            curso.setIdCurso(idCurso_FK);
            Curso buscaCurso = cursoDao.selectID(curso);
            sTurma.setCurso(buscaCurso);

            if (dao.insert(sTurma)) {
                req.setAttribute("message", "Turma salva com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("funcionario/cadastrar-turma.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Turma turma = new Turma();
            turma.setIdTurma(id);
            sTurma = dao.selectID(turma);
            req.getSession().setAttribute("sTurma", sTurma);
            req.getRequestDispatcher("funcionario/alterar-turma.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Long idCurso_FK = Long.valueOf(req.getParameter("idCurso_FK"));
            sTurma = new Turma();
            sTurma.setPeriodo(periodo);
            sTurma.setSigla(sigla);
            sTurma.setIdTurma(id);
            
            CursoDAO cursoDao = new CursoDAO();
            Curso curso = new Curso();
            curso.setIdCurso(idCurso_FK);
            Curso buscaCurso = cursoDao.selectID(curso);
            sTurma.setCurso(buscaCurso);
            dao.update(sTurma);
            resp.sendRedirect("funcionario/listar-turma.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sTurma = new Turma();
            sTurma.setIdTurma(id);
            dao.delete(sTurma);
            resp.sendRedirect("funcionario/listar-turma.jsp");
        }
    }
}
