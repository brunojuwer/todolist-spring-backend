package br.com.springbootcrud.springbootrestapisample.repository;

import br.com.springbootcrud.springbootrestapisample.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
