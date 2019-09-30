/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Curso;
import br.edu.fafic.model.Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luciano
 */
public class DocumentoDAO {

    private Connection con = null;

    public DocumentoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(Documento documento) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO documento VALUES (default, ?, ?);";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, documento.getPath());
            stmt.setString(2, documento.getTipo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Documento> listaDocumentos() {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;;
        List<Documento> documentos = new ArrayList();
        try {
            String sql = "select * from documento";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                documentos.add(new Documento(rs.getInt("id"), rs.getString("path"), rs.getString("tipo")));
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return documentos;
    }

}
