package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Disciplina;
import br.edu.fafic.model.DisciplinaAtual;
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
 * DisciplinaAtualDAO
 */
public class DisciplinaAtualDAO {

    private Connection con = null;

    public DisciplinaAtualDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DisciplinaAtual disciplinaAtual) {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO disciplinas_processo(id_processo, id_disciplina, id_disciplina_cursada) VALUES (?, ?, ?);";
        PreparedStatement stmt = null;
       
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, disciplinaAtual.getProcesso().getIdProcessos());
            stmt.setLong(2, disciplinaAtual.getDisciplinaOfertada().getIdDisciplina());
            stmt.setLong(3, disciplinaAtual.getDisciplinaCursada().getIdDisciplinaCursada());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaAtualDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(DisciplinaAtual disciplinaAtual) {
        String sql = "UPDATE disciplinaatual SET iddispensadisciplina_fk=?, iddisciplina_fk=? WHERE iddisciplinaatual=?;";
        PreparedStatement stmt = null;
        try {
//            stmt = con.prepareStatement(sql);
//            stmt.setLong(1, disciplinaAtual.getDispensaDisciplina().getIdDispensaDisciplina());
//            stmt.setLong(2, disciplinaAtual.getDisciplinaOfertada().getIdDisciplina());
//            stmt.setLong(3, disciplinaAtual.getIdDisciplinaAtual());
//            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaAtualDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(DisciplinaAtual disciplinaAtual) {
        String sql = "DELETE FROM disciplinaatual WHERE iddisciplinaatual=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, disciplinaAtual.getIdDisciplinaAtual());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaAtualDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public DisciplinaAtual selectID(DisciplinaAtual disciplinaAtual) {
        con = ConnectionFactory.getConnection();
        String sql = "SELECT iddispensadisciplina_fk, iddisciplina_fk FROM disciplinaatual WHERE iddisciplinaatual = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, disciplinaAtual.getIdDisciplinaAtual());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                DispensaDisciplinaDAO dispensaDisciplinaDAO = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscarDispensaDisciplina = null;

                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("iddispensadisciplina_fk"));
                buscarDispensaDisciplina = dispensaDisciplinaDAO.selectID(dispensaDisciplina);
//                disciplinaAtual.setDispensaDisciplina(buscarDispensaDisciplina);

                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                Disciplina disciplina = new Disciplina();
                Disciplina buscarDisciplina = null;

                disciplina.setIdDisciplina(rs.getLong("iddisciplina_fk"));
                buscarDisciplina = disciplinaDAO.selectID(disciplina);
//                disciplinaAtual.setDisciplinaOfertada(buscarDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaAtualDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinaAtual;
    }
    
    public DisciplinaAtual selectDisciplinaByPocessoId(Long idProcesso) {
        con = ConnectionFactory.getConnection();
        DisciplinaAtual atual = new DisciplinaAtual();
        String sql = "SELECT * FROM disciplinas_processo WHERE id_processo = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, idProcesso);
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
               atual.setIdDisciplinaAtual(rs.getLong("id"));
               atual.setProcesso(new ProcessosDAO().selectProcessoById(rs.getLong("id_processo")));
//               atual.setDisciplinaOfertada(new DisciplinaDAO().selectDisciplinaByID(rs.getLong("id_disciplina")));
//               atual.setDisciplinaCursada(new DisciplinaCursadaDAO().selectDisciplinaByID(rs.getLong("id_disciplina_cursada")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaAtualDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return atual;
    }

    public List<DisciplinaAtual> selectAll() {
        String sql = "SELECT iddisciplinaatual, iddispensadisciplina_fk, iddisciplina_fk FROM disciplinaatual;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DisciplinaAtual> disciplinas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                DisciplinaAtual disciplinaAtual = new DisciplinaAtual();

                disciplinaAtual.setIdDisciplinaAtual(rs.getLong("iddisciplinaatual"));

                DispensaDisciplinaDAO dispensaDisciplinaDAO = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscarDispensaDisciplina = null;

                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("iddispensadisciplina_fk"));
                buscarDispensaDisciplina = dispensaDisciplinaDAO.selectID(dispensaDisciplina);
//                disciplinaAtual.setDispensaDisciplina(buscarDispensaDisciplina);

                DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
                Disciplina disciplina = new Disciplina();
                Disciplina buscarDisciplina = null;

                disciplina.setIdDisciplina(rs.getLong("iddisciplina_fk"));
                buscarDisciplina = disciplinaDAO.selectID(disciplina);
//                disciplinaAtual.setDisciplinaOfertada(buscarDisciplina);

                disciplinas.add(disciplinaAtual);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaAtualDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinas;
    }
}