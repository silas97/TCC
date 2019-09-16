package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.DisciplinaCursada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DisciplinaCursadaDAO
 */
public class DisciplinaCursadaDAO {

    private Connection con = null;

    public DisciplinaCursadaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DisciplinaCursada disciplinaCursada) {
        String sql = "INSERT INTO disciplinacursada(instituicaoorigem, curso, disciplina, creditos, horascursadas) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disciplinaCursada.getInstituicaoOrigem());
            stmt.setString(2, disciplinaCursada.getCurso());
            stmt.setString(3, disciplinaCursada.getDisciplina());
            stmt.setString(4, disciplinaCursada.getCreditos());
            stmt.setString(5, disciplinaCursada.getHorasCursadas());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(DisciplinaCursada disciplinaCursada) {
        String sql = "UPDATE disciplinacursada SET instituicaoorigem=?, curso=?, disciplina=?, creditos=?, horascursadas=? WHERE iddisciplinacursada=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disciplinaCursada.getInstituicaoOrigem());
            stmt.setString(2, disciplinaCursada.getCurso());
            stmt.setString(3, disciplinaCursada.getDisciplina());
            stmt.setString(4, disciplinaCursada.getCreditos());
            stmt.setString(5, disciplinaCursada.getHorasCursadas());
            stmt.setLong(6, disciplinaCursada.getIdDisciplinaCursada());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(DisciplinaCursada disciplinaCursada) {
        String sql = "DELETE FROM disciplinacursada WHERE iddisciplinacursada=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, disciplinaCursada.getIdDisciplinaCursada());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}