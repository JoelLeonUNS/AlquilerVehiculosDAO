package modelo;

import factoryDAOs.DAOFactory;
import factoryDAOs.SqlServerDAOFactory;
import java.util.List;
import pojo.Cliente;
import pojo.RegistroAlquiler;
import pojo.Vehiculo;

public class BusinessLogicRegistroAlquiler {
    private RegistroAlquiler registroAlquiler;
    private DAOFactory dao;

    public BusinessLogicRegistroAlquiler() {
        this.registroAlquiler = new RegistroAlquiler();
        registroAlquiler.setCliente(new Cliente());
        registroAlquiler.setVehiculo(new Vehiculo() {});
        this.dao = new SqlServerDAOFactory(); //
    }
    
    public RegistroAlquiler getRegistroAlquiler() {
        return registroAlquiler;
    }
    
    public void alquilar() {
        dao.getRegistro().create(registroAlquiler);
    }
    
    public List<Vehiculo> getListaVehiculos() {
        return dao.getVehiculo().listed();
    }
    
    public List<RegistroAlquiler> getListaRegistrosAlquileres() {
        return dao.getRegistro().listed();
    }
}
