/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.AlunoDAO;
import br.edu.fafic.dao.DispensaDisciplinaProcessoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fafic.dao.ProcessosDAO;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.DispensaDisciplinaProcesso;
import br.edu.fafic.model.Processos;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        DispensaDisciplinaProcessoDAO ddpDAO = new DispensaDisciplinaProcessoDAO();

        AlunoDAO alunoDao = new AlunoDAO();
        Aluno aluno = new Aluno();
        Aluno buscaAluno;
        String matricula = req.getParameter("matricula_aluno");
        String param = req.getParameter("param");

        if (param.equals("consultar_aluno")) {
            Aluno a = alunoDao.getAlunoByMatricula(matricula);
            if (a != null) {
                req.setAttribute("aluno", a);
                req.setAttribute("matricula", matricula);
                req.getSession().setAttribute("idAluno_FK", a.getIdAluno());

            }
            req.getRequestDispatcher("funcionario/cadastrar-processos.jsp").forward(req, resp);
        }

        if (param.equals("cadastrar")) {
            Long idAluno_FK = ((Long) req.getSession().getAttribute("idAluno_FK"));
            String tipo = req.getParameter("tipo");
            buscarProcessos = new Processos();
            buscarProcessos.setTipo(tipo);
            aluno.setIdAluno(idAluno_FK);
            buscaAluno = alunoDao.selectID(aluno);
            buscarProcessos.setAluno(buscaAluno);

            if (dao.insert(buscarProcessos)) {
                req.setAttribute("message", "Processo salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("funcionario/cadastrar-processos.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {

            Long id = Long.valueOf(req.getParameter("id"));
            String nomeAluno = req.getParameter("nome_aluno");
            DispensaDisciplinaProcesso ddp = ddpDAO.selectByIdProcesso(id);
            req.setAttribute("processo", ddp);
            req.setAttribute("aluno", nomeAluno);
            req.setAttribute("param", param);
            req.getRequestDispatcher("funcionario/alterar-processos.jsp").forward(req, resp);

        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            String status = req.getParameter("status");
            System.out.println("Id do processo: " +id);
            System.out.println("Status: " +status);
            ddpDAO.updateStatus(status, id);
            req.setAttribute("param", param);
            req.setAttribute("message", "Operação realizada com sucesso!");
            req.setAttribute("classe", "alert alert-success alert-dismissible fade show");
            req.getRequestDispatcher("funcionario/alterar-processos.jsp").forward(req, resp);
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            buscarProcessos = new Processos();
            buscarProcessos.setIdProcessos(id);
            dao.delete(buscarProcessos);
            resp.sendRedirect("funcionario/listar-processos.jsp");
        }
    }
}
