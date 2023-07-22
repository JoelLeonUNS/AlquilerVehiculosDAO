package pojo;

import java.time.LocalTime;

public class RegistroAlquiler {
    private int id;
    LocalTime horaRecogida;
    private int cantidadHoras;
    private Cliente cliente;
    private Vehiculo vehiculo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHoraRecogida() {
        return horaRecogida;
    }

    public void setHoraRecogida(LocalTime horaRecogida) {
        this.horaRecogida = horaRecogida;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return " " + id;
    }    
}
