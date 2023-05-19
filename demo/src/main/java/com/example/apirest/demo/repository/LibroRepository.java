package com.example.apirest.demo.repository;

import com.example.apirest.demo.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByAutor(String autor);

}
