package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.Processos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ProcessosDAO
 */
public class ProcessosDAO {

    private Connection con = null;

    public ProcessosDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Processos processos) {
        String sql = "INSERT INTO processos(idaluno_fk) VALUES (?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getAluno().getIdAluno());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Processos processos) {
        String sql = "UPDATE processos SET idaluno_fk=? WHERE idprocessos=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getAluno().getIdAluno());
            stmt.setLong(2, processos.getIdProcessos());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Processos processos) {
        String sql = "DELETE FROM processos WHERE idprocessos=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getIdProcessos());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Processos selectID(Processos processos) {

        String sql = "SELECT idaluno_fk FROM processos WHERE idprocessos = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getIdProcessos());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                AlunoDAO dao = new AlunoDAO();
                Aluno aluno = new Aluno();
                Aluno buscaAluno = null;
                aluno.setIdAluno(rs.getLong("idaluno_fk"));
                buscaAluno = dao.selectID(aluno);
                processos.setAluno(buscaAluno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return processos;
    }

    public List<Processos> selectAll() {
        String sql = "SELECT idprocessos, idaluno_fk FROM processos;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Processos> listaProcessos = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AlunoDAO dao = new AlunoDAO();
                Aluno aluno = new Aluno();
                Aluno buscaAluno = null;
                Processos processos = new Processos();
                processos.setIdProcessos(rs.getLong("idprocessos"));

                aluno.setIdAluno(rs.getLong("idaluno_fk"));
                buscaAluno = dao.selectID(aluno);
                processos.setAluno(buscaAluno);

                listaProcessos.add(processos);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaProcessos;
    }
}