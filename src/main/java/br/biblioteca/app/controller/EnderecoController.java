package br.biblioteca.app.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.biblioteca.app.model.Endereco;
import br.biblioteca.app.service.EnderecoService;

@RestController
@RequestMapping("/Enderecos")
public class EnderecoController {

	private final EnderecoService _service;

	public EnderecoController(EnderecoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Endereco endereco) {
		try {
			_service.criar(endereco);
			return ResponseEntity.status(HttpStatus.CREATED).body("Endereco inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}

	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<Endereco> Enderecos = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(Enderecos);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {
		try {

			Optional<Endereco> Endereco = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(Endereco);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Endereco endereco, @PathVariable Long id) {

		try {
			_service.atualizar(endereco, id);
			return ResponseEntity.status(HttpStatus.OK).body("Endereco atualizado com sucesso!");
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		try {
			_service.deletar(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}

	}
}