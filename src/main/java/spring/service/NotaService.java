package spring.service;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
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
    
    private static final Log logger = LogFactory.getLog(NotaService.class);
    
    public boolean crear(Nota nota){
        try{
            repositorio.save(nota);
            logger.info("NOTA CREADA");
            return true;
        }catch(Exception e){
            logger.error("ERROR AL CREAR NOTA");
            return false;
        }
    }
    
    public boolean actualizar(Nota nota){
        try{
            repositorio.save(nota);
            logger.info("NOTA ACTUALIZADA");
            return true;
        }catch(Exception e){
            logger.error("ERROR AL ACTUALIZAR NOTA");
            return false;
        }
    }
    
    public boolean borrar(String nombre, long id){
        logger.warn("BORRANDO NOTA");
        try{
            Nota nota = repositorio.findByNombreAndId(nombre, id);
            repositorio.delete(nota);
            logger.info("NOTA BORRADA");
            return true;
        }catch(Exception e){
            logger.error("ERROR AL BORRAR NOTA");
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
    
    public List<MNota> obtenerPorPaginacion(Pageable pageable){
        return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
    }
    
}
