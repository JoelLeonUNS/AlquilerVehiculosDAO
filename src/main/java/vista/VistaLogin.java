package vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vistaModelo.ViewModelGeneral;

public class VistaLogin extends javax.swing.JFrame implements ActionListener {

    private ViewModelGeneral vm;

    public VistaLogin() {
        lookAndFeel();
        initComponents();
        this.vm = ViewModelGeneral.getInstancia();
        bttn_registrar.addActionListener(this);
        bttn_siguiente.addActionListener(this);
    }

    public void iniciar() {
        pack();
        setTitle("Inicio de Sesión / Registro de Cuenta");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFld_dni = new javax.swing.JTextField();
        bttn_registrar = new javax.swing.JButton();
        bttn_siguiente = new javax.swing.JButton();
        txtFld_nombre = new javax.swing.JTextField();
        lbl_fechaNacimiento = new javax.swing.JLabel();
        lbl_dni = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_datos = new javax.swing.JLabel();
        lbl_registro = new javax.swing.JLabel();
        txtFld_fechaNacimiento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bttn_registrar.setText("Registrar Cuenta");

        bttn_siguiente.setText("Siguiente");

        lbl_fechaNacimiento.setText("Fecha de Nacimiento:");

        lbl_dni.setText("DNI:");

        lbl_nombre.setText("Nombre:");

        lbl_datos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_datos.setText("Datos del usuario");

        lbl_registro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_registro.setText("REGISTRO DE VEHICULOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bttn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bttn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_fechaNacimiento)
                            .addComponent(lbl_dni)
                            .addComponent(lbl_nombre)
                            .addComponent(lbl_datos))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFld_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFld_nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txtFld_dni, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addComponent(lbl_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbl_registro)
                .addGap(30, 30, 30)
                .addComponent(lbl_datos)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFld_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombre))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFld_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_dni))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFld_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_fechaNacimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
    }

    public String getNombre() {
        return txtFld_nombre.getText();
    }

    public String getDni() {
        return txtFld_dni.getText();
    }

    public void showMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public LocalDate getFechaNacimiento() {
        try {
            return LocalDate.parse(txtFld_fechaNacimiento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (Exception e) {
            showMensaje("Fecha incorrecta, siga el patrón: dd/MM/yyyy");
            return LocalDate.now(); // por el momento
        }
    }

    public void setDatosLogin() {
        vm.getVmLogin().setNombre(getNombre());
        vm.getVmLogin().setDNI(getDni());
        vm.getVmLogin().setFecha(getFechaNacimiento());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrar Cuenta" -> {
                setDatosLogin();
                vm.getVmLogin().registrarCuenta();
                showMensaje(vm.getVmLogin().getMensaje());
            }
            case "Siguiente" -> {
                setDatosLogin();
                vm.getVmLogin().iniciarSesion();
                showMensaje(vm.getVmLogin().getMensaje());
                if (vm.getVmLogin().isAcceso()) {
                    vm.getVmRegistroAlquiler().setCliente(vm.getVmLogin().getCliente());
                    vm.mostrarRegistroAlquiler();
                }
            }
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bttn_registrar;
    public javax.swing.JButton bttn_siguiente;
    private javax.swing.JLabel lbl_datos;
    private javax.swing.JLabel lbl_dni;
    private javax.swing.JLabel lbl_fechaNacimiento;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_registro;
    public javax.swing.JTextField txtFld_dni;
    private javax.swing.JTextField txtFld_fechaNacimiento;
    public javax.swing.JTextField txtFld_nombre;
    // End of variables declaration//GEN-END:variables

}
