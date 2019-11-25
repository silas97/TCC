package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.RegimeDomiciliar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RegimeDomiciliarDAO
 */
public class RegimeDomiciliarDAO {

    private Connection con = null;

    public RegimeDomiciliarDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(RegimeDomiciliar regimeDomiciliar) {
        String sql = "INSERT INTO regimedomiciliar(datainicio, datafim, datacadastro, situacao, tipo) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) regimeDomiciliar.getDataInicio());
            stmt.setDate(2, (Date) regimeDomiciliar.getDataFim());
            stmt.setDate(3, (Date) regimeDomiciliar.getDataCadastro());
            stmt.setString(4, regimeDomiciliar.getSituacao());
            stmt.setString(5, regimeDomiciliar.getTipo());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(RegimeDomiciliar regimeDomiciliar) {
        String sql = "UPDATE regimedomiciliar SET datainicio=?, datafim=?, datacadastro=?, situacao=?, tipo=? WHERE idregimedomiciliar=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) regimeDomiciliar.getDataInicio());
            stmt.setDate(2, (Date) regimeDomiciliar.getDataFim());
            stmt.setDate(3, (Date) regimeDomiciliar.getDataCadastro());
            stmt.setString(4, regimeDomiciliar.getSituacao());
            stmt.setString(5, regimeDomiciliar.getTipo());
            stmt.setLong(6, regimeDomiciliar.getIdRegimeDomiciliar());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(RegimeDomiciliar regimeDomiciliar) {
        String sql = "DELETE FROM regimedomiciliar WHERE idregimedomiciliar=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, regimeDomiciliar.getIdRegimeDomiciliar());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public RegimeDomiciliar selectID(RegimeDomiciliar regimeDomiciliar) {

        String sql = "SELECT datainicio, datafim, datacadastro, situacao, tipo FROM regimedomiciliar WHERE idregimedomiciliar = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, regimeDomiciliar.getIdRegimeDomiciliar());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                regimeDomiciliar.setDataInicio(rs.getDate("datainicio"));
                regimeDomiciliar.setDataFim(rs.getDate("datafim"));
                regimeDomiciliar.setDataCadastro(rs.getDate("datacadastro"));
                regimeDomiciliar.setSituacao(rs.getString("situacao"));
                regimeDomiciliar.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegimeDomiciliarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return regimeDomiciliar;
    }

    public List<RegimeDomiciliar> selectAll() {

        String sql = "SELECT idregimedomiciliar, datainicio, datafim, datacadastro, situacao, tipo FROM regimedomiciliar;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RegimeDomiciliar> regimeDomiciliars = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                RegimeDomiciliar regimeDomiciliar = new RegimeDomiciliar();
                regimeDomiciliar.setIdRegimeDomiciliar(rs.getLong("idregimeDomiciliar"));
                regimeDomiciliar.setDataInicio(rs.getDate("datainicio"));
                regimeDomiciliar.setDataFim(rs.getDate("datafim"));
                regimeDomiciliar.setDataCadastro(rs.getDate("datacadastro"));
                regimeDomiciliar.setSituacao(rs.getString("situacao"));
                regimeDomiciliar.setTipo(rs.getString("tipo"));

                regimeDomiciliars.add(regimeDomiciliar);

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegimeDomiciliarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return regimeDomiciliars;
    }
}
