package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
