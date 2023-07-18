package pojo;

public enum Categoria {
    A("A", 18.0),
    B("B", 14.0),
    C("C",10.0);
    
    private final String nombre;
    private final double precio;

    private Categoria(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
