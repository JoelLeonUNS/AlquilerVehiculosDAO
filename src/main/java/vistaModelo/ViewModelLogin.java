package vistaModelo;

import java.time.LocalDate;
import modelo.BusinessLogicCliente;

public class ViewModelLogin {
    private BusinessLogicCliente modeloCliente;

    public ViewModelLogin() {
        this.modeloCliente = new BusinessLogicCliente();
    }
 
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

    public LocalDate getFecha() {
        return modeloCliente.getCliente().getFecha();
    }

    public void setFecha(LocalDate fecha) {
        modeloCliente.getCliente().setFecha(fecha);
    }
    
    public String getMensaje() {
        return modeloCliente.getMensaje();
    }
    
    public boolean isAcceso() {
        return modeloCliente.isExiste();
    }
    
    public void iniciarSesion() {
        modeloCliente.iniciarSesion();
    }
    
    public void registrarCuenta() {
        modeloCliente.registrarCuenta();
    }
    
}
