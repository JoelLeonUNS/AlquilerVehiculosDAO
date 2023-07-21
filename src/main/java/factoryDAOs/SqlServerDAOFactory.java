package factoryDAOs;

import DAOs.ClienteDAO;
import DAOs.RegistroDAO;
import DAOs.VehiculoDAO;
import conexiones.SqlServerConexion;
import sqlServerDAOs.SqlServerClienteDAO;
import sqlServerDAOs.SqlServerRegistroAlquilerDAO;
import sqlServerDAOs.SqlServerVehiculoDAO;

public class SqlServerDAOFactory extends DAOFactory {

    @Override
    public VehiculoDAO getVehiculo() {
        SqlServerVehiculoDAO vehiculoDAO = new SqlServerVehiculoDAO();
        vehiculoDAO.setConector(SqlServerConexion.getInstance());
        return vehiculoDAO;
    }

    @Override
    public RegistroDAO getRegistro() {
        SqlServerRegistroAlquilerDAO registroDAO = new SqlServerRegistroAlquilerDAO();
        registroDAO.setConector(SqlServerConexion.getInstance());
        return registroDAO;
    }

    @Override
    public ClienteDAO getCliente() {
        SqlServerClienteDAO clienteDAO = new SqlServerClienteDAO();
        clienteDAO.setConector(SqlServerConexion.getInstance());
        return clienteDAO;
    }

    
}
