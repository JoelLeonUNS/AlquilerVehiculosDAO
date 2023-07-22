package vistaModelo;

import java.time.LocalDate;
import modelo.BusinessLogicCliente;
import modelo.BusinessLogicRegistroAlquiler;
import pojo.Cliente;

public class ViewModelLogin {
    private BusinessLogicCliente modeloCliente;
    private BusinessLogicRegistroAlquiler modeloRegistroAlquiler;

    public ViewModelLogin() {
    }
    
    public void setModeloLogin(BusinessLogicCliente modeloCliente) {
        this.modeloCliente = modeloCliente;
    }
    
    public void setModeloRegistroAlquiler(BusinessLogicRegistroAlquiler modeloRegistroAlquiler) {
        this.modeloRegistroAlquiler = modeloRegistroAlquiler;
    }
    
    public Cliente getCliente() {
        return modeloCliente.getCliente();
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
