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

import br.edu.fafic.dao.CursoDAO;
import br.edu.fafic.model.Curso;

/**
 *
 * @author Silas
 */
@WebServlet("/curso")
public class ServletCurso extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        
        CursoDAO dao = new CursoDAO();
        Curso course;
        String param = req.getParameter("param");
        if (param.equals("cadastrar")) {
            course = new Curso();
            course.setNome(nome);

            if (dao.insert(course)) {
                req.setAttribute("message", "Curso cadastrado com sucesso!");
                req.setAttribute("classe", "alert alert-success alert-dismissible fade show");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
                req.setAttribute("classe", "alert alert-warning alert-dismissible fade show");
                
            }
            req.getRequestDispatcher("/funcionario/cadastrar-curso.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Curso curso = new Curso();
            curso.setIdCurso(id);
            course = dao.selectID(curso);
            req.getSession().setAttribute("course", course);
            req.getRequestDispatcher("funcionario/alterar-curso.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            course = new Curso();
            course.setNome(nome);
            course.setIdCurso(id);
            dao.update(course);
            resp.sendRedirect("funcionario/listar-curso.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            course = new Curso();
            course.setIdCurso(id);
            dao.delete(course);
            resp.sendRedirect("funcionario/listar-curso.jsp");
        }
    }
}
