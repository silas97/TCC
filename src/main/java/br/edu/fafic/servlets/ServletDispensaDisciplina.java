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

import br.edu.fafic.dao.AlunoDAO;

import br.edu.fafic.dao.DispensaDisciplinaDAO;
import br.edu.fafic.model.Aluno;

import br.edu.fafic.model.DispensaDisciplina;

/**
 *
 * @author Silas
 */
@WebServlet("/dispensaDisciplina")
public class ServletDispensaDisciplina extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DispensaDisciplinaDAO dao = new DispensaDisciplinaDAO();
        DispensaDisciplina sDispensaDisciplina;

        AlunoDAO daoAluno = new AlunoDAO();
        Aluno aluno = new Aluno();
        Aluno buscarAluno;

        String param = req.getParameter("param");

        if (param.equals("cadastrar")) {
            Long idAluno = Long.parseLong(req.getParameter("idAluno_FK"));
            sDispensaDisciplina = new DispensaDisciplina();

            aluno.setIdAluno(idAluno);
            buscarAluno = daoAluno.selectID(aluno);
            sDispensaDisciplina.setAluno(buscarAluno);


            if (dao.insert(sDispensaDisciplina)) {
                req.setAttribute("message", "DispensaDisciplina salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("/aluno/cadastrar-dispensa-disciplina.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
            dispensaDisciplina.setIdDispensaDisciplina(id);
            sDispensaDisciplina = dao.selectID(dispensaDisciplina);
            req.getSession().setAttribute("sDispensaDisciplina", sDispensaDisciplina);
            req.getRequestDispatcher("aluno/alterar-dispensa-disciplina.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sDispensaDisciplina = new DispensaDisciplina();
            Long idAluno = Long.parseLong(req.getParameter("idAluno_FK"));

            sDispensaDisciplina = new DispensaDisciplina();
            sDispensaDisciplina.setIdDispensaDisciplina(id);

            aluno.setIdAluno(idAluno);
            buscarAluno = daoAluno.selectID(aluno);
            sDispensaDisciplina.setAluno(buscarAluno);

            dao.update(sDispensaDisciplina);
            resp.sendRedirect("aluno/listar-dispensa-disciplina.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sDispensaDisciplina = new DispensaDisciplina();
            sDispensaDisciplina.setIdDispensaDisciplina(id);
            dao.delete(sDispensaDisciplina);
            resp.sendRedirect("aluno/listar-dispensa-disciplina.jsp");
        }
    }
}
