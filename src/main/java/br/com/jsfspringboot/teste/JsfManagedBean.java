package br.com.jsfspringboot.teste;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class JsfManagedBean {

    private String titulo = "O managed bean desta página está anotado com @ManagedBean, ou seja, podemos ter beans JSF e Spring em um mesmo projeto!";

    @Autowired
    private ClienteService clienteService;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }
}
