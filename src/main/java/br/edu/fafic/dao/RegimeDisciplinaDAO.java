package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Disciplina;
import br.edu.fafic.model.RegimeDisciplina;
import br.edu.fafic.model.RegimeDomiciliar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RegimeDisciplinaDAO
 */
public class RegimeDisciplinaDAO {

    private Connection con = null;

    public RegimeDisciplinaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(RegimeDisciplina regimeDisciplina) {
        String sql = "INSERT INTO regimedisciplina(idregimedomiciliar_fk, iddisciplina_fk) VALUES (?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, regimeDisciplina.getRegimeDomiciliar().getIdRegimeDomiciliar());
            stmt.setLong(2, regimeDisciplina.getDisciplina().getIdDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(RegimeDisciplina regimeDisciplina) {
        String sql = "UPDATE regimedisciplina SET idregimedomiciliar_fk=?, iddisciplina_fk=? WHERE idregimedisciplina=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, regimeDisciplina.getRegimeDomiciliar().getIdRegimeDomiciliar());
            stmt.setLong(2, regimeDisciplina.getDisciplina().getIdDisciplina());
            stmt.setLong(3, regimeDisciplina.getIdRegimeDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(RegimeDisciplina regimeDisciplina) {
        String sql = "DELETE FROM regimedisciplina WHERE idregimedisciplina=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, regimeDisciplina.getIdRegimeDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public RegimeDisciplina selectID(RegimeDisciplina regimeDisciplina) {
        String sql = "SELECT idregimedomiciliar_fk, iddisciplina_fk FROM regimedisciplina WHERE idregimedisciplina=?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, regimeDisciplina.getIdRegimeDisciplina());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                RegimeDomiciliarDAO regimeDomiciliarDAO = new RegimeDomiciliarDAO();
                RegimeDomiciliar regimeDomiciliar = new RegimeDomiciliar();
                RegimeDomiciliar buscarRegimeDomiciliar = null;

                regimeDomiciliar.setIdRegimeDomiciliar(rs.getLong("idregimedomiciliar_fk"));
                buscarRegimeDomiciliar = regimeDomiciliarDAO.selectID(regimeDomiciliar);
                regimeDisciplina.setRegimeDomiciliar(buscarRegimeDomiciliar);

                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                Disciplina disciplina = new Disciplina();
                Disciplina buscarDisciplina = null;

                disciplina.setIdDisciplina(rs.getLong("iddisciplina_fk"));
                buscarDisciplina = disciplinaDAO.selectID(disciplina);
                regimeDisciplina.setDisciplina(buscarDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegimeDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return regimeDisciplina;
    }

    public List<RegimeDisciplina> selectAll() {
        String sql = "SELECT idregimedisciplina, idregimedomiciliar_fk, iddisciplina_fk FROM regimedisciplina;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RegimeDisciplina> regimeDisciplinas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                RegimeDisciplina regimeDisciplina = new RegimeDisciplina();

                regimeDisciplina.setIdRegimeDisciplina(rs.getLong("idregimedisciplina"));

                RegimeDomiciliarDAO regimeDomiciliarDAO = new RegimeDomiciliarDAO();
                RegimeDomiciliar regimeDomiciliar = new RegimeDomiciliar();
                RegimeDomiciliar buscarRegimeDomiciliar = null;

                regimeDomiciliar.setIdRegimeDomiciliar(rs.getLong("idregimedomiciliar_fk"));
                buscarRegimeDomiciliar = regimeDomiciliarDAO.selectID(regimeDomiciliar);
                regimeDisciplina.setRegimeDomiciliar(buscarRegimeDomiciliar);

                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                Disciplina disciplina = new Disciplina();
                Disciplina buscarDisciplina = null;

                disciplina.setIdDisciplina(rs.getLong("iddisciplina_fk"));
                buscarDisciplina = disciplinaDAO.selectID(disciplina);
                regimeDisciplina.setDisciplina(buscarDisciplina);

                regimeDisciplinas.add(regimeDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegimeDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return regimeDisciplinas;
    }
}