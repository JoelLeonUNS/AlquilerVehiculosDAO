package AppMain;

import conexiones.SqlServerConexion;
import vistaModelo.ViewModelGeneral;

public class main {

    public static void main(String[] args) {
        SqlServerConexion.setDatos("localhost", "1433", "alquilerVehiculos", "sa", "02122002");
        
        ViewModelGeneral.getInstancia().mostrarLogin();
    }
}
