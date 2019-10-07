package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.DispensaDisciplina;
import br.edu.fafic.model.DispensaDisciplinaProcesso;
import br.edu.fafic.model.Processos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DispensaDisciplinaProcessoDAO
 */
public class DispensaDisciplinaProcessoDAO {
    private Connection con = null;

    public DispensaDisciplinaProcessoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DispensaDisciplinaProcesso dispensaDisciplinaProcesso) {
        String sql = "INSERT INTO dispensadisciplina_processo(dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, iddispensadisciplina_fk) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) dispensaDisciplinaProcesso.getDataProcesso());
            stmt.setDate(2, (Date) dispensaDisciplinaProcesso.getDataEncerramento());
            stmt.setString(3, dispensaDisciplinaProcesso.getStatus());
            stmt.setString(4, dispensaDisciplinaProcesso.getVisibilidade());
            stmt.setLong(5, dispensaDisciplinaProcesso.getProcessos().getIdProcessos());
            stmt.setLong(6, dispensaDisciplinaProcesso.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(DispensaDisciplinaProcesso dispensaDisciplinaProcesso) {
        String sql = "UPDATE dispensadisciplina_processo SET dataprocesso=?, dataencerramento=?, status=?, visibilidade=?, idprocessos_fk=?, iddispensadisciplina_fk=? WHERE iddispensadisciplinaprocesso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) dispensaDisciplinaProcesso.getDataProcesso());
            stmt.setDate(2, (Date) dispensaDisciplinaProcesso.getDataEncerramento());
            stmt.setString(3, dispensaDisciplinaProcesso.getStatus());
            stmt.setString(4, dispensaDisciplinaProcesso.getVisibilidade());
            stmt.setLong(5, dispensaDisciplinaProcesso.getProcessos().getIdProcessos());
            stmt.setLong(6, dispensaDisciplinaProcesso.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.setLong(7, dispensaDisciplinaProcesso.getIdDispensaDisciplinaProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(DispensaDisciplinaProcesso dispensaDisciplinaProcesso) {
        String sql = "DELETE FROM dispensadisciplina_processo WHERE iddispensadisciplinaprocesso = ?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaDisciplinaProcesso.getIdDispensaDisciplinaProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DispensaDisciplinaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public DispensaDisciplinaProcesso selectID(DispensaDisciplinaProcesso dispensaDisciplinaProcesso) {

        String sql = "SELECT dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, iddispensadisciplina_fk FROM dispensadisciplina_processo WHERE iddispensadiscipina_fk = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, dispensaDisciplinaProcesso.getIdDispensaDisciplinaProcesso());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                ProcessosDAO processosDao = new ProcessosDAO();
                Processos processos = new Processos();
                Processos buscaProcessos = null;

                DispensaDisciplinaDAO dispensaDisciplinaDao = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscaDispensaDisciplina = null;
                dispensaDisciplinaProcesso.setDataProcesso(rs.getDate("dataprocesso"));
                dispensaDisciplinaProcesso.setDataEncerramento(rs.getDate("dataencerramento"));
                dispensaDisciplinaProcesso.setStatus(rs.getString("status"));
                dispensaDisciplinaProcesso.setVisibilidade(rs.getString("visibilidade"));

                processos.setIdProcessos(rs.getLong("idprocessos_fk"));
                buscaProcessos = processosDao.selectID(processos);
                dispensaDisciplinaProcesso.setProcessos(buscaProcessos);

                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("iddispensadisciplina_fk"));
                buscaDispensaDisciplina = dispensaDisciplinaDao.selectID(dispensaDisciplina);
                dispensaDisciplinaProcesso.setDispensaDisciplina(buscaDispensaDisciplina);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DispensaDisciplinaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dispensaDisciplinaProcesso;
    }

    public List<DispensaDisciplinaProcesso> selectAll() {

        String sql = "SELECT iddispensadisciplinaprocesso, dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, iddispensadisciplina_fk FROM dispensadisciplina_processo;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DispensaDisciplinaProcesso> dispensaDisciplinaProcessos = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProcessosDAO processosDao = new ProcessosDAO();
                Processos processos = new Processos();
                Processos buscaProcessos = null;

                DispensaDisciplinaDAO dispensaDisciplinaDao = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscaDispensaDisciplina = null;
                DispensaDisciplinaProcesso dispensaDisciplinaProcesso = new DispensaDisciplinaProcesso();
                dispensaDisciplinaProcesso.setIdDispensaDisciplinaProcesso(rs.getLong("iddispensaDisciplinaProcesso"));
                dispensaDisciplinaProcesso.setDataProcesso(rs.getDate("dataprocesso"));
                dispensaDisciplinaProcesso.setDataEncerramento(rs.getDate("dataencerramento"));
                dispensaDisciplinaProcesso.setStatus(rs.getString("status"));
                dispensaDisciplinaProcesso.setVisibilidade(rs.getString("visibilidade"));

                processos.setIdProcessos(rs.getLong("idprocessos_fk"));
                buscaProcessos = processosDao.selectID(processos);
                dispensaDisciplinaProcesso.setProcessos(buscaProcessos);

                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("iddispensadisciplina_fk"));
                buscaDispensaDisciplina = dispensaDisciplinaDao.selectID(dispensaDisciplina);
                dispensaDisciplinaProcesso.setDispensaDisciplina(buscaDispensaDisciplina);
                dispensaDisciplinaProcessos.add(dispensaDisciplinaProcesso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispensaDisciplinaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dispensaDisciplinaProcessos;
    }
}