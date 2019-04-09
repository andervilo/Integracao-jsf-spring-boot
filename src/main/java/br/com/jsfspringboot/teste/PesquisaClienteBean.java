package br.com.jsfspringboot.teste;

import java.util.Collection;
import java.util.Collections;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("view")
public class PesquisaClienteBean {

    private Collection<Cliente> clientes = Collections.emptyList();

    @Autowired
    private ClienteService clienteService;

    @PostConstruct
    public void postConstruct() {
        clientes = clienteService.pesquisar();
    }

    public Collection<Cliente> getClientes() {
        return clientes;
    }
}
