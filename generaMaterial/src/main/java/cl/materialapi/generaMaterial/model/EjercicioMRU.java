package cl.materialapi.generaMaterial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EjercicioMRU {

    private Variable x;
    private Variable x0;
    private Variable v;
    private Variable t;

    private String enunciado;
    private Variable resultado;

    
}
