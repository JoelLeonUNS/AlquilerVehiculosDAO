package pojo;

public enum Categoria {
    A(1, "A", 18.0),
    B(2, "B", 14.0),
    C(3, "C",10.0);
  
    private final int id;
    private final String nombre;
    private final double precio;

    private Categoria(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
