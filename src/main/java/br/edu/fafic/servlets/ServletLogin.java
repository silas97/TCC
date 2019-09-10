/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fafic.dao.LoginDAO;
import br.edu.fafic.model.Login;
import br.edu.fafic.model.Usuario;

/**
 *
 * @author Silas
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        System.out.println(senha);

        String param = req.getParameter("param");
        if (param.equals("insert")) {

            Login login = new Login();

            Usuario user = new Usuario();

            Long num = Long.valueOf(1);
            user.setIdUsuario(num);

            login.setEmail(email);
            login.setSenha(senha);
            login.setUsuario(user);

            LoginDAO dao = new LoginDAO();
            dao.insert(login);

        } else if (param.equals("update")) {

        } else if (param.equals("delete")) {

        }
    }
}
