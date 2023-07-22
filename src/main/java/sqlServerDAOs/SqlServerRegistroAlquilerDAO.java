package sqlServerDAOs;

import DAOs.RegistroDAO;
import factoryDAOs.DAOFactory;
import factoryDAOs.SqlServerDAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Cliente;
import pojo.RegistroAlquiler;
import pojo.Vehiculo;

public class SqlServerRegistroAlquilerDAO extends RegistroDAO<RegistroAlquiler> {

    @Override
    public RegistroAlquiler create(RegistroAlquiler obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RegistroAlquiler delete(RegistroAlquiler obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RegistroAlquiler update(RegistroAlquiler obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RegistroAlquiler read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RegistroAlquiler> listed() {
        List<RegistroAlquiler> listaRegistros = new ArrayList<>();
        try {
            setSql("SELECT * FROM RegistroAlquiler");
            setPs(getConector().prepareStatement(getSql()));
            setRs(getPs().executeQuery());
            while (getRs().next()) {
                RegistroAlquiler registro = new RegistroAlquiler();
                registro.setId(getRs().getInt(1));
                registro.setHoraRecogida(getRs().getTime(2).toLocalTime());
                registro.setCantidadHoras(getRs().getInt(3));
                
                DAOFactory dao = new SqlServerDAOFactory();
                registro.setCliente((Cliente)dao.getCliente().read(getRs().getInt(4)));            
                registro.setVehiculo((Vehiculo)dao.getVehiculo().read(getRs().getInt(5)));

                listaRegistros.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaRegistros;
    }

    @Override
    public void exeUpdate() throws SQLException {
        try {
            getPs().executeUpdate();
            getConector().commit();
            System.out.println("Transacción exitosa");
        } catch (SQLException ex) {
            getConector().rollback();
            System.out.println("Transacciónn NO exitosa");
        } finally {
            if (getPs() != null) {
                getPs().close();
            }
        }
    }

}
