package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TurmaDAO
 */
public class TurmaDAO {

    private Connection con = null;

    public TurmaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Turma turma) {
        String sql = "INSERT INTO turma(periodo, sigla, idcurso_fk) VALUES (?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Turma turma) {
        String sql = "UPDATE turma SET periodo=?, sigla=?, idcurso_fk=? WHERE idturma=?;";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Turma turma) {
        String sql = "DELETE FROM turma WHERE idturma=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, turma.getIdTurma());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}