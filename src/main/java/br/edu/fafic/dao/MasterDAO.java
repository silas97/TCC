package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Master;
import br.edu.fafic.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MasterDAO
 */
public class MasterDAO {

    private Connection con = null;

    public MasterDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Master master) {
        String sql = "INSERT INTO master(idusuario_fk) VALUES (?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, master.getUsuario().getIdUsuario());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Master master) {
        String sql = "UPDATE master SET idusuario_fk=? WHERE idmaster=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, master.getUsuario().getIdUsuario());
            stmt.setLong(2, master.getIdMaster());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Master master) {
        String sql = "DELETE FROM master WHERE idmaster=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, master.getIdMaster());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Master selectID(Master master) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        Usuario buscaUsuario = null;

        String sql = "SELECT idusuario_fk FROM master WHERE idmaster = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, master.getIdMaster());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getLong("idusuario_fk"));
                buscaUsuario = dao.selectID(usuario);
                master.setUsuario(buscaUsuario);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return master;
    }

    public List<Master> selectAll() {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        Usuario buscaUsuario = null;

        String sql = "SELECT idmaster, idusuario_fk FROM master;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Master> masters = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Master master = new Master();
                master.setIdMaster(rs.getLong("idmaster"));

                usuario.setIdUsuario(rs.getLong("idusuario_fk"));
                buscaUsuario = dao.selectID(usuario);
                master.setUsuario(buscaUsuario);

                masters.add(master);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return masters;
    }
}