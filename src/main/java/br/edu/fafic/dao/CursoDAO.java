package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CursoDAO
 */
public class CursoDAO {

    private Connection con = null;

    public CursoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Curso curso) {
        String sql = "INSERT INTO curso(nome) VALUES (?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Curso curso) {
        String sql = "UPDATE Curso SET nome=? WHERE idcurso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setLong(2, curso.getIdCurso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Curso curso) {
        String sql = "DELETE FROM curso WHERE idcurso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, curso.getIdCurso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Curso selectID(Curso curso) {
        String sql = "SELECT nome FROM curso WHERE idcurso = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, curso.getIdCurso());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                curso.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return curso;
    }

    public List<Curso> selectAll() {
        String sql = "SELECT idcurso, nome FROM curso;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso();
                curso.setIdCurso(rs.getLong("idcurso"));
                curso.setNome(rs.getString("nome"));
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cursos;
    }
}