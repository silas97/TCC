/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.connection.JavaMail;
import br.edu.fafic.model.Login;
import br.edu.fafic.model.Usuario;

/**
 *
 * @author Silas
 */
public class LoginDAO {

    private Connection con = null;

    public LoginDAO() {
        con = ConnectionFactory.getConnection();
    }

    public Login autentication(Login user) {
        Login login = null;
        String sql = "SELECT * FROM login WHERE email = ? and senha = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String senha = user.getSenha();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (byte var : messageDigest) {
                sb.append(String.format("%02X", 0xFF & var));
            }

            String senhaHex = sb.toString();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, senhaHex);
            rs = stmt.executeQuery();
            while (rs.next()) {
                login = new Login();
                login.setIdLogin(rs.getLong("idLogin"));
                login.setEmail(rs.getString("email"));
                login.setSenha(rs.getString("senha"));
                login.setUsuario(getUsuarioById(rs.getLong("idusuario_fk")));
            }

        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return login;
    }

    public boolean insert(Login login) {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO login(email, senha, idusuario_fk) VALUES (?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            String senha = login.getSenha();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = md.digest(senha.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (byte var : messageDigest) {
                sb.append(String.format("%02X", 0xFF & var));
            }

            String senhaHex = sb.toString();
            System.out.println(senhaHex);
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login.getEmail());
            stmt.setString(2, senhaHex);
            stmt.setLong(3, login.getUsuario().getIdUsuario());
            stmt.executeUpdate();
            JavaMail javaMail = new JavaMail();
            javaMail.enviarMSG(login.getEmail(), "Seja Bem Vindo!", "Sua conta no sistema foi criada com sucesso!"
                    + "\nLogin: " + login.getEmail() + "\nSenha: " + login.getSenha());
            return true;
        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Login login) {
        String sql = "UPDATE login SET email=?, senha=?, idusuario_fk=? WHERE idlogin=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login.getEmail());
            stmt.setString(2, login.getSenha());
            stmt.setLong(3, login.getUsuario().getIdUsuario());
            stmt.setLong(4, login.getIdLogin());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Login login) {
        String sql = "DELETE FROM login WHERE idlogin=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, login.getIdLogin());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Usuario getUsuarioById(Long id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE idusuario = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getLong("idusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setCep(rs.getString("cep"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setPerfil(rs.getString("perfil"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return usuario;
    }

    public Login selectID(Login login) {
        String sql = "SELECT email, senha, idusuario_fk FROM login WHERE idlogin = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, login.getIdLogin());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                UsuarioDAO dao = new UsuarioDAO();
                Usuario usuario = new Usuario();
                Usuario buscarUsuario = null;
                login.setEmail(rs.getString("email"));
                login.setSenha(rs.getString("senha"));
                
                usuario.setIdUsuario(rs.getLong("idusuario_fk"));
                buscarUsuario = dao.selectID(usuario);
                login.setUsuario(buscarUsuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return login;
    }

    public List<Login> selectAll() {
        String sql = "SELECT idlogin, email, senha, idusuario_fk FROM login;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Login> logins = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Login login = new Login();
                UsuarioDAO dao = new UsuarioDAO();
                Usuario usuario = new Usuario();
                Usuario buscarUsuario = null;
                login.setIdLogin(rs.getLong("idLogin"));
                login.setEmail(rs.getString("email"));
                login.setSenha(rs.getString("senha"));
                
                usuario.setIdUsuario(rs.getLong("idusuario_fk"));
                buscarUsuario = dao.selectID(usuario);

                login.setUsuario(buscarUsuario);

                logins.add(login);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return logins;

    }
}
