package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Processos;
import br.edu.fafic.model.RegimeDomiciliar;
import br.edu.fafic.model.RegimeDomiciliarProcesso;

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
 * RegimeDomiciliarProcessoDAO
 */
public class RegimeDomiciliarProcessoDAO {

    private Connection con = null;

    public RegimeDomiciliarProcessoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(RegimeDomiciliarProcesso regimeDomiciliarProcesso) {
        String sql = "INSERT INTO regimedomiciliar_processo(dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, idregimedomiciliar_fk) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) regimeDomiciliarProcesso.getDataProcesso());
            stmt.setDate(2, (Date) regimeDomiciliarProcesso.getDataEncerramento());
            stmt.setString(3, regimeDomiciliarProcesso.getStatus());
            stmt.setString(4, regimeDomiciliarProcesso.getVisibilidade());
            stmt.setLong(5, regimeDomiciliarProcesso.getProcessos().getIdProcessos());
            stmt.setLong(6, regimeDomiciliarProcesso.getRegimedomiciliar().getIdRegimeDomiciliar());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(RegimeDomiciliarProcesso regimeDomiciliarProcesso) {
        String sql = "UPDATE regimedomiciliar_processo SET dataprocesso=?, dataencerramento=?, status=?, visibilidade=?, idprocessos_fk=?, idregimedomiciliar_fk=? WHERE idregimedomiciliarprocesso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) regimeDomiciliarProcesso.getDataProcesso());
            stmt.setDate(2, (Date) regimeDomiciliarProcesso.getDataEncerramento());
            stmt.setString(3, regimeDomiciliarProcesso.getStatus());
            stmt.setString(4, regimeDomiciliarProcesso.getVisibilidade());
            stmt.setLong(5, regimeDomiciliarProcesso.getProcessos().getIdProcessos());
            stmt.setLong(6, regimeDomiciliarProcesso.getRegimedomiciliar().getIdRegimeDomiciliar());
            stmt.setLong(7, regimeDomiciliarProcesso.getIdRegimeDomiciliarProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(RegimeDomiciliarProcesso regimeDomiciliarProcesso) {
        String sql = "DELETE FROM regimedomiciliar_processo WHERE idregimedomiciliarprocesso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, regimeDomiciliarProcesso.getIdRegimeDomiciliarProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegimeDomiciliarProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public RegimeDomiciliarProcesso selectID(RegimeDomiciliarProcesso regimeDomiciliarProcesso) {
        String sql = "SELECT dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, idregimedomiciliar_fk FROM regimedomiciliar_processo WHERE idregimedomiciliarprocesso = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, regimeDomiciliarProcesso.getIdRegimeDomiciliarProcesso());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                ProcessosDAO processosDao = new ProcessosDAO();
                Processos processos = new Processos();
                Processos buscaProcessos = null;

                RegimeDomiciliarDAO daoCourse = new RegimeDomiciliarDAO();
                RegimeDomiciliar regimeDomiciliar = new RegimeDomiciliar();
                RegimeDomiciliar buscaRegimeDomiciliar = null;

                regimeDomiciliarProcesso.setDataProcesso(rs.getDate("dataprocesso"));
                regimeDomiciliarProcesso.setDataEncerramento(rs.getDate("dataencerramento"));
                regimeDomiciliarProcesso.setStatus(rs.getString("status"));
                regimeDomiciliarProcesso.setVisibilidade(rs.getString("visibilidade"));

                processos.setIdProcessos(rs.getLong("idprocessos_fk"));
                buscaProcessos = processosDao.selectID(processos);
                regimeDomiciliarProcesso.setProcessos(buscaProcessos);

                regimeDomiciliar.setIdRegimeDomiciliar(rs.getLong("idregimedomiciliar_fk"));
                regimeDomiciliar = daoCourse.selectID(regimeDomiciliar);
                regimeDomiciliarProcesso.setRegimedomiciliar(buscaRegimeDomiciliar);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegimeDomiciliarProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return regimeDomiciliarProcesso;
    }

    public List<RegimeDomiciliarProcesso> selectAll() {

        String sql = "SELECT idregimedomiciliarprocesso, dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, idregimedomiciliar_fk FROM regimedomiciliar_processo;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<RegimeDomiciliarProcesso> regimeDomiciliarProcessos = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                ProcessosDAO processosDao = new ProcessosDAO();
                Processos processos = new Processos();
                Processos buscaProcessos = null;

                RegimeDomiciliarDAO daoCourse = new RegimeDomiciliarDAO();
                RegimeDomiciliar regimeDomiciliar = new RegimeDomiciliar();
                RegimeDomiciliar buscaRegimeDomiciliar = null;
                RegimeDomiciliarProcesso regimeDomiciliarProcesso = new RegimeDomiciliarProcesso();
                regimeDomiciliarProcesso.setIdRegimeDomiciliarProcesso(rs.getLong("idregimeDomiciliarProcesso"));
                regimeDomiciliarProcesso.setDataProcesso(rs.getDate("dataprocesso"));
                regimeDomiciliarProcesso.setDataEncerramento(rs.getDate("dataencerramento"));
                regimeDomiciliarProcesso.setStatus(rs.getString("status"));
                regimeDomiciliarProcesso.setVisibilidade(rs.getString("visibilidade"));

                processos.setIdProcessos(rs.getLong("idprocessos_fk"));
                buscaProcessos = processosDao.selectID(processos);
                regimeDomiciliarProcesso.setProcessos(buscaProcessos);

                regimeDomiciliar.setIdRegimeDomiciliar(rs.getLong("idregimedomiciliar_fk"));
                regimeDomiciliar = daoCourse.selectID(regimeDomiciliar);
                regimeDomiciliarProcesso.setRegimedomiciliar(buscaRegimeDomiciliar);

                regimeDomiciliarProcessos.add(regimeDomiciliarProcesso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegimeDomiciliarProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return regimeDomiciliarProcessos;
    }
}