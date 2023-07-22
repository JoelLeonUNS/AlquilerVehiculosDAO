package sqlServerDAOs;

import DAOs.ClienteDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Cliente;

public class SqlServerClienteDAO extends ClienteDAO<Cliente>{

    @Override
    public Cliente create(Cliente obj) {
        try {
            setSql("INSERT INTO Cliente (nombre, DNI, fecha) VALUES (?, ?, ?)");
            setPs(getConector().prepareStatement(getSql()));
            getPs().setString(1, obj.getNombre());
            getPs().setString(2, obj.getDNI());
            getPs().setDate(3, Date.valueOf(obj.getFecha()));
            if (!exeUpdate()) obj = null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    @Override
    public Cliente delete(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente update(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente read(int id) {
        setSql("SELECT * FROM cliente WHERE idCliente = ?");
        Cliente cliente = null;
        try {
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, id);
            setRs(getPs().executeQuery());

            if (getRs().next()) {
                cliente = new Cliente();
                cliente.setId(getRs().getInt(1));
                cliente.setNombre(getRs().getString(2));
                cliente.setDNI(getRs().getString(3));
                cliente.setFecha((getRs().getDate(4)).toLocalDate());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    @Override
    public List<Cliente> listed() {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            setSql("SELECT * FROM cliente");
            setPs(getConector().prepareStatement(getSql()));
            setRs(getPs().executeQuery());
            while (getRs().next()) {
                Cliente cliente = new Cliente();
                cliente.setId(getRs().getInt(1));
                cliente.setNombre(getRs().getString(2));
                cliente.setDNI(getRs().getString(3));
                cliente.setFecha((getRs().getDate(4)).toLocalDate());
                
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }
    
    @Override
    public boolean exeUpdate() throws SQLException {
        boolean exito;
        try {
            getPs().executeUpdate();
            getConector().commit();
            exito = true;
            System.out.println("Transacción exitosa");
        } catch (SQLException ex) {
            getConector().rollback();
            exito = false;
            System.out.println("Transacciónn NO exitosa");
        } finally {
            if (getPs() != null) {
                getPs().close();
            }
        }
        return exito;
    }
    
}
