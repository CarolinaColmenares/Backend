package com.example.apirest.demo.controller;

import com.example.apirest.demo.entity.Libro;
import com.example.apirest.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")

public class LibroController {
    @Autowired
    LibroService libroService;


    @GetMapping("/obtenerlibro")
    public ResponseEntity<Libro> obtenerLibroById(@RequestParam("id")Long id){
        Libro libro = libroService.getLibroById(id).orElseThrow(()-> new ModelNotFoundException( "Libro No Encontrado $id"  ));
        return new ResponseEntity<Libro>(libro, HttpStatus.OK);
    }

    @PostMapping("/guardarlibro")
    public ResponseEntity<Libro> saveLibro(@RequestBody Libro libro) {
        Libro guardarlibro = libroService.saveLibro(libro);
        return new ResponseEntity<Libro>(guardarlibro, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletelibro/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id) {
        Optional<Libro> libro = libroService.getLibroById(id);
        if (libro.isPresent()) {
            libroService.deleteLibro(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatelibro/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable(value = "id") Long id,
                                             @RequestBody Libro libroActualizado) {
        Optional<Libro> libro = libroService.updateLibro(id, libroActualizado);
        if (libro.isPresent()) {
            return ResponseEntity.ok(libro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Libro>> findAllLibros() {
        List<Libro> libros = libroService.findAllLibros();
        if (libros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/obtenerlibroautor")
    public ResponseEntity<List<Libro>> obtenerLibroByAutor(@RequestParam("autor")String autor){
        List<Libro> librosAutor = libroService.getLibroByAutor(autor);
        return new ResponseEntity<>(librosAutor, HttpStatus.OK);
    }


}
cdd