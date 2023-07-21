package AppMain;

import conexiones.SqlServerConexion;
import vista.VistaLogin;

public class main {

    public static void main(String[] args) {
        SqlServerConexion.setDatos("localhost", "1433", "alquilerVehiculos", "sa", "02122002");
        
        VistaLogin vLogin = new VistaLogin();
        vLogin.iniciar();
    }
}
