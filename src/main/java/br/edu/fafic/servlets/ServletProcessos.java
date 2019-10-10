/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.AlunoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fafic.dao.ProcessosDAO;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.Processos;

/**
 *
 * @author Silas
 */
@WebServlet("/processos")
public class ServletProcessos extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ProcessosDAO dao = new ProcessosDAO();
        Processos processos = new Processos();
        Processos buscarProcessos;
        
        AlunoDAO alunoDao = new AlunoDAO();
        Aluno aluno = new Aluno();
        Aluno buscaAluno;
        
        String param = req.getParameter("param");
        if (param.equals("cadastrar")) {
            Long idAluno_FK = Long.valueOf(req.getParameter("idAluno_FK"));
            String tipo = req.getParameter("tipo");
            buscarProcessos = new Processos();
            buscarProcessos.setTipo(tipo);
            aluno.setIdAluno(idAluno_FK);
            buscaAluno = alunoDao.selectID(aluno);
            buscarProcessos.setAluno(buscaAluno);

            if (dao.insert(buscarProcessos)) {
                req.setAttribute("message", "Processos salva com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("funcionario/cadastrar-processos.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            processos.setIdProcessos(id);
            buscarProcessos = dao.selectID(processos);
            req.getSession().setAttribute("sProcessos", buscarProcessos);
            req.getRequestDispatcher("funcionario/alterar-processos.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Long idAluno_FK = Long.valueOf(req.getParameter("idAluno_FK"));
            String tipo = req.getParameter("tipo");
            
            buscarProcessos = new Processos();
            buscarProcessos.setIdProcessos(id);
            buscarProcessos.setTipo(tipo);
            aluno.setIdAluno(idAluno_FK);
            buscaAluno = alunoDao.selectID(aluno);
            buscarProcessos.setAluno(buscaAluno);

            dao.update(buscarProcessos);
            resp.sendRedirect("funcionario/listar-processos.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            buscarProcessos = new Processos();
            buscarProcessos.setIdProcessos(id);
            dao.delete(buscarProcessos);
            resp.sendRedirect("funcionario/listar-processos.jsp");
        }
    }
}
