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
import br.edu.fafic.dao.DisciplinaCursadaDAO;
import br.edu.fafic.model.DisciplinaCursada;

/**
 *
 * @author Silas
 */
@WebServlet("/disciplinaCursada")
public class ServletDisciplinaCursada extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String instituicaoOrigem = req.getParameter("instituicaoOrigem");
        String curso = req.getParameter("curso");
        String disciplina = req.getParameter("disciplina");
        String creditos = req.getParameter("creditos");
        String horasCursadas = req.getParameter("horasCursadas");
        
        DisciplinaCursadaDAO dao = new DisciplinaCursadaDAO();
        DisciplinaCursada disciplinaCursada;
        String param = req.getParameter("param");
        if (param.equals("cadastrar")) {
            disciplinaCursada = new DisciplinaCursada();
            disciplinaCursada.setInstituicaoOrigem(instituicaoOrigem);
            disciplinaCursada.setCurso(curso);
            disciplinaCursada.setDisciplina(disciplina);
            disciplinaCursada.setCreditos(creditos);
            disciplinaCursada.setHorasCursadas(horasCursadas);

            if (dao.insert(disciplinaCursada)) {
                req.setAttribute("message", "DisciplinaCursada salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("/aluno/cadastrar-disciplina-cursada.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            disciplinaCursada = new DisciplinaCursada();
            disciplinaCursada.setIdDisciplinaCursada(id);
            disciplinaCursada = dao.selectID(disciplinaCursada);
            System.out.println(disciplinaCursada.getCurso());
            req.getSession().setAttribute("sDisciplinaCursada", disciplinaCursada);
            req.getRequestDispatcher("aluno/alterar-disciplina-cursada.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            disciplinaCursada = new DisciplinaCursada();
            disciplinaCursada.setInstituicaoOrigem(instituicaoOrigem);
            disciplinaCursada.setCurso(curso);
            disciplinaCursada.setDisciplina(disciplina);
            disciplinaCursada.setCreditos(creditos);
            disciplinaCursada.setHorasCursadas(horasCursadas);
            disciplinaCursada.setIdDisciplinaCursada(id);
            dao.update(disciplinaCursada);
            resp.sendRedirect("aluno/listar-disciplina-cursada.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            disciplinaCursada = new DisciplinaCursada();
            disciplinaCursada.setIdDisciplinaCursada(id);
            dao.delete(disciplinaCursada);
            resp.sendRedirect("aluno/listar-disciplina-cursada.jsp");
        }
    }
}
