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

import br.edu.fafic.dao.DisciplinaDAO;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.Disciplina;

/**
 *
 * @author Silas
 */
@WebServlet("/disciplina")
public class ServletDisciplina extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String creditos = req.getParameter("creditos");
        String cargaHoraria = req.getParameter("cargaHoraria");
        String idCurso_FK = req.getParameter("idCurso_FK");
        System.out.println(idCurso_FK);
        Long idCurso = Long.valueOf(idCurso_FK);

        DisciplinaDAO dao = new DisciplinaDAO();
        Disciplina discipline;
        String param = req.getParameter("param");
        if (param.equals("cadastrar")) {
            discipline = new Disciplina();
            discipline.setNome(nome);
            discipline.setCreditos(creditos);
            discipline.setCargaHoraria(cargaHoraria);
            CursoDAO cursoDao = new CursoDAO();
            Curso curso1 = new Curso();
            curso1.setIdCurso(idCurso);
            Curso curso2 =  cursoDao.selectID(curso1);
            discipline.setCurso(curso2);

            if (dao.insert(discipline)) {
                req.setAttribute("message", "Disciplina salva com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("funcionario/cadastrar-disciplina.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Disciplina disciplina = new Disciplina();
            disciplina.setIdDisciplina(id);
            discipline = dao.selectID(disciplina);
            req.getSession().setAttribute("discipline", discipline);
            req.getRequestDispatcher("funcionario/alterar-disciplina.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            discipline = new Disciplina();
            discipline.setNome(nome);
            discipline.setCreditos(creditos);
            discipline.setCargaHoraria(cargaHoraria);
            discipline.getCurso().setIdCurso(idCurso);
            discipline.setIdDisciplina(id);
            dao.update(discipline);
            resp.sendRedirect("funcionario/listar-disciplina.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            discipline = new Disciplina();
            discipline.setIdDisciplina(id);
            dao.delete(discipline);
            resp.sendRedirect("funcionario/listar-disciplina.jsp");
        }
    }
}
