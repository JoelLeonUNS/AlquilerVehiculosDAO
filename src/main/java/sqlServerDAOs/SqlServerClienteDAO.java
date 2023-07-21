package sqlServerDAOs;

import DAOs.ClienteDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Cliente;

public class SqlServerClienteDAO extends ClienteDAO<Cliente>{

    @Override
    public Cliente create(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> listed() {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cliente";
            PreparedStatement statement = this.conector.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setDNI(rs.getString(3));
                cliente.setFecha(rs.getDate(4));

                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
        }

        return listaClientes;
    }
    
}
