package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.DisciplinaAtual;
import br.edu.fafic.model.DisciplinaCursada;
import br.edu.fafic.model.DispensaVinculo;
import br.edu.fafic.model.DispensaDisciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DispensaVinculoDAO
 */
public class DispensaVinculoDAO {

    private Connection con = null;

    public DispensaVinculoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DispensaVinculo dispensaVinculo) {
        String sql = "INSERT INTO dispensavinculo(iddispensadisciplina_fk, iddisciplinaatual_fk, iddisciplinacursada_fk, status) VALUES (?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaVinculo.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.setLong(2, dispensaVinculo.getDisciplinaAtual().getIdDisciplinaAtual());
            stmt.setLong(3, dispensaVinculo.getDisciplinaCursada().getIdDisciplinaCursada());
            stmt.setString(4, dispensaVinculo.getStatus());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaVinculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(DispensaVinculo dispensaVinculo) {
        String sql = "UPDATE dispensavinculo SET iddispensadisciplina_fk=?, iddisciplinaatual_fk=?, iddisciplinacursada_fk=?, status=? WHERE iddispensavinculo=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaVinculo.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.setLong(2, dispensaVinculo.getDisciplinaAtual().getIdDisciplinaAtual());
            stmt.setLong(3, dispensaVinculo.getDisciplinaCursada().getIdDisciplinaCursada());
            stmt.setString(4, dispensaVinculo.getStatus());
            stmt.setLong(5, dispensaVinculo.getIdDispensaVinculo());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaVinculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(DispensaVinculo dispensaVinculo) {
        String sql = "DELETE FROM dispensavinculo WHERE iddispensavinculo=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaVinculo.getIdDispensaVinculo());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaVinculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public DispensaVinculo selectID(DispensaVinculo dispensaVinculo) {
        String sql = "SELECT iddispensadisciplina_fk, iddisciplinaatual_fk, iddisciplinacursada_fk, status FROM dispensavinculo WHERE iddispensavinculo=?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaVinculo.getIdDispensaVinculo());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                DispensaDisciplinaDAO dispensaDisciplinaDAO = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscarDispensaDisciplina = null;

                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("iddispensadisciplina_fk"));
                buscarDispensaDisciplina = dispensaDisciplinaDAO.selectID(dispensaDisciplina);
                dispensaVinculo.setDispensaDisciplina(buscarDispensaDisciplina);

                DisciplinaAtualDAO DisciplinaAtualDAO = new DisciplinaAtualDAO();
                DisciplinaAtual disciplinaAtual = new DisciplinaAtual();
                DisciplinaAtual buscarDisciplinaAtual = null;

                disciplinaAtual.setIdDisciplinaAtual(rs.getLong("iddisciplinaatual_fk"));
                buscarDisciplinaAtual = DisciplinaAtualDAO.selectID(disciplinaAtual);
                dispensaVinculo.setDisciplinaAtual(buscarDisciplinaAtual);

                DisciplinaCursadaDAO disciplinaCursadaDAO = new DisciplinaCursadaDAO();
                DisciplinaCursada disciplinaCursada = new DisciplinaCursada();
                DisciplinaCursada buscarDisciplinaCursada = null;

                disciplinaCursada.setIdDisciplinaCursada(rs.getLong("iddisciplinacursada_fk"));
                buscarDisciplinaCursada = disciplinaCursadaDAO.selectID(disciplinaCursada);
                dispensaVinculo.setDisciplinaCursada(buscarDisciplinaCursada);

                dispensaVinculo.setStatus("status");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispensaVinculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dispensaVinculo;
    }

    public List<DispensaVinculo> selectAll() {
        String sql = "SELECT iddispensavinculo, iddispensadisciplina_fk, iddisciplinaatual_fk, iddisciplinacursada_fk, status FROM dispensavinculo;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DispensaVinculo> dispensaVinculos = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                DispensaVinculo dispensaVinculo = new DispensaVinculo();

                dispensaVinculo.setIdDispensaVinculo(rs.getLong("iddispensavinculo"));

                DispensaDisciplinaDAO dispensaDisciplinaDAO = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscarDispensaDisciplina = null;

                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("iddispensadisciplina_fk"));
                buscarDispensaDisciplina = dispensaDisciplinaDAO.selectID(dispensaDisciplina);
                dispensaVinculo.setDispensaDisciplina(buscarDispensaDisciplina);

                DisciplinaAtualDAO DisciplinaAtualDAO = new DisciplinaAtualDAO();
                DisciplinaAtual disciplinaAtual = new DisciplinaAtual();
                DisciplinaAtual buscarDisciplinaAtual = null;

                disciplinaAtual.setIdDisciplinaAtual(rs.getLong("iddisciplinaatual_fk"));
                buscarDisciplinaAtual = DisciplinaAtualDAO.selectID(disciplinaAtual);
                dispensaVinculo.setDisciplinaAtual(buscarDisciplinaAtual);

                DisciplinaCursadaDAO disciplinaCursadaDAO = new DisciplinaCursadaDAO();
                DisciplinaCursada disciplinaCursada = new DisciplinaCursada();
                DisciplinaCursada buscarDisciplinaCursada = null;

                disciplinaCursada.setIdDisciplinaCursada(rs.getLong("iddisciplinacursada_fk"));
                buscarDisciplinaCursada = disciplinaCursadaDAO.selectID(disciplinaCursada);
                dispensaVinculo.setDisciplinaCursada(buscarDisciplinaCursada);

                dispensaVinculo.setStatus("status");

                dispensaVinculos.add(dispensaVinculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispensaVinculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dispensaVinculos;
    }
}