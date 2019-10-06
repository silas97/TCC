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
import br.edu.fafic.dao.CursoDAO;
import br.edu.fafic.dao.UsuarioDAO;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.Usuario;

/**
 *
 * @author Silas
 */
@WebServlet("/aluno")
public class ServletAluno extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AlunoDAO dao = new AlunoDAO();
        Aluno sAluno;

        UsuarioDAO daoUsuario = new UsuarioDAO();
        Usuario usuario = new Usuario();
        Usuario buscarUsuario;

        CursoDAO daoCurso = new CursoDAO();
        Curso curso = new Curso();
        Curso buscarCurso;

        String matricula = req.getParameter("matricula");

        String param = req.getParameter("param");

        if (param.equals("cadastrar")) {
            Long idCurso = Long.parseLong(req.getParameter("idCurso_FK"));
            Long idUsuario = Long.parseLong(req.getParameter("idUsuario_FK"));
            sAluno = new Aluno();
            sAluno.setMatricula(matricula);

            usuario.setIdUsuario(idUsuario);
            buscarUsuario = daoUsuario.selectID(usuario);
            sAluno.setUsuario(buscarUsuario);

            curso.setIdCurso(idCurso);
            buscarCurso = daoCurso.selectID(curso);
            sAluno.setCurso(buscarCurso);

            if (dao.insert(sAluno)) {
                req.setAttribute("message", "Aluno salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("/funcionario/cadastrar-aluno.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Aluno aluno = new Aluno();
            aluno.setIdAluno(id);
            sAluno = dao.selectID(aluno);
            req.getSession().setAttribute("sAluno", sAluno);
            req.getRequestDispatcher("funcionario/alterar-aluno.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sAluno = new Aluno();
            Long idCurso = Long.parseLong(req.getParameter("idCurso_FK"));
            Long idUsuario = Long.parseLong(req.getParameter("idUsuario_FK"));
            sAluno = new Aluno();
            sAluno.setIdAluno(id);
            sAluno.setMatricula(matricula);

            usuario.setIdUsuario(idUsuario);
            buscarUsuario = daoUsuario.selectID(usuario);
            sAluno.setUsuario(buscarUsuario);

            curso.setIdCurso(idCurso);
            buscarCurso = daoCurso.selectID(curso);
            sAluno.setCurso(buscarCurso);
            dao.update(sAluno);
            resp.sendRedirect("funcionario/listar-aluno.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sAluno = new Aluno();
            sAluno.setIdAluno(id);
            dao.delete(sAluno);
            resp.sendRedirect("funcionario/listar-aluno.jsp");
        }
    }
}
