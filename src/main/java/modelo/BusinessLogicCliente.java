package modelo;

import factoryDAOs.DAOFactory;
import factoryDAOs.SqlServerDAOFactory;
import java.util.List;
import pojo.Cliente;

public class BusinessLogicCliente {
    private Cliente cliente;
    private DAOFactory dao;
    private boolean existe;
    private String mensaje;

    public BusinessLogicCliente() {
        this.cliente = new Cliente();
        this.dao = new SqlServerDAOFactory(); // o MySql
    }

    public void iniciarSesion(){
        if (cuentaExiste()) setMensaje("Sesión iniciada con éxito.");
        else  setMensaje("Datos incorrectos o cuenta inexistente.");
    }
    
    public void registrarCuenta() {
        if (cuentaExiste())  setMensaje("La cuenta ya existe, registre otra o inicie sesión.");
        else {
            cliente = (Cliente) dao.getCliente().create(cliente);
            setMensaje("Cuenta creada con éxito.");
        }
    }
    
    private boolean cuentaExiste() {
        for (Cliente clienteBD : (List<Cliente>)dao.getCliente().listed()) {
            if (clienteBD.getNombre().equals(cliente.getNombre()) && clienteBD.getDNI().equals(cliente.getDNI())) {
                existe = true;
                cliente = clienteBD;
                break;
            } else {
                existe = false;
            }
        }
        return existe;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    } 

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    
}
