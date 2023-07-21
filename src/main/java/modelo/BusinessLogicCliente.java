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
        this.dao = new SqlServerDAOFactory(); //
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void iniciarSesion(){
        if (!cuentaExiste()) mensaje = "Datos incorrectos o cuenta inexistente.";
        else mensaje = "Sesión iniciada con éxito.";
    }
    
    public void registrarCuenta() {
        if (cuentaExiste()) mensaje = "La cuenta ya existe, registre otra o inicie sesión.";
        else mensaje = "Cuenta creada con éxito.";
    }
    
    private boolean cuentaExiste() {
        for (Cliente clienteBD : (List<Cliente>)dao.getCliente().listed()) {
            if (clienteBD.getNombre().equals(cliente.getNombre()) && clienteBD.getDNI().equals(cliente.getDNI())) {
                existe = true;
                break;
            }
        }
        return existe;
    }
    
}
