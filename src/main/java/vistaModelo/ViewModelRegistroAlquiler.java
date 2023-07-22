package vistaModelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import modelo.BusinessLogicRegistroAlquiler;
import pojo.Bicicleta;
import pojo.Carro;
import pojo.Cliente;
import pojo.Moto;
import pojo.RegistroAlquiler;
import pojo.Vehiculo;

public class ViewModelRegistroAlquiler {
    private BusinessLogicRegistroAlquiler modeloRegistroAlquiler;

    public ViewModelRegistroAlquiler() {
    }
    
    public void setModeloRegistroAlquiler(BusinessLogicRegistroAlquiler modeloRegistroAlquiler) {
        this.modeloRegistroAlquiler = modeloRegistroAlquiler;
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
    
    public void alquilar() {
        modeloRegistroAlquiler.alquilar();
    }
    
    public List<Carro> getListaCarros() {
        List<Carro> listaCarros = new ArrayList<>();
            for (Vehiculo vehiculo : modeloRegistroAlquiler.getListaVehiculos()) {
                if (vehiculo instanceof Carro carro) {
                    listaCarros.add(carro);
                }
            }
        return listaCarros;
    }
    
    public List<Moto> getListaMotos() {
        List<Moto> listaMotos = new ArrayList<>();
        for (Vehiculo vehiculo : modeloRegistroAlquiler.getListaVehiculos()) {
                if (vehiculo instanceof Moto moto) {
                    listaMotos.add(moto);
                }
            }
        return listaMotos;
    }
    
    public List<Bicicleta> getListaBicicletas() {
        List<Bicicleta> listaBicicleta = new ArrayList<>();
        for (Vehiculo vehiculo : modeloRegistroAlquiler.getListaVehiculos()) {
                if (vehiculo instanceof Bicicleta bicicleta) {
                    listaBicicleta.add(bicicleta);
                }
            }
        return listaBicicleta;
    }
    
    public List<RegistroAlquiler> getListaRegistrosAquileres() {
        return modeloRegistroAlquiler.getListaRegistrosAlquileres();
    }
    
}
