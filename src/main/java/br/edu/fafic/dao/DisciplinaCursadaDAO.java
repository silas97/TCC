package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.DisciplinaCursada;
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
 * DisciplinaCursadaDAO
 */
public class DisciplinaCursadaDAO {

    private Connection con = null;

    public DisciplinaCursadaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DisciplinaCursada disciplinaCursada) {
        String sql = "INSERT INTO disciplinacursada(instituicaoorigem, curso, disciplina, creditos, horascursadas, iddispensadisciplina_fk) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disciplinaCursada.getInstituicaoOrigem());
            stmt.setString(2, disciplinaCursada.getCurso());
            stmt.setString(3, disciplinaCursada.getDisciplina());
            stmt.setString(4, disciplinaCursada.getCreditos());
            stmt.setString(5, disciplinaCursada.getHorasCursadas());
            stmt.setLong(6, disciplinaCursada.getDispensaDisciplina().getIdDispensaDisciplina());
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
        String sql = "UPDATE disciplinacursada SET instituicaoorigem=?, curso=?, disciplina=?, creditos=?, horascursadas=?, iddispensadisciplina_fk=? WHERE iddisciplinacursada=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disciplinaCursada.getInstituicaoOrigem());
            stmt.setString(2, disciplinaCursada.getCurso());
            stmt.setString(3, disciplinaCursada.getDisciplina());
            stmt.setString(4, disciplinaCursada.getCreditos());
            stmt.setString(5, disciplinaCursada.getHorasCursadas());
            stmt.setLong(6, disciplinaCursada.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.setLong(7, disciplinaCursada.getIdDisciplinaCursada());
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

    public DisciplinaCursada selectID(DisciplinaCursada disciplinaCursada) {
        String sql = "SELECT instituicaoorigem, curso, disciplina, creditos, horascursadas, dispensadisciplina_fk FROM disciplinacursada WHERE iddisciplinacursada = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, disciplinaCursada.getIdDisciplinaCursada());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                DispensaDisciplinaDAO dao = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscarDispensaDisciplina = null;
                
                disciplinaCursada.setInstituicaoOrigem(rs.getString("instituicaoorigem"));
                disciplinaCursada.setCurso(rs.getString("curso"));
                disciplinaCursada.setDisciplina(rs.getString("disciplina"));
                disciplinaCursada.setCreditos(rs.getString("creditos"));
                disciplinaCursada.setHorasCursadas(rs.getString("horascursadas"));
                
                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("dispensadisciplina_fk"));
                buscarDispensaDisciplina = dao.selectID(dispensaDisciplina);
                disciplinaCursada.setDispensaDisciplina(buscarDispensaDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinaCursada;
    }

    public List<DisciplinaCursada> selectAll() {
        String sql = "SELECT iddisciplinacursada, instituicaoorigem, curso, disciplina, creditos, horascursadas, dispensadisciplina_fk FROM disciplinacursada;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DisciplinaCursada> disciplinaCursadas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                DisciplinaCursada disciplinaCursada = new DisciplinaCursada();

                DispensaDisciplinaDAO dao = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscarDispensaDisciplina = null;

                disciplinaCursada.setIdDisciplinaCursada(rs.getLong("iddisciplinaCursada"));
                disciplinaCursada.setInstituicaoOrigem(rs.getString("instituicaoorigem"));
                disciplinaCursada.setCurso(rs.getString("curso"));
                disciplinaCursada.setDisciplina(rs.getString("disciplina"));
                disciplinaCursada.setCreditos(rs.getString("creditos"));
                disciplinaCursada.setHorasCursadas(rs.getString("horascursadas"));
                
                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("dispensadisciplina_fk"));
                buscarDispensaDisciplina = dao.selectID(dispensaDisciplina);
                disciplinaCursada.setDispensaDisciplina(buscarDispensaDisciplina);

                disciplinaCursadas.add(disciplinaCursada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinaCursadas;
    }
}