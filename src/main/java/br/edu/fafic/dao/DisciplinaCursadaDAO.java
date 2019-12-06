package br.edu.fafic.dao;

import br.edu.fafic.connection.ConnectionFactory;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.DisciplinaCursada;
import br.edu.fafic.model.DispensaDisciplina;
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
 * DisciplinaCursadaDAO
 */
public class DisciplinaCursadaDAO {

    private Connection con = null;

    public DisciplinaCursadaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean insert(DisciplinaCursada disciplinaCursada) {
        String sql = "INSERT INTO disciplinacursada(instituicaoorigem, curso, disciplina, creditos, horascursadas) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disciplinaCursada.getInstituicaoOrigem());
            stmt.setString(2, disciplinaCursada.getCurso());
            stmt.setString(3, disciplinaCursada.getDisciplina());
            stmt.setString(4, disciplinaCursada.getCreditos());
            stmt.setString(5, disciplinaCursada.getHorasCursadas());
//            stmt.setLong(6, disciplinaCursada.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Long insertById(DisciplinaCursada disciplinaCursada) {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO disciplinacursada(instituicaoorigem, curso, disciplina, creditos, horascursadas) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disciplinaCursada.getInstituicaoOrigem());
            stmt.setString(2, disciplinaCursada.getCurso());
            stmt.setString(3, disciplinaCursada.getDisciplina());
            stmt.setString(4, disciplinaCursada.getCreditos());
            stmt.setString(5, disciplinaCursada.getHorasCursadas());
//            stmt.setLong(6, disciplinaCursada.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return maxIdDisciplinaCursada();
    }

    public boolean insertDisciplinaCursadaAluno(Long idDisciplinaCursada, Long idAluno) {
        con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO disciplina_cursada_aluno(id_aluno, id_disciplina_cursada) VALUES (?, ?);";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, idAluno);
            stmt.setLong(2, idDisciplinaCursada);

//            stmt.setLong(6, disciplinaCursada.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return true;
    }

    public Long maxIdDisciplinaCursada() {
        con = ConnectionFactory.getConnection();
        DisciplinaCursada dis = new DisciplinaCursada();
        String sql = "SELECT max(iddisciplinacursada) as id FROM disciplinacursada;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                dis.setIdDisciplinaCursada(rs.getLong("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dis.getIdDisciplinaCursada();
    }

    public boolean update(DisciplinaCursada disciplinaCursada) {
        String sql = "UPDATE disciplinacursada SET instituicaoorigem=?, curso=?, disciplina=?, creditos=?, horascursadas=?, iddispensadisciplina_fk=? WHERE iddisciplinacursada=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, disciplinaCursada.getInstituicaoOrigem());
            stmt.setString(2, disciplinaCursada.getCurso());
            stmt.setString(3, disciplinaCursada.getDisciplina());
            stmt.setString(4, disciplinaCursada.getCreditos());
            stmt.setString(5, disciplinaCursada.getHorasCursadas());
//            stmt.setLong(6, disciplinaCursada.getDispensaDisciplina().getIdDispensaDisciplina());
            stmt.setLong(7, disciplinaCursada.getIdDisciplinaCursada());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(DisciplinaCursada disciplinaCursada) {
        String sql = "DELETE FROM disciplinacursada WHERE iddisciplinacursada=?;";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, disciplinaCursada.getIdDisciplinaCursada());
            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public DisciplinaCursada selectID(DisciplinaCursada disciplinaCursada) {
        String sql = "SELECT instituicaoorigem, curso, disciplina, creditos, horascursadas, dispensadisciplina_fk FROM disciplinacursada WHERE iddisciplinacursada = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, disciplinaCursada.getIdDisciplinaCursada());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                DispensaDisciplinaDAO dao = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscarDispensaDisciplina = null;

                disciplinaCursada.setInstituicaoOrigem(rs.getString("instituicaoorigem"));
                disciplinaCursada.setCurso(rs.getString("curso"));
                disciplinaCursada.setDisciplina(rs.getString("disciplina"));
                disciplinaCursada.setCreditos(rs.getString("creditos"));
                disciplinaCursada.setHorasCursadas(rs.getString("horascursadas"));

                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("dispensadisciplina_fk"));
                buscarDispensaDisciplina = dao.selectID(dispensaDisciplina);
//                disciplinaCursada.setDispensaDisciplina(buscarDispensaDisciplina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinaCursada;
    }
    
