package modelo;

import factoryDAOs.DAOFactory;
import factoryDAOs.SqlServerDAOFactory;
import pojo.RegistroAlquiler;

public class BusinessLogicRegistroAlquiler {
    private RegistroAlquiler registroAlquiler;
    private DAOFactory dao;

    public BusinessLogicRegistroAlquiler() {
        this.registroAlquiler = new RegistroAlquiler();
        this.dao = new SqlServerDAOFactory(); //
    }
    
    public RegistroAlquiler getRegistroAlquiler() {
        return registroAlquiler;
    }
    
    public void alquilar() {
        dao.getRegistro().create(registroAlquiler);
    }  
}
