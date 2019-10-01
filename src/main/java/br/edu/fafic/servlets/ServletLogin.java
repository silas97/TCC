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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silas
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        LoginDAO dao = new LoginDAO();
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String param = req.getParameter("param");
        Login login = new Login();
        System.out.println("Parametro: " +param);

        if (param.equals("insert")) {


            Usuario user = new Usuario();

            Long num = Long.valueOf(1);
            user.setIdUsuario(num);

            login.setEmail(email);
            login.setSenha(senha);
            login.setUsuario(user);

           
            dao.insert(login);

        } else if (param.equals("update")) {

        } else if (param.equals("delete")) {

        }else if(param.equals("autenticacao")){
            login.setEmail(email);
            login.setSenha(senha);
            Login l = dao.autentication(login);
            if(l!=null){
                req.getSession().setAttribute("usuario", l.getUsuario());
                
                String path = l.getUsuario().getPerfil().toLowerCase()+"/index.jsp";
                
                try {
                    resp.sendRedirect(path);
                } catch (IOException ex) {
                    Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
}
