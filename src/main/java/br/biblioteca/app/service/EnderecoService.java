package br.biblioteca.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.biblioteca.app.model.Endereco;
import br.biblioteca.app.repository.EnderecoRepository;

@Service
public class EnderecoService{
	
	
	final EnderecoRepository _repository;

	// @Autowired
	
	public EnderecoService(EnderecoRepository repository) {
		_repository = repository;
	}

	// Inserir
	public void criar(Endereco endereco) {

		endereco.setId_endereco(new Long(0));
		_repository.save(endereco);
	}

	// Listar Todos
	public List<Endereco> listar() {
		return _repository.findAll();

	}

	// Listar Somente Um
	public Optional<Endereco> listar(Long id) {
		return _repository.findById(id);

	}

	// Atualizar dados
	public void atualizar(Endereco endereco, Long id) {

		endereco.setId_endereco(id);
		_repository.save(endereco);
	}

	// Deletar Dados
	public void deletar(Long id) {
		_repository.deleteById(id);
	}

}


	
	
	
	
	
	
	

