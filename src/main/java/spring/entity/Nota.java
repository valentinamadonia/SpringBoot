/*
Con la entidad se trabaja en los repositorios
 */
package spring.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Table(name="NOTA")
@Entity
public class Nota implements Serializable{
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id_nota")
    private long id;
    
    private String nombre;
    
    private String titulo;
    
    private String contenido;

    public Nota() {
    }

    public Nota(long id, String nombre, String titulo, String contenido) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    
}
