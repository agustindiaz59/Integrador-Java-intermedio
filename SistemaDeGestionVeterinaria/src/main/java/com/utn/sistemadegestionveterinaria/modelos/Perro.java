package com.utn.sistemadegestionveterinaria.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "perro")
@AllArgsConstructor
@Getter
@Setter
public class Perro extends Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String especie;
    @Column
    private String raza;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turno_id")
    private Turno turno;

    public Perro() {
        this.especie = "Perro";
    }

    @Override
    public String toString() {
        return "Perro {" +
                "id: " + id +
                ", nombre: " + nombre +
                ", especie: " + especie +
                ", raza: " + raza + '}';
    }
}
