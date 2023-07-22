package vistaModelo;

import modelo.BusinessLogicCliente;
import modelo.BusinessLogicRegistroAlquiler;
import vista.VistaLogin;
import vista.VistaRegistroAlquiler;

public class ViewModelGeneral {
    private static ViewModelGeneral vmGeneral;
    
    private ViewModelLogin vmLogin;
    private ViewModelRegistroAlquiler vmRegistroAlquiler;
    
    private BusinessLogicCliente modeloCliente;
    private BusinessLogicRegistroAlquiler modeloRegistroAlquiler;

    public ViewModelGeneral() {
        this.vmLogin = new ViewModelLogin();
        this.vmRegistroAlquiler = new ViewModelRegistroAlquiler();
        
        this.modeloCliente = new BusinessLogicCliente();
        this.modeloRegistroAlquiler = new BusinessLogicRegistroAlquiler();
        
        setModelosLogin();
        setModelosRegistroAlquiler();
    }
    
    private void setModelosLogin() {
        vmLogin.setModeloLogin(modeloCliente);
        vmLogin.setModeloRegistroAlquiler(modeloRegistroAlquiler);
    }
    
    private void setModelosRegistroAlquiler() {
        vmRegistroAlquiler.setModeloRegistroAlquiler(modeloRegistroAlquiler);
    }
    
    public static ViewModelGeneral getInstancia() {
        if (vmGeneral == null) {
            return vmGeneral = new ViewModelGeneral();
        } else {
            return vmGeneral;
        }
    }
    
    public void mostrarLogin() {
        VistaLogin vLogin = new VistaLogin();
        vLogin.iniciar();
    }
    
    public void mostrarRegistroAlquiler() {
        VistaRegistroAlquiler vRegistroAlquiler = new VistaRegistroAlquiler();
        vRegistroAlquiler.iniciar();
    }
    
    
    public ViewModelLogin getVmLogin() {
        return vmLogin;
    }

    public ViewModelRegistroAlquiler getVmRegistroAlquiler() {
        return vmRegistroAlquiler;
    }
    
    
}
