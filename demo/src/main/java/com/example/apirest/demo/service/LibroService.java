package com.example.apirest.demo.service;

import com.example.apirest.demo.entity.Libro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LibroService {

    Optional<Libro> getLibroById(Long id);

    Libro saveLibro(Libro libro);

    void deleteLibro(Long id);

    Optional<Libro> updateLibro(Long id, Libro libroActualizado);

    List<Libro> findAllLibros();

    List<Libro> getLibroByAutor(String autor);

}