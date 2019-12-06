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
import br.edu.fafic.dao.LoginDAO;
;
import br.edu.fafic.dao.UsuarioDAO;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.Login;
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
        
        LoginDAO loginDao = new LoginDAO();

        

        String param = req.getParameter("param");

        if (param.equals("cadastrar")) {

            //parametros do usuario
            String nome = req.getParameter("nome");
            String cpf = req.getParameter("cpf");
            String cep = req.getParameter("cep");
            String endereco = req.getParameter("rua");
            String numero = req.getParameter("numero");
            String complemento = req.getParameter("complemento");
            String bairro = req.getParameter("bairro");
            String cidade = req.getParameter("cidade");
            String estado = req.getParameter("estado");
//            String email = req.getParameter("email");
            String perfil = "Aluno";
            
            //parametros do aluno
            String matricula = req.getParameter("matricula");
            

            Long idCurso = Long.parseLong(req.getParameter("idCurso_FK"));
            StringBuilder builderEndereco = new StringBuilder();
            builderEndereco.append(endereco)
                           .append(", Nº ")
                           .append(numero)
                           .append(" Complemento - ")
                           .append(complemento);
            
            
            usuario = new Usuario(nome, cpf, cep, builderEndereco.toString() , bairro, cidade, estado, perfil);
            
            Long idUsuario = daoUsuario.insert(usuario);
            Usuario u = daoUsuario.selectID(idUsuario);
            sAluno = new Aluno();
            sAluno.setMatricula(matricula);
            curso.setIdCurso(idCurso);
            buscarCurso = daoCurso.selectID(curso);
            sAluno.setCurso(buscarCurso);
            sAluno.setUsuario(u);
            Login login = new Login(sAluno.getUsuario().getNome().toLowerCase(), "123", u);
            System.out.println("Login: " +login.toString());
            loginDao.insert(login);
            

            if (dao.insert(sAluno)) {
                req.setAttribute("message", "Aluno salvo com sucesso!");
                req.setAttribute("classe", "alert alert-success alert-dismissible fade show");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
                req.setAttribute("classe", "alert alert-warning alert-dismissible fade show");
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
            String matricula = req.getParameter("matricula");
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
        } else if (param.equals("matricula")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sAluno = new Aluno();
            sAluno.setIdAluno(id);
            dao.delete(sAluno);
            resp.sendRedirect("funcionario/listar-aluno.jsp");
        }
    }
}
