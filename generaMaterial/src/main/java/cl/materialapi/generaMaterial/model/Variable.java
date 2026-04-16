package cl.materialapi.generaMaterial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Variable {
    private double valor;
    private String unidad;
}
