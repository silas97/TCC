package br.edu.fafic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Usuario;

public class UsuarioDAO {

    private Connection con = null;

    public UsuarioDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, cpf, cep, endereco, bairro, cidade, estado, perfil) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getCep());
            stmt.setString(4, usuario.getEndereco());
            stmt.setString(5, usuario.getBairro());
            stmt.setString(6, usuario.getCidade());
            stmt.setString(7, usuario.getEstado());
            stmt.setString(8, usuario.getPerfil());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Usuario usuario) {
        String sql = "UPDATE usuario SET nome=?, cpf=?, cep=?, endereco=?, bairro=?, cidade=?, estado=?, perfil=? WHERE idusuario=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getCep());
            stmt.setString(4, usuario.getEndereco());
            stmt.setString(5, usuario.getBairro());
            stmt.setString(6, usuario.getCidade());
            stmt.setString(7, usuario.getEstado());
            stmt.setString(8, usuario.getPerfil());
            stmt.setLong(9, usuario.getIdUsuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE idusuario=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, usuario.getIdUsuario());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Usuario selectID(Usuario usuario) {
        String sql = "SELECT nome, cpf, cep, endereco, bairro, cidade, estado, perfil FROM usuario WHERE idusuario = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, usuario.getIdUsuario());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuario;
    }

    public List<Usuario> selectAll() {
        String sql = "SELECT idusuario, nome, cpf, cep, endereco, bairro, cidade, estado, perfil FROM usuario;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getLong("idusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setCep(rs.getString("cep"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setPerfil(rs.getString("perfil"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }
}
