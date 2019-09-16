package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Processos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ProcessosDAO
 */
public class ProcessosDAO {

    private Connection con = null;

    public ProcessosDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Processos processos) {
        String sql = "INSERT INTO processos(idaluno_fk) VALUES (?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getAluno().getIdAluno());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Processos processos) {
        String sql = "UPDATE processos SET idaluno_fk=? WHERE idprocessos=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getAluno().getIdAluno());
            stmt.setLong(1, processos.getIdProcessos());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Processos processos) {
        String sql = "DELETE FROM processos WHERE idprocessos=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getIdProcessos());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}