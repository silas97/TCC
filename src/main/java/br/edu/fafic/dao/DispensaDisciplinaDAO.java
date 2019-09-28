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
        AlunoDAO alunoDao = new AlunoDAO();
        Aluno aluno = new Aluno();
        Aluno buscaAluno = null;
        
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        Disciplina disciplina = new Disciplina();
        Disciplina buscaDisciplina = null;
        
        DisciplinaCursadaDAO disciplinaCursadaDao = new DisciplinaCursadaDAO();
        DisciplinaCursada disciplinaCursada = new DisciplinaCursada();
        DisciplinaCursada buscaDisciplinaCursada = null;
        
        String sql = "SELECT idaluno_fk, iddisciplinacursada_fk, iddisciplina_fk FROM dispensadisciplina WHERE iddispensadisciplina = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaDisciplina.getIdDispensaDisciplina());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                aluno.setIdAluno(rs.getLong("idaluno_fk"));
                disciplinaCursada.setIdDisciplinaCursada(rs.getLong("iddisciplinacursada_fk"));
                disciplina.setIdDisciplina(rs.getLong("iddisciplina_fk"));

                buscaAluno = alunoDao.selectID(aluno);
                buscaDisciplinaCursada = disciplinaCursadaDao.selectID(disciplinaCursada);
                buscaDisciplina = disciplinaDao.selectID(disciplina);

                dispensaDisciplina.setAluno(buscaAluno);
                dispensaDisciplina.setDisciplinaCursada(buscaDisciplinaCursada);
                dispensaDisciplina.setDisciplina(buscaDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispensaDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dispensaDisciplina;
    }

    public List<DispensaDisciplina> selectAll() {
        AlunoDAO alunoDao = new AlunoDAO();
        Aluno aluno = new Aluno();
        Aluno buscaAluno = null;
        
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        Disciplina disciplina = new Disciplina();
        Disciplina buscaDisciplina = null;
        
        DisciplinaCursadaDAO disciplinaCursadaDao = new DisciplinaCursadaDAO();
        DisciplinaCursada disciplinaCursada = new DisciplinaCursada();
        DisciplinaCursada buscaDisciplinaCursada = null;

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
                aluno.setIdAluno(rs.getLong("idaluno_fk"));
                disciplinaCursada.setIdDisciplinaCursada(rs.getLong("iddisciplinacursada_fk"));
                disciplina.setIdDisciplina(rs.getLong("iddisciplina_fk"));

                buscaAluno = alunoDao.selectID(aluno);
                buscaDisciplinaCursada = disciplinaCursadaDao.selectID(disciplinaCursada);
                buscaDisciplina = disciplinaDao.selectID(disciplina);

                dispensaDisciplina.setAluno(buscaAluno);
                dispensaDisciplina.setDisciplinaCursada(buscaDisciplinaCursada);
                dispensaDisciplina.setDisciplina(buscaDisciplina);
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