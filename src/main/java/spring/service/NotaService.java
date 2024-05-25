package spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.converter.Convertidor;
import spring.entity.Nota;
import spring.model.MNota;
import spring.repository.NotaRepositorio;

@Service("servicio")
public class NotaService {
    
    // Inyeccion bean del repositorio
    @Autowired 
    @Qualifier("repositorio")
    private NotaRepositorio repositorio;
    
    // Inyeccion bean del convertidor
    @Autowired 
    @Qualifier("convertidor")
    private Convertidor convertidor;
    
    public boolean crear(Nota nota){
        try{
            repositorio.save(nota);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean actualizar(Nota nota){
        try{
            Nota notaExist = repositorio.findByNombreAndId(nota.getNombre(), nota.getId());
            repositorio.save(nota);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean borrar(String nombre, long id){
        try{
            Nota nota = repositorio.findByNombreAndId(nombre, id);
            repositorio.delete(nota);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public List<MNota> obtener(){
        return convertidor.convertirLista(repositorio.findAll());
    }
    
    public MNota obtenerPorId(long id){
        return new MNota(repositorio.findById(id));
    }
    
    public MNota obtenerPorNombreTitulo(String nombre, String titulo){
        return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
    }
    
    public List<MNota> obtenerPorTitulo(String titulo){
        return convertidor.convertirLista(repositorio.findByTitulo(titulo));
    }
    
}
