package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.DispensaDisciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DispensaDisciplinaDAO
 */
public class DispensaDisciplinaDAO {

    private Connection con = null;

    public DispensaDisciplinaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DispensaDisciplina dispensaDisciplina) {
        String sql = "INSERT INTO dispensadisciplina(idaluno_fk, iddisciplinacursada_fk, iddisciplina_fk) VALUES (?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(DispensaDisciplina dispensaDisciplina) {
        String sql = "UPDATE dispensadisciplina SET idaluno_fk=?, iddisciplinacursada_fk=?, iddisciplina_fk=? WHERE iddispensadisciplina=?;";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(DispensaDisciplina dispensaDisciplina) {
        String sql = "DELETE FROM dispensadisciplina WHERE iddispensadisciplina=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaDisciplina.getIdDispensaDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}