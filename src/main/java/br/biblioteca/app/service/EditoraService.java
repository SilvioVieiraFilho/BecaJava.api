package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.biblioteca.app.model.Editora;
import br.biblioteca.app.repository.EditoraRepository;

@Service
public class EditoraService{
	
	
	final EditoraRepository _repository;

	// @Autowired
	
	public EditoraService(EditoraRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Editora Editora) {

		Editora.setId_editora(new Long(0));
		_repository.save(Editora);
	}

	// Listar Todos
	public List<Editora> listar() {
		return _repository.findAll();

	}

	// Listar Somente Um
	public Optional<Editora> listar(Long id) {
		return _repository.findById(id);

	}

	// Atualizar dados
	public void atualizar(Editora Editora, Long id) {

		Editora.setId_editora(id);
		_repository.save(Editora);
	}

	// Deletar Dados
	public void deletar(Long id) {
		_repository.deleteById(id);
	}

}


	
	
	
	
	
	
	

