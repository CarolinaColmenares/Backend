package com.example.apirest.demo.entity;


import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "libro")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Libro {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titulo;

        private String autor;

        private String editorial;

        private LocalDate fechapublicacion;

        private String genero;

        private String descripcion;

        private double precio;

        private int stockdisponible;


    public void setId(Long id) {
    }
}
