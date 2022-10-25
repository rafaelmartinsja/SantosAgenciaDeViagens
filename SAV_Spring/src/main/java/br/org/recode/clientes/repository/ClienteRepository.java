package br.org.recode.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.org.recode.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}