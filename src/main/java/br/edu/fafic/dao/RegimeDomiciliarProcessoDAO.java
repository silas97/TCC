package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.RegimeDomiciliarProcesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RegimeDomiciliarProcessoDAO
 */
public class RegimeDomiciliarProcessoDAO {

    private Connection con = null;

    public RegimeDomiciliarProcessoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(RegimeDomiciliarProcesso regimedomiciliarprocesso) {
        String sql = "INSERT INTO regimedomiciliar_processo(dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, idregimedomiciliar_fk) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(RegimeDomiciliarProcesso regimedomiciliarprocesso) {
        String sql = "UPDATE regimedomiciliar_processo SET dataprocesso=?, dataencerramento=?, status=?, visibilidade=?, idprocessos_fk=?, idregimedomiciliar_fk=? WHERE idregimedomiciliarprocesso=?;";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(RegimeDomiciliarProcesso regimeDomiciliarProcesso) {
        String sql = "DELETE FROM regimedomiciliar_processo WHERE idregimedomiciliarprocesso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, regimeDomiciliarProcesso.getIdRegimeDomiciliarProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}