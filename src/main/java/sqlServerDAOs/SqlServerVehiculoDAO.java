package sqlServerDAOs;

import DAOs.VehiculoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Bicicleta;
import pojo.Carro;
import pojo.Categoria;
import pojo.Moto;
import pojo.Vehiculo;

public class SqlServerVehiculoDAO extends VehiculoDAO<Vehiculo> {

    @Override
    public Vehiculo create(Vehiculo obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody      
    }

    @Override
    public Vehiculo delete(Vehiculo obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehiculo update(Vehiculo obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehiculo read(int id) {
        setSql("SELECT * FROM Vehiculo WHERE idVehiculo = ?");
        Vehiculo vehiculo = null;
        try {
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, id);
            setRs(getPs().executeQuery());

            if (getRs().next()) {
                
                switch (getRs().getString(5)) {
                    case "Carro" -> {
                        vehiculo = new Carro();
                        switch (getRs().getInt(2)) {
                            case 1 -> {
                                ((Carro) vehiculo).setCategoria(Categoria.A);
                            }
                            case 2 -> {
                                ((Carro) vehiculo).setCategoria(Categoria.B);
                            }
                            case 3 -> {
                                ((Carro) vehiculo).setCategoria(Categoria.C);
                            }
                        }
                    }
                    case "Moto" -> {
                        vehiculo = new Moto();
                    }
                    case "Bicicleta" -> {
                        vehiculo = new Bicicleta();
                    }
                }
                vehiculo.setId(getRs().getInt(1));              
                vehiculo.setDescripcion(getRs().getString(3));
                vehiculo.setPrecioHora(getRs().getDouble(4));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vehiculo;
    }

    @Override
    public List<Vehiculo> listed() {
         List<Vehiculo> listaVehiculos = new ArrayList<>();
        try {
            setSql("SELECT * FROM Vehiculo");
            setPs(getConector().prepareStatement(getSql()));
            setRs(getPs().executeQuery());
            Vehiculo vehiculo = null;
            while (getRs().next()) {
                switch (getRs().getString(5)) {
                    case "Carro" -> {
                        vehiculo = new Carro();
                        switch (getRs().getInt(2)) {
                            case 1 -> {
                                ((Carro) vehiculo).setCategoria(Categoria.A);
                            }
                            case 2 -> {
                                ((Carro) vehiculo).setCategoria(Categoria.B);
                            }
                            case 3 -> {
                                ((Carro) vehiculo).setCategoria(Categoria.C);
                            }
                        }
                    }
                    case "Moto" -> {
                        vehiculo = new Moto();
                    }
                    case "Bicicleta" -> {
                        vehiculo = new Bicicleta();
                    }
                }
                vehiculo.setId(getRs().getInt("idVehiculo"));
                vehiculo.setDescripcion(getRs().getString("descripcion"));
                vehiculo.setPrecioHora(getRs().getDouble("precioHora"));
                
                listaVehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaVehiculos;
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
