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

import br.edu.fafic.dao.CancelamentoMatriculaProcessoDAO;
import br.edu.fafic.dao.CancelamentoMatriculaDAO;
import br.edu.fafic.dao.ProcessosDAO;
import br.edu.fafic.model.CancelamentoMatriculaProcesso;
import br.edu.fafic.model.CancelamentoMatricula;
import br.edu.fafic.model.Processos;

/**
 *
 * @author Silas
 */
@WebServlet("/cancelamentoMatriculaProcesso")
public class ServletCancelamentoMatriculaProcesso extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CancelamentoMatriculaProcessoDAO dao = new CancelamentoMatriculaProcessoDAO();
        CancelamentoMatriculaProcesso sCancelamentoMatriculaProcesso;

        ProcessosDAO daoProcessos = new ProcessosDAO();
        Processos processos = new Processos();
        Processos buscarProcessos;

        CancelamentoMatriculaDAO daoCancelamentoMatricula = new CancelamentoMatriculaDAO();
        CancelamentoMatricula cancelamentoMatricula = new CancelamentoMatricula();
        CancelamentoMatricula buscarCancelamentoMatricula;

        String param = req.getParameter("param");

        if (param.equals("cadastrar")) {
            Long idCancelamentoMatricula = Long.parseLong(req.getParameter("idCancelamentoMatricula_FK"));
            Long idProcessos = Long.parseLong(req.getParameter("idProcessos_FK"));
            sCancelamentoMatriculaProcesso = new CancelamentoMatriculaProcesso();

            processos.setIdProcessos(idProcessos);
            buscarProcessos = daoProcessos.selectID(processos);
            sCancelamentoMatriculaProcesso.setProcessos(buscarProcessos);

            cancelamentoMatricula.setIdCancelamentoMatricula(idCancelamentoMatricula);
            buscarCancelamentoMatricula = daoCancelamentoMatricula.selectID(cancelamentoMatricula);
            sCancelamentoMatriculaProcesso.setCancelamentoMatricula(buscarCancelamentoMatricula);

            if (dao.insert(sCancelamentoMatriculaProcesso)) {
                req.setAttribute("message", "CancelamentoMatriculaProcesso salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("/funcionario/cadastrar-cancelamento-matricula-processo.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            CancelamentoMatriculaProcesso cancelamentoMatriculaProcesso = new CancelamentoMatriculaProcesso();
            cancelamentoMatriculaProcesso.setIdCancelamentoMatriculaProcesso(id);
            sCancelamentoMatriculaProcesso = dao.selectID(cancelamentoMatriculaProcesso);
            req.getSession().setAttribute("sCancelamentoMatriculaProcesso", sCancelamentoMatriculaProcesso);
            req.getRequestDispatcher("funcionario/alterar-cancelamento-matricula-processo.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sCancelamentoMatriculaProcesso = new CancelamentoMatriculaProcesso();
            Long idCancelamentoMatricula = Long.parseLong(req.getParameter("idCancelamentoMatricula_FK"));
            Long idProcessos = Long.parseLong(req.getParameter("idProcessos_FK"));
            sCancelamentoMatriculaProcesso = new CancelamentoMatriculaProcesso();
            sCancelamentoMatriculaProcesso.setIdCancelamentoMatriculaProcesso(id);

            processos.setIdProcessos(idProcessos);
            buscarProcessos = daoProcessos.selectID(processos);
            sCancelamentoMatriculaProcesso.setProcessos(buscarProcessos);

            cancelamentoMatricula.setIdCancelamentoMatricula(idCancelamentoMatricula);
            buscarCancelamentoMatricula = daoCancelamentoMatricula.selectID(cancelamentoMatricula);
            sCancelamentoMatriculaProcesso.setCancelamentoMatricula(buscarCancelamentoMatricula);
            dao.update(sCancelamentoMatriculaProcesso);
            resp.sendRedirect("funcionario/listar-cancelamento-matricula-processo.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sCancelamentoMatriculaProcesso = new CancelamentoMatriculaProcesso();
            sCancelamentoMatriculaProcesso.setIdCancelamentoMatriculaProcesso(id);
            dao.delete(sCancelamentoMatriculaProcesso);
            resp.sendRedirect("funcionario/listar-cancelamento-matricula-processo.jsp");
        }
    }
}
