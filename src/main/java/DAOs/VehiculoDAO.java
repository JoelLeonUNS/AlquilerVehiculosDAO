package DAOs;

import java.sql.Connection;
import java.util.List;

public abstract class VehiculoDAO<T> {
    
    public Connection conector;
    public abstract T create(T obj);
    public abstract T delete(T obj);
    public abstract T update(T obj);
    public abstract T read(int id);
    public abstract List<T> listed(); 

    public Connection getConector() {
        return conector;
    }

    public void setConector(Connection conector) {
        this.conector = conector;
    }
    
}