    public DisciplinaCursada selectDisciplinaByID(Long id) {
        con = ConnectionFactory.getConnection();
        DisciplinaCursada disciplinaCursada = new DisciplinaCursada();
        String sql = "SELECT * FROM disciplinacursada WHERE iddisciplinacursada = ?;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                
                disciplinaCursada.setIdDisciplinaCursada(rs.getLong("iddisciplinacursada"));
                disciplinaCursada.setInstituicaoOrigem(rs.getString("instituicaoorigem"));
                disciplinaCursada.setCurso(rs.getString("curso"));
                disciplinaCursada.setDisciplina(rs.getString("disciplina"));
                disciplinaCursada.setCreditos(rs.getString("creditos"));
                disciplinaCursada.setHorasCursadas(rs.getString("horascursadas"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinaCursada;
    }

    public List<DisciplinaCursada> selectAll() {
        String sql = "SELECT iddisciplinacursada, instituicaoorigem, curso, disciplina, creditos, horascursadas FROM disciplinacursada;";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DisciplinaCursada> disciplinaCursadas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                DisciplinaCursada disciplinaCursada = new DisciplinaCursada();

                DispensaDisciplinaDAO dao = new DispensaDisciplinaDAO();
                DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
                DispensaDisciplina buscarDispensaDisciplina = null;

                disciplinaCursada.setIdDisciplinaCursada(rs.getLong("iddisciplinaCursada"));
                disciplinaCursada.setInstituicaoOrigem(rs.getString("instituicaoorigem"));
                disciplinaCursada.setCurso(rs.getString("curso"));
                disciplinaCursada.setDisciplina(rs.getString("disciplina"));
                disciplinaCursada.setCreditos(rs.getString("creditos"));
                disciplinaCursada.setHorasCursadas(rs.getString("horascursadas"));

//                dispensaDisciplina.setIdDispensaDisciplina(rs.getLong("dispensadisciplina_fk"));
                buscarDispensaDisciplina = dao.selectID(dispensaDisciplina);
//                disciplinaCursada.setDispensaDisciplina(buscarDispensaDisciplina);

                disciplinaCursadas.add(disciplinaCursada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinaCursadas;
    }

    public List<DisciplinaCursada> selectDisciplinasCursadasDoAluno(Aluno aluno) {
        con = ConnectionFactory.getConnection();
        String sql = "select iddisciplinacursada,instituicaoorigem,curso,disciplina,creditos,horascursadas from disciplinacursada dc\n"
                + "join disciplina_cursada_aluno dca on dca.id_disciplina_cursada=dc.iddisciplinacursada\n"
                + "where dca.id_aluno = ?\n"
                + "order by disciplina";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DisciplinaCursada> disciplinaCursadas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, aluno.getIdAluno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                DisciplinaCursada disciplinaCursada = new DisciplinaCursada();
                disciplinaCursada.setIdDisciplinaCursada(rs.getLong("iddisciplinaCursada"));
                disciplinaCursada.setInstituicaoOrigem(rs.getString("instituicaoorigem"));
                disciplinaCursada.setCurso(rs.getString("curso"));
                disciplinaCursada.setDisciplina(rs.getString("disciplina"));
                disciplinaCursada.setCreditos(rs.getString("creditos"));
                disciplinaCursada.setHorasCursadas(rs.getString("horascursadas"));

                disciplinaCursadas.add(disciplinaCursada);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaCursadaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return disciplinaCursadas;
    }
    
    public Aluno getIdAlunoFromUsuario(Usuario usuario){
        Aluno aluno = new Aluno();
        String sql = "select * from aluno a where a.idusuario_fk = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, usuario.getIdUsuario());
            stmt.executeQuery();
            rs = stmt.getResultSet();
            while (rs.next()) {
                aluno.setIdAluno(rs.getLong(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return aluno;
    }
}
