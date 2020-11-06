package br.biblioteca.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.app.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

}