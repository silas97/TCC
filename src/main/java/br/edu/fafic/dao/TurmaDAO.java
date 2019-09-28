package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.Turma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TurmaDAO
 */
public class TurmaDAO {

    private Connection con = null;

    public TurmaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Turma turma) {
        String sql = "INSERT INTO turma(periodo, sigla, idcurso_fk) VALUES (?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, turma.getPeriodo());
            stmt.setString(2, turma.getSigla());
            stmt.setLong(3, turma.getCurso().getIdCurso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Turma turma) {
        String sql = "UPDATE turma SET periodo=?, sigla=?, idcurso_fk=? WHERE idturma=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, turma.getPeriodo());
            stmt.setString(2, turma.getSigla());
            stmt.setLong(3, turma.getCurso().getIdCurso());
            stmt.setLong(4, turma.getIdTurma());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Turma turma) {
        String sql = "DELETE FROM turma WHERE idturma=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, turma.getIdTurma());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Turma selectID(Turma turma) {
        CursoDAO dao = new CursoDAO();
        Curso curso = new Curso();
        Curso buscaCurso = null;

        String sql = "SELECT periodo, sigla, idcurso_fk FROM turma WHERE idturma = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, turma.getIdTurma());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                turma.setPeriodo(rs.getString("periodo"));
                turma.setSigla(rs.getString("sigla"));

                curso.setIdCurso(rs.getLong("idcurso_fk"));
                buscaCurso = dao.selectID(curso);
                turma.setCurso(buscaCurso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return turma;
    }

    public List<Turma> selectAll() {
        CursoDAO dao = new CursoDAO();
        Curso curso = new Curso();
        Curso buscaCurso = null;

        String sql = "SELECT idturma, periodo, sigla, idcurso_fk FROM turma;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Turma> turmas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Turma turma = new Turma();
                turma.setIdTurma(rs.getLong("idturma"));
                turma.setPeriodo(rs.getString("periodo"));
                turma.setSigla(rs.getString("sigla"));

                curso.setIdCurso(rs.getLong("idcurso_fk"));
                buscaCurso = dao.selectID(curso);
                turma.setCurso(buscaCurso);
                
                turmas.add(turma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return turmas;
    }

}