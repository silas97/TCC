package br.edu.fafic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public CancelamentoMatricula selectID(CancelamentoMatricula cancelamentoMatricula) {
        String sql = "SELECT justificativa, datacadastro FROM cancelamentomatricula WHERE idcancelamentomatricula = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, cancelamentoMatricula.getIdCancelamentoMatricula());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                cancelamentoMatricula.setJustificativa(rs.getString("justificativa"));
                cancelamentoMatricula.setDataCadastro(rs.getDate("datacadastro"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoMatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cancelamentoMatricula;
    }

    public List<CancelamentoMatricula> selectAll() {
        String sql = "SELECT idcancelamentomatricula, justificativa, datacadastro FROM cancelamentomatricula;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CancelamentoMatricula> cancelamentoMatriculas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CancelamentoMatricula cancelamentoMatricula = new CancelamentoMatricula();
                cancelamentoMatricula.setIdCancelamentoMatricula(rs.getLong("idcancelamentoMatricula"));
                cancelamentoMatricula.setJustificativa(rs.getString("justificativa"));
                cancelamentoMatricula.setDataCadastro(rs.getDate("datacadastro"));
                cancelamentoMatriculas.add(cancelamentoMatricula);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoMatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cancelamentoMatriculas;
    }
}