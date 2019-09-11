package br.edu.fafic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Arquivo;

/**
 * ArquivoDAO
 */
public class ArquivoDAO {

    private Connection con = null;

    public ArquivoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Arquivo arquivo) {
        String sql = "INSERT INTO arquivo_upload_download(caminho, dataarquivoenviado, dataarquivorecebido, idaluno_fk, idmaster_fk, status) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean update(Arquivo arquivo) {
        String sql = "UPDATE arquivo_upload_download SET caminho=?, dataarquivoenviado=?, dataarquivorecebido=?, idaluno_fk=?, idmaster_fk=?, status=? WHERE idarquivo=?;";
        PreparedStatement stmt = null;
        try {
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Arquivo arquivo) {
        String sql = "DELETE FROM arquivo_upload_download WHERE idarquivo=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, arquivo.getIdArquivo());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}