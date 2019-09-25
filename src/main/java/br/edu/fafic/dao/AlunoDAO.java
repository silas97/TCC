package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * AlunoDAO
 */
public class AlunoDAO {

    private Connection con = null;

    public AlunoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Aluno aluno) {
        String sql = "INSERT INTO aluno(matricula, idcurso_fk, idusuario_fk) VALUES (?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getMatricula());
            stmt.setLong(2, aluno.getCurso().getIdCurso());
            stmt.setLong(3, aluno.getUsuario().getIdUsuario());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Aluno aluno) {
        String sql = "UPDATE aluno SET matricula=?, idcurso_fk=?, idusuario_fk=? WHERE idaluno=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getMatricula());
            stmt.setLong(2, aluno.getCurso().getIdCurso());
            stmt.setLong(3, aluno.getUsuario().getIdUsuario());
            stmt.setLong(4, aluno.getIdAluno());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Aluno aluno) {
        String sql = "DELETE FROM aluno WHERE idaluno=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, aluno.getIdAluno());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Aluno selectID(Aluno aluno) {
        String sql = "SELECT matricula, idcurso_fk, idusuario_fk FROM aluno WHERE idaluno = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDAO daoUser = new UsuarioDAO();
        CursoDAO daoCourse = new CursoDAO();
        Usuario usuario = null;
        Curso curso = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, aluno.getIdAluno());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                aluno.setMatricula(rs.getString("matricula"));
                aluno.getUsuario().setIdUsuario(rs.getLong("idusuario_fk"));
                aluno.getCurso().setIdCurso(rs.getLong("idcurso_fk"));
                usuario = daoUser.selectID(aluno.getUsuario());
                curso = daoCourse.selectID(aluno.getCurso());
                aluno.setUsuario(usuario);
                aluno.setCurso(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return aluno;
    }

    public List<Aluno> selectAll() {
        UsuarioDAO daoUser = new UsuarioDAO();
        Usuario usuario = null;
        
        CursoDAO daoCourse = new CursoDAO();
        Curso curso = null;
        
        String sql = "SELECT idaluno, matricula, idcurso_fk, idusuario_fk FROM aluno;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluno> alunos = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getLong("idaluno"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.getUsuario().setIdUsuario(rs.getLong("idusuario_fk"));
                aluno.getCurso().setIdCurso(rs.getLong("idcurso_fk"));
                usuario = daoUser.selectID(aluno.getUsuario());
                curso = daoCourse.selectID(aluno.getCurso());
                aluno.setUsuario(usuario);
                aluno.setCurso(curso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return alunos;
    }
}
