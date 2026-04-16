package cl.materialapi.generaMaterial.utilidades;

import java.util.Random;

import cl.materialapi.generaMaterial.model.Variable;
import cl.materialapi.generaMaterial.model.enums.Conversion;

public class UtilidadVariables {

    private static Random random = new Random();

    public UtilidadVariables(){

    }

    public static Variable convertirUnidad(Variable variable, Conversion tipo){        
        
        return new Variable(
            variable.getValor()*tipo.getFactorConversion(),
            tipo.getUnidadSalida()
        );
    }

    public static Variable randomInt(Variable variable, int min, int max, boolean positivo){
        Variable nuevaVariable = new Variable();

        int numeroRandom = random.nextInt((max - min + 1)) + min;
        nuevaVariable.setValor(numeroRandom);

        nuevaVariable.setValor((positivo) ? nuevaVariable.getValor(): nuevaVariable.getValor()*-1);
        nuevaVariable.setUnidad(variable.getUnidad());
        

        return nuevaVariable;   
    }

    public static Variable randomDouble(Variable variable, int min, int max, boolean positivo, int nDecimales){
        Variable nuevaVariable = new Variable();

        double numeroRandom = random.nextDouble(((max - min) + min+1));
        double decimalRandom = Math.round(numeroRandom*Math.pow(10, nDecimales))/Math.pow(10, nDecimales);

        nuevaVariable.setValor(decimalRandom);
        
        nuevaVariable.setUnidad(variable.getUnidad());
        nuevaVariable.setValor((positivo) ? nuevaVariable.getValor(): nuevaVariable.getValor()*-1);

        return nuevaVariable;   
    }

    public static boolean comprobarDecimales(Variable variable, int nDecimales){

        double n = variable.getValor()*Math.pow(10, nDecimales);
        double n_ceil = Math.ceil(variable.getValor()*Math.pow(10, nDecimales));
        boolean correcto = (n_ceil - n) == 0;

        return correcto;
    }
}
