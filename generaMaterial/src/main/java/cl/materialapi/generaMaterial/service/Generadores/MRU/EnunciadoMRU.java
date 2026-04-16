package cl.materialapi.generaMaterial.service.Generadores.MRU;

import java.util.Map;

import org.springframework.stereotype.Service;

import cl.materialapi.generaMaterial.model.Variable;


@Service
public class EnunciadoMRU {
    private String enunciado;
    
    GeneradorValoresMRU gen = new GeneradorValoresMRU();
    
    // Calcular X
    // public String generarEnunciado(GeneradorValoresMRU gen){
    //     Map<String, Variable> res = gen.generarValores();
    //     enunciado = String.format(
    //         "Una persona se encuentre en una posición inicial %f %s, luego de camina a una velocidad constante de %f %s durante %f %s. \nCalcule la posición final \nrespuesta: x = %f %s", 
    //         res.get("x0").getValor(),
    //         res.get("x0").getUnidad(), 
    //         res.get("v").getValor(), 
    //         res.get("v").getUnidad(), 
    //         res.get("t").getValor(),
    //         res.get("t").getUnidad(),  
    //         res.get("x").getValor(),
    //         res.get("x").getUnidad());
    //     return enunciado;
    // }

    // Calcular V
    public String generarEnunciado(GeneradorValoresMRU gen){
        Map<String, Variable> res = gen.generarValores();
        enunciado = String.format(
            "Una persona se encuentre en una posición inicial %f %s y se mueve hasta una posición final %f %s en %f %s. \nCalcule la velocidad. \nrespuesta: v = %f %s", 
            res.get("x0").getValor(),
            res.get("x0").getUnidad(), 
            res.get("x").getValor(), 
            res.get("x").getUnidad(), 
            res.get("t").getValor(),
            res.get("t").getUnidad(),  
            res.get("v").getValor(),
            res.get("v").getUnidad());
        return enunciado;
    }
}
