package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}