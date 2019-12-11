/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import br.edu.fafic.dao.AlunoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fafic.dao.DisciplinaCursadaDAO;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.DisciplinaCursada;
import br.edu.fafic.model.Usuario;

/**
 *
 * @author Silas
 */
@WebServlet("/disciplinaCursada")
public class ServletDisciplinaCursada extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String instituicaoOrigem = req.getParameter("instituicaoOrigem");
        String curso = req.getParameter("curso");
        String disciplina = req.getParameter("disciplina");
        String creditos = req.getParameter("creditos");
        String horasCursadas = req.getParameter("horasCursadas");

        DisciplinaCursadaDAO dao = new DisciplinaCursadaDAO();
        DisciplinaCursada disciplinaCursada;
        String param = req.getParameter("param");
        Usuario u = (Usuario) req.getSession().getAttribute("usuario");
        AlunoDAO alunoDao = new AlunoDAO();
        Aluno al = alunoDao.getIdAlunoFromUsuario(u);
               
        if(param == null){
             req.setAttribute("disciplinasCursadas",dao.selectDisciplinasCursadasDoAluno(al));
             req.getRequestDispatcher("/aluno/listar-disciplina-cursada.jsp").forward(req, resp);
        }

        if (param.equals("cadastrar")) {
            try {
                disciplinaCursada = new DisciplinaCursada();
                disciplinaCursada.setInstituicaoOrigem(instituicaoOrigem);
                disciplinaCursada.setCurso(curso);
                disciplinaCursada.setDisciplina(disciplina);
                disciplinaCursada.setCreditos(creditos);
                disciplinaCursada.setHorasCursadas(horasCursadas);
                Long idDisciplinaCursada = dao.insertById(disciplinaCursada);
//                Aluno a = alunoDao.getIdAlunoFromUsuario(u);
                dao.insertDisciplinaCursadaAluno(idDisciplinaCursada, al.getIdAluno());
                req.setAttribute("message", "Operação realizada com sucesso!");
                req.setAttribute("classe", "alert alert-success alert-dismissible fade show");
                
            } catch (Exception ex) {
                
                req.setAttribute("message", "Erro ao salvar!");
                req.setAttribute("classe", "alert alert-warning alert-dismissible fade show");
                
            }finally{
                 req.getRequestDispatcher("/aluno/cadastrar-disciplina-cursada.jsp").forward(req, resp);
            }

           
           

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            disciplinaCursada = new DisciplinaCursada();
            disciplinaCursada.setIdDisciplinaCursada(id);
            disciplinaCursada = dao.selectID(disciplinaCursada);
            System.out.println(disciplinaCursada.getCurso());
            req.getSession().setAttribute("sDisciplinaCursada", disciplinaCursada);
            req.getRequestDispatcher("aluno/alterar-disciplina-cursada.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            disciplinaCursada = new DisciplinaCursada();
            disciplinaCursada.setInstituicaoOrigem(instituicaoOrigem);
            disciplinaCursada.setCurso(curso);
            disciplinaCursada.setDisciplina(disciplina);
            disciplinaCursada.setCreditos(creditos);
            disciplinaCursada.setHorasCursadas(horasCursadas);
            disciplinaCursada.setIdDisciplinaCursada(id);
            dao.update(disciplinaCursada);
            resp.sendRedirect("aluno/listar-disciplina-cursada.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            disciplinaCursada = new DisciplinaCursada();
            disciplinaCursada.setIdDisciplinaCursada(id);
            dao.delete(disciplinaCursada);
            resp.sendRedirect("aluno/listar-disciplina-cursada.jsp");
        }
    }
}
