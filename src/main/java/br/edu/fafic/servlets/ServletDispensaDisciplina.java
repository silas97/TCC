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
import br.edu.fafic.dao.DisciplinaCursadaDAO;
import br.edu.fafic.dao.DisciplinaDAO;
import br.edu.fafic.dao.DispensaDisciplinaDAO;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.Disciplina;
import br.edu.fafic.model.DisciplinaCursada;
import br.edu.fafic.model.DispensaDisciplina;
import br.edu.fafic.model.Usuario;

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

        DisciplinaCursadaDAO daoDisciplinaCursada = new DisciplinaCursadaDAO();
        DisciplinaCursada disciplinaCursada = new DisciplinaCursada();
        DisciplinaCursada buscarDisciplinaCursada;

        DisciplinaDAO daoDisciplina = new DisciplinaDAO();
        Disciplina disciplina = new Disciplina();
        Disciplina buscarDisciplina;

        String param = req.getParameter("param");
        

        if (param == null) {
            Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
            Aluno a = daoDisciplinaCursada.getIdAlunoFromUsuario(usuario);
            req.setAttribute("disciplinasCursadasDoAluno", daoDisciplinaCursada.selectDisciplinasCursadasDoAluno(a));
            req.getRequestDispatcher("/aluno/cadastrar-dispensa-disciplina.jsp").forward(req, resp);
        }

        if (param.equals("cadastrar")) {
            Long idAluno = Long.parseLong(req.getParameter("idAluno_FK"));
            Long idDisciplinaCursada = Long.parseLong(req.getParameter("idDisciplinaCursada_FK"));
            Long idDisciplina = Long.parseLong(req.getParameter("idDisciplina_FK"));
            sDispensaDisciplina = new DispensaDisciplina();

            aluno.setIdAluno(idAluno);
            buscarAluno = daoAluno.selectID(aluno);
            sDispensaDisciplina.setAluno(buscarAluno);

            disciplinaCursada.setIdDisciplinaCursada(idDisciplinaCursada);
            buscarDisciplinaCursada = daoDisciplinaCursada.selectID(disciplinaCursada);

            disciplina.setIdDisciplina(idDisciplina);
            buscarDisciplina = daoDisciplina.selectID(disciplina);

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
            Long idDisciplinaCursada = Long.parseLong(req.getParameter("idDisciplinaCursada_FK"));
            Long idDisciplina = Long.parseLong(req.getParameter("idDisciplina_FK"));
            sDispensaDisciplina = new DispensaDisciplina();
            sDispensaDisciplina.setIdDispensaDisciplina(id);

            aluno.setIdAluno(idAluno);
            buscarAluno = daoAluno.selectID(aluno);
            sDispensaDisciplina.setAluno(buscarAluno);

            disciplinaCursada.setIdDisciplinaCursada(idDisciplinaCursada);
            buscarDisciplinaCursada = daoDisciplinaCursada.selectID(disciplinaCursada);

            disciplina.setIdDisciplina(idDisciplina);
            buscarDisciplina = daoDisciplina.selectID(disciplina);
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
