package factoryDAOs;

import DAOs.ClienteDAO;
import DAOs.RegistroDAO;
import DAOs.VehiculoDAO;

public abstract class DAOFactory {
    public abstract VehiculoDAO getVehiculo();
    public abstract RegistroDAO getRegistro();
    public abstract ClienteDAO getCliente();
}
