package vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vistaModelo.ViewModelLogin;

public class VistaLogin extends javax.swing.JFrame implements ActionListener {

    private ViewModelLogin vmLogin;

    public VistaLogin() {
        lookAndFeel();
        initComponents();
        vmLogin = new ViewModelLogin();
        bttn_registrar.addActionListener(this);
        bttn_siguiente.addActionListener(this);
    }

    public void iniciar() {
        pack();
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

        lbl_datos.setText("Datos del usuario");

        lbl_registro.setText("REGISTRO DE VEHICULOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(txtFld_fechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFld_nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(txtFld_dni, javax.swing.GroupLayout.Alignment.TRAILING))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(lbl_registro)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbl_registro)
                .addGap(50, 50, 50)
                .addComponent(lbl_datos)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFld_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFld_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_dni))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bttn_siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttn_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFld_fechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_fechaNacimiento))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        vmLogin.setNombre(getNombre());
        vmLogin.setDNI(getDni());
        vmLogin.setFecha(getFechaNacimiento());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Registrar Cuenta" -> {
                setDatosLogin();
                vmLogin.registrarCuenta(); 
            }
            case "Siguiente" -> {
                setDatosLogin();
                vmLogin.iniciarSesion();
            }
        }
        showMensaje(vmLogin.getMensaje());
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
