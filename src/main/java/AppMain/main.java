package AppMain;

import conexiones.SqlServerConexion;
import vistaModelo.ViewModelGeneral;

public class main {

    public static void main(String[] args) {
        SqlServerConexion.setDatos("localhost", "1433", "alquilerVehiculos", "av", "123");
        
        ViewModelGeneral.getInstancia().mostrarLogin();
    }
}
