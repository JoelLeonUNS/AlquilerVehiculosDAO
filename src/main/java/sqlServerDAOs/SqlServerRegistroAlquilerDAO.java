package sqlServerDAOs;

import DAOs.RegistroDAO;
import factoryDAOs.DAOFactory;
import factoryDAOs.SqlServerDAOFactory;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import pojo.Cliente;
import pojo.RegistroAlquiler;
import pojo.Vehiculo;

public class SqlServerRegistroAlquilerDAO extends RegistroDAO<RegistroAlquiler> {

    @Override
    public RegistroAlquiler create(RegistroAlquiler obj) {
        try {
            setSql("INSERT INTO RegistroAlquiler (horaRecogida, cantidadHoras, idCliente, idVehiculo) VALUES (?, ?, ?, ?)");
            setPs(getConector().prepareStatement(getSql()));

            getPs().setTime(1, Time.valueOf(obj.getHoraRecogida()));
            getPs().setInt(2, obj.getCantidadHoras());
            getPs().setInt(3, obj.getCliente().getId());
            System.out.println(obj.getVehiculo().getId() + "  -  " + obj.getCliente().getId());
            getPs().setInt(4, obj.getVehiculo().getId());
            if (!exeUpdate()) obj = null;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
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
                registro.setCliente((Cliente) dao.getCliente().read(getRs().getInt(4)));
                registro.setVehiculo((Vehiculo) dao.getVehiculo().read(getRs().getInt(5)));

                listaRegistros.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaRegistros;
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
