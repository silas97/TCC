/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fafic.dao.DisciplinaDAO;
import br.edu.fafic.dao.RegimeDomiciliarDAO;
import br.edu.fafic.model.Disciplina;
import br.edu.fafic.model.RegimeDomiciliar;

/**
 *
 * @author Silas
 */
@WebServlet("/regimeDomiciliar")
public class ServletRegimeDomiciliar extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegimeDomiciliarDAO dao = new RegimeDomiciliarDAO();
        RegimeDomiciliar sRegimeDomiciliar;

        DisciplinaDAO daoDisciplina = new DisciplinaDAO();
        Disciplina disciplina = new Disciplina();
        Disciplina buscarDisciplina;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String tipo = req.getParameter("tipo");

        String param = req.getParameter("param");

        if (param.equals("cadastrar")) {
            String dataInicio = req.getParameter("dataInicio");
            String dataFim = req.getParameter("dataFim");

            Date dataInicioConvertida = null;
            Date dataFimConvertida = null;
            try {
                dataInicioConvertida = sdf.parse(dataInicio);
                dataFimConvertida = sdf.parse(dataFim);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            java.sql.Date data1 = new java.sql.Date(dataInicioConvertida.getTime());
            java.sql.Date data2 = new java.sql.Date(dataFimConvertida.getTime());
            Long idDisciplina = Long.parseLong(req.getParameter("idDisciplina_FK"));
            System.out.println(dataInicio);
            sRegimeDomiciliar = new RegimeDomiciliar();
            sRegimeDomiciliar.setDataInicio(data1);
            sRegimeDomiciliar.setDataFim(data2);
            sRegimeDomiciliar.setTipo(tipo);
            disciplina.setIdDisciplina(idDisciplina);
            buscarDisciplina = daoDisciplina.selectID(disciplina);

            if (dao.insert(sRegimeDomiciliar)) {
                req.setAttribute("message", "RegimeDomiciliar salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("/aluno/cadastrar-regime-domiciliar.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            RegimeDomiciliar regimeDomiciliar = new RegimeDomiciliar();
            regimeDomiciliar.setIdRegimeDomiciliar(id);
            sRegimeDomiciliar = dao.selectID(regimeDomiciliar);
            req.getSession().setAttribute("sRegimeDomiciliar", sRegimeDomiciliar);
            req.getRequestDispatcher("aluno/alterar-regime-domiciliar.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sRegimeDomiciliar = new RegimeDomiciliar();
            String dataInicio = req.getParameter("dataInicio");
            String dataFim = req.getParameter("dataFim");

            Date dataInicioConvertida = null;
            Date dataFimConvertida = null;
            try {
                dataInicioConvertida = sdf.parse(dataInicio);
                dataFimConvertida = sdf.parse(dataFim);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            java.sql.Date data1 = new java.sql.Date(dataInicioConvertida.getTime());
            java.sql.Date data2 = new java.sql.Date(dataFimConvertida.getTime());
            Long idDisciplina = Long.parseLong(req.getParameter("idDisciplina_FK"));
            System.out.println(dataInicio);
            sRegimeDomiciliar = new RegimeDomiciliar();
            sRegimeDomiciliar.setIdRegimeDomiciliar(id);
            sRegimeDomiciliar.setDataInicio(data1);
            sRegimeDomiciliar.setDataFim(data2);
            sRegimeDomiciliar.setTipo(tipo);
            disciplina.setIdDisciplina(idDisciplina);
            buscarDisciplina = daoDisciplina.selectID(disciplina);

            dao.update(sRegimeDomiciliar);
            resp.sendRedirect("aluno/listar-regime-domiciliar.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sRegimeDomiciliar = new RegimeDomiciliar();
            sRegimeDomiciliar.setIdRegimeDomiciliar(id);
            dao.delete(sRegimeDomiciliar);
            resp.sendRedirect("aluno/listar-regime-domiciliar.jsp");
        }
    }
}
