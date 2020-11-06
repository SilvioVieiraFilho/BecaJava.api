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

import br.biblioteca.app.model.Editora;
import br.biblioteca.app.service.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

	private final EditoraService _service;

	public EditoraController(EditoraService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity criar(@RequestBody Editora editora) {
		try {
			_service.criar(editora);
			return ResponseEntity.status(HttpStatus.CREATED).body("Editora inserido com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}

	}

	@GetMapping
	public ResponseEntity listar() {

		try {
			Iterable<Editora> editora = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(editora);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");

		}

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity listar(@PathVariable Long id) {

		try {
			Optional<Editora> editora = _service.listar(id);
			return ResponseEntity.status(HttpStatus.OK).body(editora);
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dados não foram inseridos");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Editora editora, @PathVariable Long id) {
		try {
			_service.atualizar(editora, id);
			return ResponseEntity.status(HttpStatus.OK).body("Editora atualizado com sucesso!");
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
