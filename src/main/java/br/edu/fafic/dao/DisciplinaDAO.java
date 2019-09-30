package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DisciplinaDAO
 */
public class DisciplinaDAO {

    private Connection con = null;

    public DisciplinaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina(nome, creditos, cargahoraria, idcurso_fk) VALUES (?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disciplina.getNome());
            stmt.setString(2, disciplina.getCreditos());
            stmt.setString(3, disciplina.getCargaHoraria());
            stmt.setLong(4, disciplina.getCurso().getIdCurso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Disciplina disciplina) {
        String sql = "UPDATE disciplina SET nome=?, creditos=?, cargahoraria=?, idcurso_fk=? WHERE iddisciplina=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disciplina.getNome());
            stmt.setString(2, disciplina.getCreditos());
            stmt.setString(3, disciplina.getCargaHoraria());
            stmt.setLong(4, disciplina.getCurso().getIdCurso());
            stmt.setLong(5, disciplina.getIdDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Disciplina disciplina) {
        String sql = "DELETE FROM disciplina WHERE iddisciplina=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, disciplina.getIdDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Disciplina selectID(Disciplina disciplina) {
        String sql = "SELECT nome, creditos, cargahoraria, idcurso_fk FROM disciplina WHERE iddisciplina = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, disciplina.getIdDisciplina());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                CursoDAO dao = new CursoDAO();
                Curso curso = new Curso();
                Curso buscarCurso = null;
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCreditos(rs.getString("creditos"));
                disciplina.setCargaHoraria(rs.getString("cargahoraria"));

                curso.setIdCurso(rs.getLong("idcurso_fk"));
                buscarCurso = dao.selectID(curso);
                disciplina.setCurso(buscarCurso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplina;
    }

    public List<Disciplina> selectAll() {
        String sql = "SELECT iddisciplina, nome, creditos, cargahoraria, idcurso_fk FROM disciplina;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CursoDAO dao = new CursoDAO();
                Curso curso = new Curso();
                Curso buscarCurso = null;
                Disciplina disciplina = new Disciplina();
                disciplina.setIdDisciplina(rs.getLong("iddisciplina"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCreditos(rs.getString("creditos"));
                disciplina.setCargaHoraria(rs.getString("cargahoraria"));
                curso.setIdCurso(rs.getLong("idcurso_fk"));
                buscarCurso = dao.selectID(curso);
                disciplina.setCurso(buscarCurso);

                disciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinas;
    }
}