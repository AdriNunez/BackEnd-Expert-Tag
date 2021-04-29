package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private String creador;

    @ManyToMany(mappedBy="etiquetas", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Expert> expertos = new ArrayList<>();

    public Tag() {
    }

    public Tag(String nombre, LocalDateTime created_at, LocalDateTime updated_at, String creador) {
        this.nombre = nombre;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.creador= creador;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
