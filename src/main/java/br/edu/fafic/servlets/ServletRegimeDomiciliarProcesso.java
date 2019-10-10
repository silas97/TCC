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

import br.edu.fafic.dao.RegimeDomiciliarProcessoDAO;
import br.edu.fafic.dao.RegimeDomiciliarDAO;
import br.edu.fafic.dao.ProcessosDAO;
import br.edu.fafic.model.RegimeDomiciliarProcesso;
import br.edu.fafic.model.RegimeDomiciliar;
import br.edu.fafic.model.Processos;

/**
 *
 * @author Silas
 */
@WebServlet("/regimeDomiciliarProcesso")
public class ServletRegimeDomiciliarProcesso extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegimeDomiciliarProcessoDAO dao = new RegimeDomiciliarProcessoDAO();
        RegimeDomiciliarProcesso sRegimeDomiciliarProcesso;

        ProcessosDAO daoProcessos = new ProcessosDAO();
        Processos processos = new Processos();
        Processos buscarProcessos;

        RegimeDomiciliarDAO daoRegimeDomiciliar = new RegimeDomiciliarDAO();
        RegimeDomiciliar regimeDomiciliar = new RegimeDomiciliar();
        RegimeDomiciliar buscarRegimeDomiciliar;

        String param = req.getParameter("param");

        if (param.equals("cadastrar")) {
            Long idRegimeDomiciliar = Long.parseLong(req.getParameter("idRegimeDomiciliar_FK"));
            Long idProcessos = Long.parseLong(req.getParameter("idProcessos_FK"));
            sRegimeDomiciliarProcesso = new RegimeDomiciliarProcesso();

            processos.setIdProcessos(idProcessos);
            buscarProcessos = daoProcessos.selectID(processos);
            sRegimeDomiciliarProcesso.setProcessos(buscarProcessos);

            regimeDomiciliar.setIdRegimeDomiciliar(idRegimeDomiciliar);
            buscarRegimeDomiciliar = daoRegimeDomiciliar.selectID(regimeDomiciliar);
            sRegimeDomiciliarProcesso.setRegimeDomiciliar(regimeDomiciliar);

            if (dao.insert(sRegimeDomiciliarProcesso)) {
                req.setAttribute("message", "RegimeDomiciliarProcesso salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("/funcionario/cadastrar-regime-domiciliar-processo.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            RegimeDomiciliarProcesso regimeDomiciliarProcesso = new RegimeDomiciliarProcesso();
            regimeDomiciliarProcesso.setIdRegimeDomiciliarProcesso(id);
            sRegimeDomiciliarProcesso = dao.selectID(regimeDomiciliarProcesso);
            req.getSession().setAttribute("sRegimeDomiciliarProcesso", sRegimeDomiciliarProcesso);
            req.getRequestDispatcher("funcionario/alterar-regime-domiciliar-processo.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sRegimeDomiciliarProcesso = new RegimeDomiciliarProcesso();
            Long idRegimeDomiciliar = Long.parseLong(req.getParameter("idRegimeDomiciliar_FK"));
            Long idProcessos = Long.parseLong(req.getParameter("idProcessos_FK"));
            sRegimeDomiciliarProcesso = new RegimeDomiciliarProcesso();
            sRegimeDomiciliarProcesso.setIdRegimeDomiciliarProcesso(id);

            processos.setIdProcessos(idProcessos);
            buscarProcessos = daoProcessos.selectID(processos);
            sRegimeDomiciliarProcesso.setProcessos(buscarProcessos);

            regimeDomiciliar.setIdRegimeDomiciliar(idRegimeDomiciliar);
            buscarRegimeDomiciliar = daoRegimeDomiciliar.selectID(regimeDomiciliar);
            sRegimeDomiciliarProcesso.setRegimeDomiciliar(buscarRegimeDomiciliar);
            dao.update(sRegimeDomiciliarProcesso);
            resp.sendRedirect("funcionario/listar-regime-domiciliar-processo.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sRegimeDomiciliarProcesso = new RegimeDomiciliarProcesso();
            sRegimeDomiciliarProcesso.setIdRegimeDomiciliarProcesso(id);
            dao.delete(sRegimeDomiciliarProcesso);
            resp.sendRedirect("funcionario/listar-regime-domiciliar-processo.jsp");
        }
    }
}
