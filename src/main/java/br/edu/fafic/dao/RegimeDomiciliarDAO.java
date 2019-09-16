package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.RegimeDomiciliar;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String sql = "INSERT INTO regimedomiciliar(datainicio, datafim, datacadastro, situacao, tipo, iddiscipina_fk) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(RegimeDomiciliar regimeDomiciliar) {
        String sql = "UPDATE regimedomiciliar SET datainicio=?, datafim=?, datacadastro=?, situacao=?, tipo=?, iddiscipina_fk=? WHERE idregimedomiciliar=?;";
        PreparedStatement stmt = null;
        try {
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
}
