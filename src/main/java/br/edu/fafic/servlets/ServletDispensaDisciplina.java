/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fafic.dao.AlunoDAO;
import br.edu.fafic.dao.DisciplinaAtualDAO;
import br.edu.fafic.dao.DisciplinaCursadaDAO;
import br.edu.fafic.dao.DisciplinaDAO;
import br.edu.fafic.dao.DispensaDisciplinaDAO;
import br.edu.fafic.dao.DispensaDisciplinaProcessoDAO;
import br.edu.fafic.dao.ProcessosDAO;
import br.edu.fafic.model.Aluno;
import br.edu.fafic.model.Disciplina;
import br.edu.fafic.model.DisciplinaAtual;
import br.edu.fafic.model.DisciplinaCursada;
import br.edu.fafic.model.DispensaDisciplina;
import br.edu.fafic.model.DispensaDisciplinaProcesso;
import br.edu.fafic.model.Processos;
import br.edu.fafic.model.Usuario;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silas
 */
@WebServlet("/dispensaDisciplina")
public class ServletDispensaDisciplina extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DispensaDisciplinaDAO dao = new DispensaDisciplinaDAO();
        DispensaDisciplina sDispensaDisciplina;
        ProcessosDAO processoDao = new ProcessosDAO();
        DisciplinaAtualDAO discicplinaAtualDao = new DisciplinaAtualDAO();
        List<Disciplina> disOfertadas = new ArrayList<>();
        List<DisciplinaCursada> disCursadas = new ArrayList<>();

        AlunoDAO daoAluno = new AlunoDAO();
        Aluno aluno = new Aluno();
        Aluno buscarAluno;

        DisciplinaCursadaDAO daoDisciplinaCursada = new DisciplinaCursadaDAO();
        DisciplinaCursada disciplinaCursada = new DisciplinaCursada();
        DisciplinaCursada buscarDisciplinaCursada;

        DisciplinaDAO daoDisciplina = new DisciplinaDAO();
        Disciplina disciplina = new Disciplina();
        Disciplina buscarDisciplina;

        String param = req.getParameter("param");
        

        if (param == null) {
            Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
            Aluno a = daoDisciplinaCursada.getIdAlunoFromUsuario(usuario);
            req.setAttribute("disciplinasCursadasDoAluno", daoDisciplinaCursada.selectDisciplinasCursadasDoAluno(a));
            req.getRequestDispatcher("/aluno/cadastrar-dispensa-disciplina.jsp").forward(req, resp);
        }

  try{
        if (param.equalsIgnoreCase("continuar")) {
            
            String [] disciplinasCursadas = req.getParameterValues("disciplina_cursada");
            String [] disciplinasOfertadas = req.getParameterValues("disciplina_ofertada");
            
             for(int i =0 ; i < disciplinasCursadas.length; i++){
                    disCursadas.add(daoDisciplinaCursada.selectDisciplinaByID(Long.valueOf(disciplinasCursadas[i])));
             }
             for(int i =0 ; i < disciplinasOfertadas.length; i++){
                    disOfertadas.add(daoDisciplina.selectDisciplinaByID(Long.valueOf(disciplinasOfertadas[i])));
             }
                  
            
            try {
                Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
                Aluno a = daoDisciplinaCursada.getIdAlunoFromUsuario(usuario);
                
                
                Processos processo = new Processos();
                processo.setAluno(a);
                processo.setTipo("Dispensa de Disciplina");
                Long idProcesso = processoDao.inserirProcesso(processo);
                Processos processoRecuperado = processoDao.selectProcessoById(idProcesso);
                
                req.getSession().setAttribute("id_processo", processoRecuperado.getIdProcessos());
                
                DispensaDisciplinaProcesso ddp = new DispensaDisciplinaProcesso();
                ddp.setProcessos(processoRecuperado);
                ddp.setDataProcesso(new Date());
                ddp.setStatus("Aberto");
                
                new DispensaDisciplinaProcessoDAO().insert(ddp);
                
                for(int i =0 ; i < disciplinasCursadas.length; i++){
                    DisciplinaAtual dAtual = new DisciplinaAtual();
                    dAtual.setDisciplinaCursada(daoDisciplinaCursada.selectDisciplinaByID(Long.valueOf(disciplinasCursadas[i])));
                    dAtual.setDisciplinaOfertada(daoDisciplina.selectDisciplinaByID(Long.valueOf(disciplinasOfertadas[i])));
                    dAtual.setProcesso(processoRecuperado);
                    discicplinaAtualDao.insert(dAtual);
                    
                }
         
                req.setAttribute("disCursadas", disCursadas);
                req.setAttribute("disOfertadas", disOfertadas);
                req.setAttribute("id_processo", idProcesso);
                req.getRequestDispatcher("aluno/upload.jsp").forward(req, resp);
            } catch (Exception ex) {
                Logger.getLogger(ServletDispensaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
                req.setAttribute("message", "Erro ao salvar!");
                req.setAttribute("classe", "alert alert-danger alert-dismissible fade show");
                req.getRequestDispatcher("/aluno/cadastrar-dispensa-disciplina.jsp").forward(req, resp);
            }

        } else if (param.equals("alterar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            DispensaDisciplina dispensaDisciplina = new DispensaDisciplina();
            dispensaDisciplina.setIdDispensaDisciplina(id);
            sDispensaDisciplina = dao.selectID(dispensaDisciplina);
            req.getSession().setAttribute("sDispensaDisciplina", sDispensaDisciplina);
            req.getRequestDispatcher("aluno/alterar-dispensa-disciplina.jsp").forward(req, resp);
        } else if (param.equalsIgnoreCase("update")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sDispensaDisciplina = new DispensaDisciplina();
            Long idAluno = Long.parseLong(req.getParameter("idAluno_FK"));
            Long idDisciplinaCursada = Long.parseLong(req.getParameter("idDisciplinaCursada_FK"));
            Long idDisciplina = Long.parseLong(req.getParameter("idDisciplina_FK"));
            sDispensaDisciplina = new DispensaDisciplina();
            sDispensaDisciplina.setIdDispensaDisciplina(id);

            aluno.setIdAluno(idAluno);
            buscarAluno = daoAluno.selectID(aluno);
            sDispensaDisciplina.setAluno(buscarAluno);

            disciplinaCursada.setIdDisciplinaCursada(idDisciplinaCursada);
            buscarDisciplinaCursada = daoDisciplinaCursada.selectID(disciplinaCursada);

            disciplina.setIdDisciplina(idDisciplina);
            buscarDisciplina = daoDisciplina.selectID(disciplina);
            dao.update(sDispensaDisciplina);
            resp.sendRedirect("aluno/listar-dispensa-disciplina.jsp");
        } else if (param.equals("apagar")) {
            Long id = Long.valueOf(req.getParameter("id"));
            sDispensaDisciplina = new DispensaDisciplina();
            sDispensaDisciplina.setIdDispensaDisciplina(id);
            dao.delete(sDispensaDisciplina);
            resp.sendRedirect("aluno/listar-dispensa-disciplina.jsp");
        }
    }catch(NullPointerException ex) {
    
        
    }
    
 }
} 
