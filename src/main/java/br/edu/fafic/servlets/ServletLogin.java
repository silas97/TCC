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

@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDAO dao = new LoginDAO();
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String param = req.getParameter("param");
        Login login = new Login();
        System.out.println("Parametro: " + param);

        if (param.equals("insert")) {

            Usuario user = new Usuario();

            String usuario = req.getParameter("idUsuario_FK");

            Long num = Long.valueOf(usuario);
            user.setIdUsuario(num);

            login.setEmail(email);
            login.setSenha(senha);
            login.setUsuario(user);

            dao.insert(login);

        } else if (param.equals("update")) {

        } else if (param.equals("delete")) {

        } else if (param.equals("autenticacao")) {
            login.setEmail(email);
            login.setSenha(senha);
            Login l = dao.autentication(login);
            if (l != null) {
                req.getSession().setAttribute("usuario", l.getUsuario());

                String path = l.getUsuario().getPerfil().toLowerCase() + "/index.jsp";

                try {
                    resp.sendRedirect(path);
                } catch (IOException ex) {
                    Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else if (param.equals("logout")) {
            req.getSession().removeAttribute("usuario");
            req.getSession().invalidate();
            req.getRequestDispatcher("/index.jsp").forward(req, resp);

        }
    }
}
