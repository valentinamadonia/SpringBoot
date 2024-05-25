package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.entity.Nota;
import spring.service.NotaService;

@RestController
@RequestMapping("/v1")
public class NotaController {
    
    @Autowired
    @Qualifier("servicio")
    NotaService service;
    
   
    @PutMapping("/nota")
    public boolean agregarNota(@RequestBody Nota nota){
        return service.crear(nota);
    }
}
