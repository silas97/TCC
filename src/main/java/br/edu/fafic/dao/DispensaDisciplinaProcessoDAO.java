package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.DispensaDisciplinaProcesso;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DispensaDisciplinaProcessoDAO
 */
public class DispensaDisciplinaProcessoDAO {
    private Connection con = null;

    public DispensaDisciplinaProcessoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DispensaDisciplinaProcesso dispensaDisciplinaProcesso) {
        String sql = "INSERT INTO dispensadisciplina_processo(dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, iddispensadiscipina_fk) VALUES (?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) dispensaDisciplinaProcesso.getDataProcesso());
            stmt.setDate(2, (Date) dispensaDisciplinaProcesso.getDataEncerramento());
            stmt.setString(3, dispensaDisciplinaProcesso.getStatus());
            stmt.setString(4, dispensaDisciplinaProcesso.getVisibilidade());
            stmt.setLong(5, dispensaDisciplinaProcesso.getProcessos().getIdProcessos());
            stmt.setLong(6, dispensaDisciplinaProcesso.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(DispensaDisciplinaProcesso dispensaDisciplinaProcesso) {
        String sql = "UPDATE dispensadisciplina_processo SET dataprocesso=?, dataencerramento=?, status=?, visibilidade=?, idprocessos_fk=?, iddispensadiscipina_fk=? WHERE iddispensadisciplinaprocesso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) dispensaDisciplinaProcesso.getDataProcesso());
            stmt.setDate(2, (Date) dispensaDisciplinaProcesso.getDataEncerramento());
            stmt.setString(3, dispensaDisciplinaProcesso.getStatus());
            stmt.setString(4, dispensaDisciplinaProcesso.getVisibilidade());
            stmt.setLong(5, dispensaDisciplinaProcesso.getProcessos().getIdProcessos());
            stmt.setLong(6, dispensaDisciplinaProcesso.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.setLong(6, dispensaDisciplinaProcesso.getIdDispensaDisciplinaProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(DispensaDisciplinaProcesso dispensaDisciplinaProcesso) {
        String sql = "DELETE FROM dispensadisciplina_processo WHERE iddispensadisciplinaprocesso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaDisciplinaProcesso.getIdDispensaDisciplinaProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}