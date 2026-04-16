package cl.materialapi.generaMaterial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.materialapi.generaMaterial.service.Generadores.MRU.EnunciadoMRU;
import cl.materialapi.generaMaterial.service.Generadores.MRU.GeneradorValoresMRU;

@RestController
@RequestMapping("api/v1/mru")
public class MRUController {

    @Autowired
    EnunciadoMRU enunciado;
    
    @PostMapping
    public ResponseEntity<?> getEjercicioMRU(@RequestBody GeneradorValoresMRU gen){
        
        return ResponseEntity.ok(enunciado.generarEnunciado(gen));
    }
}
