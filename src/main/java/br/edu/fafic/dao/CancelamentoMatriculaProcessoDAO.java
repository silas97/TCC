package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.CancelamentoMatriculaProcesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CancelamentoMatriculaProcessoDAO
 */
public class CancelamentoMatriculaProcessoDAO {

    private Connection con = null;

    public CancelamentoMatriculaProcessoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(CancelamentoMatriculaProcesso cancelamentoMatriculaProcesso) {
        String sql = "INSERT INTO Cancelamentomatricula_processo(dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, idcancelamentomatricula_fk) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CancelamentoMatriculaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(CancelamentoMatriculaProcesso cancelamentoMatriculaProcesso) {
        String sql = "UPDATE Cancelamentomatricula_processo SET dataprocesso=?, dataencerramento=?, status=?, visibilidade=?, idprocessos_fk=?, idcancelamentomatricula_fk=? WHERE idcancelamentomatriculaprocesso=?;";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CancelamentoMatriculaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(CancelamentoMatriculaProcesso cancelamentoMatriculaProcesso) {
        String sql = "DELETE FROM cancelamentomatricula_processo WHERE idcancelamentomatriculaprocesso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, cancelamentoMatriculaProcesso.getIdCancelamentoMatriculaProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CancelamentoMatriculaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}