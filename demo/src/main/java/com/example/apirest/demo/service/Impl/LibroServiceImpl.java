package com.example.apirest.demo.service.Impl;

import com.example.apirest.demo.entity.Libro;
import com.example.apirest.demo.repository.LibroRepository;
import com.example.apirest.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroRepository libroRepository;

    @Override
    public Optional<Libro> getLibroById(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    @Override
    public Optional<Libro> updateLibro(Long id, Libro libroActualizado) {
        Optional<Libro> libroExistente = libroRepository.findById(id);
        if (libroExistente.isPresent()) {
            Libro libro = libroExistente.get();
            libro.setAutor(libroActualizado.getAutor());
            libro.setDescripcion(libroActualizado.getDescripcion());
            libro.setEditorial(libroActualizado.getEditorial());
            libro.setFechapublicacion(libroActualizado.getFechapublicacion());
            libro.setGenero(libroActualizado.getGenero());
            libro.setPrecio(libroActualizado.getPrecio());
            libro.setStockdisponible(libroActualizado.getStockdisponible());
            libro.setTitulo(libroActualizado.getTitulo());

            return Optional.of(libroRepository.save(libro));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public List<Libro> findAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public List<Libro> getLibroByAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

}
