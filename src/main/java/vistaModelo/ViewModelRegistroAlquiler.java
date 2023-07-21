package vistaModelo;

import java.time.LocalTime;
import modelo.BusinessLogicRegistroAlquiler;
import pojo.Cliente;
import pojo.Vehiculo;

public class ViewModelRegistroAlquiler {
    private BusinessLogicRegistroAlquiler modeloRegistroAlquiler;

    public ViewModelRegistroAlquiler() {
        this.modeloRegistroAlquiler = new BusinessLogicRegistroAlquiler();
    }

    public int getId() {
        return modeloRegistroAlquiler.getRegistroAlquiler().getId();
    }

    public void setId(int id) {
        modeloRegistroAlquiler.getRegistroAlquiler().setId(id);
    }

    public LocalTime getHoraRecogida() {
        return modeloRegistroAlquiler.getRegistroAlquiler().getHoraRecogida();
    }

    public void setHoraRecogida(LocalTime horaRecogida) {
        modeloRegistroAlquiler.getRegistroAlquiler().setHoraRecogida(horaRecogida);
    }

    public int getCantidadHoras() {
        return modeloRegistroAlquiler.getRegistroAlquiler().getCantidadHoras();
    }

    public void setCantidadHoras(int cantidadHoras) {
        modeloRegistroAlquiler.getRegistroAlquiler().setCantidadHoras(cantidadHoras);
    }
    
    public Cliente getCliente() {
        return modeloRegistroAlquiler.getRegistroAlquiler().getCliente();
    }

    public void setCliente(Cliente cliente) {
        modeloRegistroAlquiler.getRegistroAlquiler().setCliente(cliente);
    }

    public Vehiculo getVehiculo() {
        return modeloRegistroAlquiler.getRegistroAlquiler().getVehiculo();
    }

    public void setVehiculo(Vehiculo vehiculo) {
        modeloRegistroAlquiler.getRegistroAlquiler().setVehiculo(vehiculo);
    }
}
