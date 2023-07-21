package vistaModelo;

import java.util.Date;
import modelo.BusinessLogicCliente;

public class ViewModelLogin {
    private BusinessLogicCliente modeloCliente;
    
    public int getId() {
        return modeloCliente.getCliente().getId();
    }

    public void setId(int id) {
        modeloCliente.getCliente().setId(id);
    }

    public String getNombre() {
        return modeloCliente.getCliente().getNombre();
    }

    public void setNombre(String nombre) {
        modeloCliente.getCliente().setNombre(nombre);
    }

    public String getDNI() {
        return modeloCliente.getCliente().getDNI();
    }

    public void setDNI(String DNI) {
        modeloCliente.getCliente().setDNI(DNI);
    }

    public Date getFecha() {
        return modeloCliente.getCliente().getFecha();
    }

    public void setFecha(Date fecha) {
        modeloCliente.getCliente().setFecha(fecha);
    }
    
    public void iniciarSesion() {
        modeloCliente.iniciarSesion();
    }
    
    public void registrarCuenta() {
        modeloCliente.registrarCuenta();
    }
}
