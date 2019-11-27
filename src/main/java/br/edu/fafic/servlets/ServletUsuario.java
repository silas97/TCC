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

import br.edu.fafic.dao.UsuarioDAO;
import br.edu.fafic.model.Usuario;

/**
 *
 * @author Silas
 */
@WebServlet("/usuario")
public class ServletUsuario extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String cep = req.getParameter("cep");
        String endereco = req.getParameter("endereco");
        String bairro = req.getParameter("bairro");
        String cidade = req.getParameter("cidade");
        String estado = req.getParameter("estado");
        String perfil = req.getParameter("perfil");
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuario user;
        String param = req.getParameter("param");
        if (param.equals("cadastrar")) {
            user = new Usuario();
            user.setNome(nome);
            user.setCpf(cpf);
            user.setCep(cep);
            user.setEndereco(endereco);
            user.setBairro(bairro);
            user.setCidade(cidade);
            user.setEstado(estado);
            user.setPerfil(perfil);

            if (dao.insert(user)) {
                req.setAttribute("message", "Usuário salvo com sucesso!");
            } else {
                req.setAttribute("message", "Erro ao salvar!");
            }
            req.getRequestDispatcher("funcionario/cadastrar-aluno.jsp").forward(req, resp);

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(id);
            user = dao.selectID(usuario);
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("funcionario/alterar-usuario.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            user = new Usuario();
            user.setNome(nome);
            user.setCpf(cpf);
            user.setCep(cep);
            user.setEndereco(endereco);
            user.setBairro(bairro);
            user.setCidade(cidade);
            user.setEstado(estado);
            user.setPerfil(perfil);
            user.setIdUsuario(id);
            dao.update(user);
            resp.sendRedirect("funcionario/listar-usuario.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            user = new Usuario();
            user.setIdUsuario(id);
            dao.delete(user);
            resp.sendRedirect("funcionario/listar-usuario.jsp");
        }
    }
}
