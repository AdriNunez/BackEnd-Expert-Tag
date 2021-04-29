package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private String estado_motivo;

    private String disponibilidad;

    private String modalidad;

    private String autonomo;

    private Long contacto_telefono;

    private String contacto_email;

    private String contacto_ciudad;

    private Double condiciones_porcentaje;

    private Double condiciones_precio_hora;

    private Integer puntuacion;

    private String nif;

    private String credenciales_correo;

    private String credenciales_correo_password;

    private String credenciales_zoom_password;

    private String fichero_foto;

    private String fichero_cv;

    private String observaciones;

    private String origen;

    @Column(name ="estado")
    private String estado;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "expertos_etiquetas",
            joinColumns = {@JoinColumn(name="expert_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="tag_id", referencedColumnName = "id")}
    )
    private List<Tag> etiquetas = new ArrayList<>();

    public Expert() {
    }

    public Expert(String nombre, LocalDateTime created_at, LocalDateTime updated_at, String estado_motivo, String disponibilidad, String modalidad, String autonomo,
                  Long contacto_telefono, String contacto_email, String contacto_ciudad, Double condiciones_porcentaje, Double condiciones_precio_hora,
                  Integer puntuacion, String nif, String credenciales_correo, String credenciales_correo_password, String credenciales_zoom_password,
                  String fichero_foto, String fichero_cv, String observaciones, String origen, String estado) {

        this.nombre = nombre;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.estado_motivo = estado_motivo;
        this.disponibilidad = disponibilidad;
        this.modalidad = modalidad;
        this.autonomo = autonomo;
        this.contacto_telefono = contacto_telefono;
        this.contacto_email = contacto_email;
        this.contacto_ciudad = contacto_ciudad;
        this.condiciones_porcentaje = condiciones_porcentaje;
        this.condiciones_precio_hora = condiciones_precio_hora;
        this.puntuacion = puntuacion;
        this.nif = nif;
        this.credenciales_correo = credenciales_correo;
        this.credenciales_correo_password = credenciales_correo_password;
        this.credenciales_zoom_password = credenciales_zoom_password;
        this.fichero_foto = fichero_foto;
        this.fichero_cv = fichero_cv;
        this.observaciones = observaciones;
        this.origen = origen;
        this.estado = estado;
    }

    public List<Tag> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
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

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getEstado_motivo() {
        return estado_motivo;
    }

    public void setEstado_motivo(String estado_motivo) {
        this.estado_motivo = estado_motivo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getAutonomo() {
        return autonomo;
    }

    public void setAutonomo(String autonomo) {
        this.autonomo = autonomo;
    }

    public Long getContacto_telefono() {
        return contacto_telefono;
    }

    public void setContacto_telefono(Long contacto_telefono) {
        this.contacto_telefono = contacto_telefono;
    }

    public String getContacto_email() {
        return contacto_email;
    }

    public void setContacto_email(String contacto_email) {
        this.contacto_email = contacto_email;
    }

    public String getContacto_ciudad() {
        return contacto_ciudad;
    }

    public void setContacto_ciudad(String contacto_ciudad) {
        this.contacto_ciudad = contacto_ciudad;
    }

    public Double getCondiciones_porcentaje() {
        return condiciones_porcentaje;
    }

    public void setCondiciones_porcentaje(Double condiciones_porcentaje) {
        this.condiciones_porcentaje = condiciones_porcentaje;
    }

    public Double getCondiciones_precio_hora() {
        return condiciones_precio_hora;
    }

    public void setCondiciones_precio_hora(Double condiciones_precio_hora) {
        this.condiciones_precio_hora = condiciones_precio_hora;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCredenciales_correo() {
        return credenciales_correo;
    }

    public void setCredenciales_correo(String credenciales_correo) {
        this.credenciales_correo = credenciales_correo;
    }

    public String getCredenciales_correo_password() {
        return credenciales_correo_password;
    }

    public void setCredenciales_correo_password(String credenciales_correo_password) {
        this.credenciales_correo_password = credenciales_correo_password;
    }

    public String getCredenciales_zoom_password() {
        return credenciales_zoom_password;
    }

    public void setCredenciales_zoom_password(String credenciales_zoom_password) {
        this.credenciales_zoom_password = credenciales_zoom_password;
    }

    public String getFichero_foto() {
        return fichero_foto;
    }

    public void setFichero_foto(String fichero_foto) {
        this.fichero_foto = fichero_foto;
    }

    public String getFichero_cv() {
        return fichero_cv;
    }

    public void setFichero_cv(String fichero_cv) {
        this.fichero_cv = fichero_cv;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Expert{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", estado_motivo='" + estado_motivo + '\'' +
                ", disponibilidad='" + disponibilidad + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", autonomo='" + autonomo + '\'' +
                ", contacto_telefono=" + contacto_telefono +
                ", contacto_email='" + contacto_email + '\'' +
                ", contacto_ciudad='" + contacto_ciudad + '\'' +
                ", condiciones_porcentaje=" + condiciones_porcentaje +
                ", condiciones_precio_hora=" + condiciones_precio_hora +
                ", puntuacion=" + puntuacion +
                ", nif='" + nif + '\'' +
                ", credenciales_correo='" + credenciales_correo + '\'' +
                ", credenciales_correo_password='" + credenciales_correo_password + '\'' +
                ", credenciales_zoom_password='" + credenciales_zoom_password + '\'' +
                ", fichero_foto='" + fichero_foto + '\'' +
                ", fichero_cv='" + fichero_cv + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", origen='" + origen + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
