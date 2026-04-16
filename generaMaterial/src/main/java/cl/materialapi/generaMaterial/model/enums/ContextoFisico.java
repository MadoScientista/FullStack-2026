package cl.materialapi.generaMaterial.model.enums;

public enum ContextoFisico {
    PERSONA("Persona", 2, 10, 10, 50),
    AUTOMOVIL("Automovil", 10, 30, 100, 1000),
    TREN("Tren", 20, 50, 1000, 4000),
    AVION("Avión", 40, 230, 5000, 10000),
    BALA("Bala", 85, 110, 400, 2000);

    private String nombre;
    private int vMin;
    private int vMax;
    private int xMin;
    private int xMax;

    private ContextoFisico(String nombre, int vMin, int vMax, int xMin, int xMax){
        this.nombre = nombre;
        this.vMin = vMin;
        this.vMax = vMax;
        this.xMin = xMin;
        this.xMax = xMax;
    }

    public String getNombre(){return nombre;}
    public int getVMin(){return vMin;}
    public int getVMax(){return vMax;}
    public int getXMin(){return xMin;}
    public int getXMax(){return xMax;}
    
}
