package br.edu.fafic.model;

public class Login {

    private Long idLogin;
    private String email;
    private String senha;
    private Usuario usuario;

    public Login() {
    }

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Login{" + "idLogin=" + idLogin + ", email=" + email + ", senha=" + senha + ", usuario=" + usuario.toString() + '}';
    }

}
