/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.dao;

import br.edu.fafic.model.Usuario;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Silas
 */
public class UsuarioDAOTest {

    public UsuarioDAOTest() {
    }

    @Ignore
    @Test
    public void testInsert() {
        System.out.println("insert");

        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();

        usuario.setBairro("bairro");
        usuario.setCep("cep");
        usuario.setCidade("cidade");
        usuario.setCpf("cpf");
        usuario.setEndereco("endereco");
        usuario.setEstado("estado");
        usuario.setNome("nome");
        usuario.setPerfil("perfil");

        boolean expResult = true;
        boolean result = dao.insert(usuario);

        assertEquals(result, expResult);
    }

    @Ignore
    @Test
    public void testUpdate() {
        System.out.println("update");

        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();

        Long id = Long.parseLong("24");

        usuario.setIdUsuario(id);
        usuario.setBairro("teste");
        usuario.setCep("teste");
        usuario.setCidade("teste");
        usuario.setCpf("teste");
        usuario.setEndereco("teste");
        usuario.setEstado("teste");
        usuario.setNome("teste");
        usuario.setPerfil("teste");

        boolean expResult = true;
        boolean result = dao.update(usuario);

        assertEquals(result, expResult);
    }

    @Ignore
    @Test
    public void testDelete() {
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();

        Long id = Long.parseLong("23");
        usuario.setIdUsuario(id);

        boolean expResult = true;
        boolean result = dao.delete(usuario);

        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testSelect() {
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();

        Long id = Long.parseLong("25");
        usuario.setIdUsuario(id);

        boolean expResult = true;
        Usuario result = dao.selectID(usuario);
        boolean resultado;
        if (result.getIdUsuario() == 25) {
            resultado = true;
        } else {
            resultado = false;
        }

        assertEquals(expResult, resultado);
    }

}
