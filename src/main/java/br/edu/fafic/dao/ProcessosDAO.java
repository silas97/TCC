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
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO processos(idaluno_fk, tipo) VALUES (?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getAluno().getIdAluno());
            stmt.setString(2, processos.getTipo());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Long inserirProcesso(Processos processos) {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO processos(idaluno_fk, tipo) VALUES (?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getAluno().getIdAluno());
            stmt.setString(2, processos.getTipo());
            stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return getProcessId();
    }

    public Long getProcessId() {
        Long maxId = null;
        con = ConnectionFactory.getConnection();
        String sql = "select max(idprocessos) from processos";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                maxId = rs.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return maxId;
    }

    public boolean update(Processos processos) {
        String sql = "UPDATE processos SET idaluno_fk=?, tipo=? WHERE idprocessos=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, processos.getAluno().getIdAluno());
            stmt.setString(2, processos.getTipo());
            stmt.setLong(3, processos.getIdProcessos());
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

        String sql = "SELECT idaluno_fk, tipo FROM processos WHERE idprocessos = ?;";
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
                processos.setTipo(rs.getString("tipo"));
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

    public Processos selectProcessoById(Long idProcesso) {
        con = ConnectionFactory.getConnection();
        Processos processos = new Processos();
        String sql = "SELECT idprocessos,idaluno_fk, tipo FROM processos WHERE idprocessos = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, idProcesso);
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                AlunoDAO dao = new AlunoDAO();
                Aluno aluno = new Aluno();
                Aluno buscaAluno = null;
                processos.setIdProcessos(rs.getLong("idprocessos"));
                processos.setTipo(rs.getString("tipo"));
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
        String sql = "SELECT idprocessos, idaluno_fk, tipo FROM processos;";
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
                processos.setTipo(rs.getString("tipo"));

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

    public String pathAquivoByPidProcesso(Long id) {
        con = ConnectionFactory.getConnection();
        String sql = "select path_arquivo from dispensadisciplina_processo\n"
                + "where idprocessos_fk = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String path = "";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                path = rs.getString(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProcessosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
       
        return path;
    }
}
