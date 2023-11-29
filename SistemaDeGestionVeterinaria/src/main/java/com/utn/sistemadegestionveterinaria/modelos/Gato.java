package com.utn.sistemadegestionveterinaria.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Table(name = "gatos")
@Getter
@Setter
public class Gato extends Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String especie;
    @Column
    private String raza;

    @ManyToOne
    @JoinColumn(name = "turno_id")
    private Turno turno;

    public Gato() {
        this.especie = "Gato";
    }

    @Override
    public String toString() {
        return "Gato {" +
                "id: " + id +
                ", nombre: " + nombre +
                ", especie: " + especie +
                ", raza: " + raza + '}';
    }
}
