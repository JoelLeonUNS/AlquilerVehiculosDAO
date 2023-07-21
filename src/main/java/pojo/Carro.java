package pojo;

public class Carro extends Vehiculo{

    private Categoria categoria;
    
    public Carro() {
        super.setPrecioHora(categoria.getPrecio());
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
