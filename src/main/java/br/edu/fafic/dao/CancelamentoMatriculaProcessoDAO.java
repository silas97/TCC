package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.CancelamentoMatricula;
import br.edu.fafic.model.CancelamentoMatriculaProcesso;
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
 * CancelamentoMatriculaProcessoDAO
 */
public class CancelamentoMatriculaProcessoDAO {

    private Connection con = null;

    public CancelamentoMatriculaProcessoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(CancelamentoMatriculaProcesso cancelamentoMatriculaProcesso) {
        String sql = "INSERT INTO Cancelamentomatricula_processo(dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, idcancelamentomatricula_fk) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) cancelamentoMatriculaProcesso.getDataProcesso());
            stmt.setDate(2, (Date) cancelamentoMatriculaProcesso.getDataEncerramento());
            stmt.setString(3, cancelamentoMatriculaProcesso.getStatus());
            stmt.setString(4, cancelamentoMatriculaProcesso.getVisibilidade());
            stmt.setLong(5, cancelamentoMatriculaProcesso.getProcessos().getIdProcessos());
            stmt.setLong(6, cancelamentoMatriculaProcesso.getCancelamentoMatricula().getIdCancelamentoMatricula());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CancelamentoMatriculaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(CancelamentoMatriculaProcesso cancelamentoMatriculaProcesso) {
        String sql = "UPDATE Cancelamentomatricula_processo SET dataprocesso=?, dataencerramento=?, status=?, visibilidade=?, idprocessos_fk=?, idcancelamentomatricula_fk=? WHERE idcancelamentomatriculaprocesso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) cancelamentoMatriculaProcesso.getDataProcesso());
            stmt.setDate(2, (Date) cancelamentoMatriculaProcesso.getDataEncerramento());
            stmt.setString(3, cancelamentoMatriculaProcesso.getStatus());
            stmt.setString(4, cancelamentoMatriculaProcesso.getVisibilidade());
            stmt.setLong(5, cancelamentoMatriculaProcesso.getProcessos().getIdProcessos());
            stmt.setLong(6, cancelamentoMatriculaProcesso.getCancelamentoMatricula().getIdCancelamentoMatricula());
            stmt.setLong(7, cancelamentoMatriculaProcesso.getIdCancelamentoMatriculaProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CancelamentoMatriculaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(CancelamentoMatriculaProcesso cancelamentoMatriculaProcesso) {
        String sql = "DELETE FROM cancelamentomatricula_processo WHERE idcancelamentomatriculaprocesso=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, cancelamentoMatriculaProcesso.getIdCancelamentoMatriculaProcesso());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CancelamentoMatriculaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public CancelamentoMatriculaProcesso selectID(CancelamentoMatriculaProcesso cancelamentoMatriculaProcesso) {

        String sql = "SELECT dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, idcancelamentomatricula_fk FROM cancelamentomatricula_processo WHERE idcancelamentomatriculaprocesso = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, cancelamentoMatriculaProcesso.getIdCancelamentoMatriculaProcesso());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                CancelamentoMatriculaDAO cancelamentoMatriculaDao = new CancelamentoMatriculaDAO();
                CancelamentoMatricula cancelamentoMatricula = new CancelamentoMatricula();
                CancelamentoMatricula buscaCancelamentoMatricula = null;

                ProcessosDAO processoDao = new ProcessosDAO();
                Processos processos = new Processos();
                Processos buscaProcessos = null;
                cancelamentoMatriculaProcesso.setDataProcesso(rs.getDate("dataprocesso"));
                cancelamentoMatriculaProcesso.setDataEncerramento(rs.getDate("dataencerramento"));
                cancelamentoMatriculaProcesso.setStatus(rs.getString("status"));
                cancelamentoMatriculaProcesso.setVisibilidade(rs.getString("visibilidade"));
                processos.setIdProcessos(rs.getLong("idprocessos_fk"));
                buscaProcessos = processoDao.selectID(processos);
                cancelamentoMatriculaProcesso.setProcessos(buscaProcessos);
                cancelamentoMatricula.setIdCancelamentoMatricula(rs.getLong("idcancelamentomatricula_fk"));
                buscaCancelamentoMatricula = cancelamentoMatriculaDao.selectID(cancelamentoMatricula);
                cancelamentoMatriculaProcesso.setCancelamentoMatricula(buscaCancelamentoMatricula);

            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoMatriculaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cancelamentoMatriculaProcesso;
    }

    public List<CancelamentoMatriculaProcesso> selectAll() {

        String sql = "SELECT idcancelamentomatriculaprocesso, dataprocesso, dataencerramento, status, visibilidade, idprocessos_fk, idcancelamentomatricula_fk FROM cancelamentomatricula_processo;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<CancelamentoMatriculaProcesso> cancelamentoMatriculaProcessos = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                CancelamentoMatriculaDAO cancelamentoMatriculaDao = new CancelamentoMatriculaDAO();
                CancelamentoMatricula cancelamentoMatricula = new CancelamentoMatricula();
                CancelamentoMatricula buscaCancelamentoMatricula = null;
                ProcessosDAO processoDao = new ProcessosDAO();
                Processos processos = new Processos();
                Processos buscaProcessos = null;
                CancelamentoMatriculaProcesso cancelamentoMatriculaProcesso = new CancelamentoMatriculaProcesso();
                cancelamentoMatriculaProcesso
                        .setIdCancelamentoMatriculaProcesso(rs.getLong("idcancelamentoMatriculaProcesso"));
                cancelamentoMatriculaProcesso.setDataProcesso(rs.getDate("dataprocesso"));
                cancelamentoMatriculaProcesso.setDataEncerramento(rs.getDate("dataencerramento"));
                cancelamentoMatriculaProcesso.setStatus(rs.getString("status"));
                cancelamentoMatriculaProcesso.setVisibilidade(rs.getString("visibilidade"));
                processos.setIdProcessos(rs.getLong("idprocessos_fk"));
                buscaProcessos = processoDao.selectID(processos);
                cancelamentoMatriculaProcesso.setProcessos(buscaProcessos);
                cancelamentoMatricula.setIdCancelamentoMatricula(rs.getLong("idcancelamentomatricula_fk"));
                buscaCancelamentoMatricula = cancelamentoMatriculaDao.selectID(cancelamentoMatricula);
                cancelamentoMatriculaProcesso.setCancelamentoMatricula(buscaCancelamentoMatricula);
                cancelamentoMatriculaProcessos.add(cancelamentoMatriculaProcesso);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoMatriculaProcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cancelamentoMatriculaProcessos;
    }
}