package br.edu.fafic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.CancelamentoMatricula;

/**
 * CancelamentoMatriculaDAO
 */
public class CancelamentoMatriculaDAO {

    private Connection con = null;

    public CancelamentoMatriculaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(CancelamentoMatricula cancelamentoMatricula) {
        String sql = "INSERT INTO cancelamentomatricula(justificativa, datacadastro) VALUES (?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cancelamentoMatricula.getJustificativa());
            stmt.setDate(2, (Date) cancelamentoMatricula.getDataCadastro());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CancelamentoMatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(CancelamentoMatricula cancelamentoMatricula) {
        String sql = "UPDATE cancelamentomatricula SET justificativa=?, datacadastro=? WHERE idcancelamentomatricula=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cancelamentoMatricula.getJustificativa());
            stmt.setDate(2, (Date) cancelamentoMatricula.getDataCadastro());
            stmt.setLong(3, cancelamentoMatricula.getIdCancelamentoMatricula());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CancelamentoMatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(CancelamentoMatricula cancelamentoMatricula) {
        String sql = "DELETE FROM cancelamentomatricula WHERE idcancelamentomatricula=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, cancelamentoMatricula.getIdCancelamentoMatricula());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CancelamentoMatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}