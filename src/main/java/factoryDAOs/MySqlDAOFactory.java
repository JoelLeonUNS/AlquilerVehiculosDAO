package factoryDAOs;

import DAOs.ClienteDAO;
import DAOs.RegistroDAO;
import DAOs.VehiculoDAO;
import conexiones.MySqlConexion;
import mySqlDAOs.MySqlClienteDAO;
import mySqlDAOs.MySqlRegistroDAO;
import mySqlDAOs.MySqlVehiculoDAO;

public class MySqlDAOFactory extends DAOFactory {

    @Override
    public VehiculoDAO getVehiculo() {
        MySqlVehiculoDAO vehiculoDAO = new MySqlVehiculoDAO();
        vehiculoDAO.setConector(MySqlConexion.getInstance());
        return vehiculoDAO;
    }

    @Override
    public RegistroDAO getRegistro() {
        MySqlRegistroDAO registroDAO = new MySqlRegistroDAO();
        registroDAO.setConector(MySqlConexion.getInstance());
        return registroDAO;
    }

    @Override
    public ClienteDAO getCliente() {
        MySqlClienteDAO clienteDAO = new MySqlClienteDAO();
        clienteDAO.setConector(MySqlConexion.getInstance());
        return clienteDAO;
    }
}
