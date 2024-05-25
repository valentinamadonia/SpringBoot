/*
* Peticiones a la base de datos
*/
package spring.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.entity.Nota;

@Repository("repositorio")
public interface NotaRepositorio extends JpaRepository<Nota, Serializable>{
    
    public abstract Nota findById(long id);
    public abstract Nota findByNombre(String nombre);
    public abstract List<Nota> findByTitulo(String titulo);
    public abstract Nota findByNombreAndTitulo(String nombre, String titulo);
    public abstract Nota findByNombreAndId(String nombre, long id);
}
