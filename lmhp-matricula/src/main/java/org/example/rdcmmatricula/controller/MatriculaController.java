package org.example.rdcmmatricula.controller;

import org.example.rdcmmatricula.entity.Matricula;
import org.example.rdcmmatricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<Matricula>> listar() {
        return ResponseEntity.ok(matriculaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> obtener(@PathVariable Integer id) {
        return matriculaService.obtener(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Matricula> registrar(@RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.registrar(matricula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        matriculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
