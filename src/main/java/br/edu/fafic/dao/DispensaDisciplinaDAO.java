package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.Disciplina;
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
 * DispensaDisciplinaDAO
 */
public class DispensaDisciplinaDAO {

    private Connection con = null;

    public DispensaDisciplinaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DispensaDisciplina dispensaDisciplina) {
        String sql = "INSERT INTO dispensadisciplina(idaluno_fk, iddisciplinacursada_fk, iddisciplina_fk) VALUES (?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaDisciplina.getAluno().getIdAluno());
            stmt.setLong(2, dispensaDisciplina.getDisciplinaCursada().getIdDisciplinaCursada());
            stmt.setLong(3, dispensaDisciplina.getDisciplina().getIdDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(DispensaDisciplina dispensaDisciplina) {
        String sql = "UPDATE dispensadisciplina SET idaluno_fk=?, iddisciplinacursada_fk=?, iddisciplina_fk=? WHERE iddispensadisciplina=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaDisciplina.getAluno().getIdAluno());
            stmt.setLong(2, dispensaDisciplina.getDisciplinaCursada().getIdDisciplinaCursada());
            stmt.setLong(3, dispensaDisciplina.getDisciplina().getIdDisciplina());
            stmt.setLong(4, dispensaDisciplina.getIdDispensaDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(DispensaDisciplina dispensaDisciplina) {
        String sql = "DELETE FROM dispensadisciplina WHERE iddispensadisciplina=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaDisciplina.getIdDispensaDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public DispensaDisciplina selectID(DispensaDisciplina dispensaDisciplina) {
        String sql = "SELECT idaluno_fk, iddisciplinacursada_fk, iddisciplina_fk FROM dispensadisciplina WHERE iddispensadisciplina = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        AlunoDAO daoAluno = new AlunoDAO();
        DisciplinaCursadaDAO daoDC = new DisciplinaCursadaDAO();
        DisciplinaDAO daoDisciplina = new DisciplinaDAO();

        Aluno aluno = null;
        DisciplinaCursada disciplinaCursada = null;
        Disciplina disciplina = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaDisciplina.getIdDispensaDisciplina());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                dispensaDisciplina.getAluno().setIdAluno(rs.getLong("idaluno_fk"));
                dispensaDisciplina.getDisciplinaCursada().setIdDisciplinaCursada(rs.getLong("iddisciplinacursada_fk"));
                dispensaDisciplina.getDisciplina().setIdDisciplina(rs.getLong("iddisciplina_fk"));

                aluno = daoAluno.selectID(dispensaDisciplina.getAluno());
                disciplinaCursada = daoDC.selectID(dispensaDisciplina.getDisciplinaCursada());
                disciplina = daoDisciplina.selectID(dispensaDisciplina.getDisciplina());

                dispensaDisciplina.setAluno(aluno);
                dispensaDisciplina.setDisciplinaCursada(disciplinaCursada);
                dispensaDisciplina.setDisciplina(disciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispensaDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dispensaDisciplina;
    }

    public List<DispensaDisciplina> selectAll() {
        AlunoDAO daoAluno = new AlunoDAO();
        DisciplinaCursadaDAO daoDC = new DisciplinaCursadaDAO();
        DisciplinaDAO daoDisciplina = new DisciplinaDAO();

        Aluno aluno = null;
        DisciplinaCursada disciplinaCursada = null;
        Disciplina disciplina = null;

        String sql = "SELECT iddispensadisciplina, idaluno_fk, iddisciplinacursada_fk, iddisciplina_fk FROM dispensadisciplina;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DispensaDisciplina> dispensaDisciplinas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("iddispensaDisciplina"));
                dispensaDisciplina.getAluno().setIdAluno(rs.getLong("idaluno_fk"));
                dispensaDisciplina.getDisciplinaCursada().setIdDisciplinaCursada(rs.getLong("iddisciplinacursada_fk"));
                dispensaDisciplina.getDisciplina().setIdDisciplina(rs.getLong("iddisciplina_fk"));

                aluno = daoAluno.selectID(dispensaDisciplina.getAluno());
                disciplinaCursada = daoDC.selectID(dispensaDisciplina.getDisciplinaCursada());
                disciplina = daoDisciplina.selectID(dispensaDisciplina.getDisciplina());

                dispensaDisciplina.setAluno(aluno);
                dispensaDisciplina.setDisciplinaCursada(disciplinaCursada);
                dispensaDisciplina.setDisciplina(disciplina);
                dispensaDisciplinas.add(dispensaDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispensaDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dispensaDisciplinas;
    }
}