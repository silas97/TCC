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

import br.edu.fafic.dao.DispensaDisciplinaProcessoDAO;
import br.edu.fafic.dao.DispensaDisciplinaDAO;
import br.edu.fafic.dao.ProcessosDAO;
import br.edu.fafic.model.DispensaDisciplinaProcesso;
import br.edu.fafic.model.DispensaDisciplina;
import br.edu.fafic.model.Processos;

/**
 *
 * @author Silas
 */
@WebServlet("/dispensaDisciplinaProcesso")
public class ServletDispensaDisciplinaProcesso extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DispensaDisciplinaProcessoDAO dao = new DispensaDisciplinaProcessoDAO();
        DispensaDisciplinaProcesso sDispensaDisciplinaProcesso;

        ProcessosDAO daoProcessos = new ProcessosDAO();
        Processos processos = new Processos();
        Processos buscarProcessos;

        DispensaDisciplinaDAO daoDispensaDisciplina = new DispensaDisciplinaDAO();
        DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
        DispensaDisciplina buscarDispensaDisciplina;

        String param = req.getParameter("param");

        if (param.equals("cadastrar")) {
            Long idDispensaDisciplina = Long.parseLong(req.getParameter("idDispensaDisciplina_FK"));
            Long idProcessos = Long.parseLong(req.getParameter("idProcessos_FK"));
            sDispensaDisciplinaProcesso = new DispensaDisciplinaProcesso();

            processos.setIdProcessos(idProcessos);
            buscarProcessos = daoProcessos.selectID(processos);
            sDispensaDisciplinaProcesso.setProcessos(buscarProcessos);

            dispensaDisciplina.setIdDispensaDisciplina(idDispensaDisciplina);
            buscarDispensaDisciplina = daoDispensaDisciplina.selectID(dispensaDisciplina);
            sDispensaDisciplinaProcesso.setDispensaDisciplina(buscarDispensaDisciplina);

            if (dao.insert(sDispensaDisciplinaProcesso)) {
                req.setAttribute("message", "DispensaDisciplinaProcesso salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("/funcionario/cadastrar-dispensa-disciplina-processo.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            DispensaDisciplinaProcesso dispensaDisciplinaProcesso = new DispensaDisciplinaProcesso();
            dispensaDisciplinaProcesso.setIdDispensaDisciplinaProcesso(id);
            sDispensaDisciplinaProcesso = dao.selectID(dispensaDisciplinaProcesso);
            req.getSession().setAttribute("sDispensaDisciplinaProcesso", sDispensaDisciplinaProcesso);
            req.getRequestDispatcher("funcionario/alterar-dispensa-disciplina-processo.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sDispensaDisciplinaProcesso = new DispensaDisciplinaProcesso();
            Long idDispensaDisciplina = Long.parseLong(req.getParameter("idDispensaDisciplina_FK"));
            Long idProcessos = Long.parseLong(req.getParameter("idProcessos_FK"));
            sDispensaDisciplinaProcesso = new DispensaDisciplinaProcesso();
            sDispensaDisciplinaProcesso.setIdDispensaDisciplinaProcesso(id);

            processos.setIdProcessos(idProcessos);
            buscarProcessos = daoProcessos.selectID(processos);
            sDispensaDisciplinaProcesso.setProcessos(buscarProcessos);

            dispensaDisciplina.setIdDispensaDisciplina(idDispensaDisciplina);
            buscarDispensaDisciplina = daoDispensaDisciplina.selectID(dispensaDisciplina);
            sDispensaDisciplinaProcesso.setDispensaDisciplina(buscarDispensaDisciplina);
            dao.update(sDispensaDisciplinaProcesso);
            resp.sendRedirect("funcionario/listar-dispensa-disciplina-processo.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sDispensaDisciplinaProcesso = new DispensaDisciplinaProcesso();
            sDispensaDisciplinaProcesso.setIdDispensaDisciplinaProcesso(id);
            dao.delete(sDispensaDisciplinaProcesso);
            resp.sendRedirect("funcionario/listar-dispensa-disciplina-processo.jsp");
        }
    }
}
