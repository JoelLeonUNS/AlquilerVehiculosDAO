package vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import pojo.Bicicleta;
import pojo.Carro;
import pojo.Moto;
import pojo.RegistroAlquiler;
import pojo.Vehiculo;
import vistaModelo.ViewModelGeneral;

public class VistaRegistroAlquiler extends javax.swing.JFrame implements ActionListener, ListSelectionListener {
    private final ViewModelGeneral vm;
    private DefaultComboBoxModel<String> cmbBxModelVehiculo = new DefaultComboBoxModel<>();
    private DefaultTableModel tblModelCarro = new DefaultTableModel();
    private DefaultTableModel tblModelMoto = new DefaultTableModel();
    private DefaultTableModel tblModelBicicleta = new DefaultTableModel();
    private DefaultTableModel tblModelRegistroAlquiler = new DefaultTableModel();
    
    public VistaRegistroAlquiler() {
        lookAndFeel();
        initComponents();
        this.vm = ViewModelGeneral.getInstancia();
        
        this.bttn_alquilar.addActionListener(this);
        this.bttn_registro.addActionListener(this);
        this.bttn_cerrarSesion.addActionListener(this);
        this.cmbBx_vehiculos.addActionListener(this);
        this.tbl_vehiculoDescripcion.getSelectionModel().addListSelectionListener(this);
        
        cargaEncabezadoTabla();
        cargarComboBox();
    }
    
    public void iniciar() {
        pack();
        setTitle("Registro de Alquiler");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public void setModelTable(DefaultTableModel tblModel){
        tbl_vehiculoDescripcion.setModel(tblModel);
    }
    
    private void cargaEncabezadoTabla() {
        for (String campo : new String[]{"Nro", "Descripción", "Categoría", "Precio/Hora"}) {
            tblModelCarro.addColumn(campo);
        }
        for (String campo : new String[]{"Nro", "Descripción","Precio/Hora"}) {
            tblModelMoto.addColumn(campo);
        }
        for (String campo : new String[]{"Nro", "Descripción", "Precio/Hora"}) {
            tblModelBicicleta.addColumn(campo);
        }
        for (String campo :  new String[]{"Nro", "Vehiculo", "Descripción", "Cliente", "Hora Recojo", "Total Horas", "Total Dinero"}) {
            tblModelRegistroAlquiler.addColumn(campo);
        }
        tbl_registroTotal.getColumnModel().getColumn(0).setPreferredWidth(30);
    }
    
    private void cargarComboBox() {
        cmbBxModelVehiculo.addElement("Carro");
        cmbBxModelVehiculo.addElement("Moto");
        cmbBxModelVehiculo.addElement("Bicicleta");
    }
    
    public void showTablaCarro(List<Carro> carros) {
        tblModelCarro.setRowCount(0);
        for (Carro carro : carros) {
            addFilaCarro(carro);
        }
    }

    private void addFilaCarro(Carro carro) {
        if (carro != null) {
            tblModelCarro.addRow(new Object[]{
                carro, //
                carro.getDescripcion(),
                carro.getCategoria(),
                carro.getPrecioHora()});
        }
    }
    
    public void showTablaMoto(List<Moto> motos) {
        tblModelMoto.setRowCount(0);
        for (Moto moto : motos) {
            addFilaMoto(moto);
        }
    }

    private void addFilaMoto(Moto moto) {
        if (moto != null) {
            tblModelMoto.addRow(new Object[]{
                moto, //
                moto.getDescripcion(),
                moto.getPrecioHora()});
        }
    }
    
    public void showTablaBicicleta(List<Bicicleta> bicicletas) {
        tblModelBicicleta.setRowCount(0);
        for (Bicicleta bicicleta : bicicletas) {
            addFilaMoto(bicicleta);
        }
    }

    private void addFilaMoto(Bicicleta bicicleta) {
        if (bicicleta != null) {
            tblModelBicicleta.addRow(new Object[]{
                bicicleta, //
                bicicleta.getDescripcion(),
                bicicleta.getPrecioHora()});
        }
    }
    
    public void showTablaRegistroAlquiler(List<RegistroAlquiler> registrosAquileres) {
        tblModelRegistroAlquiler.setRowCount(0);
        for (RegistroAlquiler registroAlquiler : registrosAquileres) {
            addFilaRegistroAlquiler(registroAlquiler);
        }
        tbl_registroTotal.getColumnModel().getColumn(0).setPreferredWidth(30);
    }

    private void addFilaRegistroAlquiler(RegistroAlquiler registroAlquiler) {
        if (registroAlquiler != null) {
            tblModelRegistroAlquiler.addRow(new Object[]{
                registroAlquiler, //
                registroAlquiler.getVehiculo().getClass().getSimpleName(),
                registroAlquiler.getVehiculo().getDescripcion(),
                registroAlquiler.getCliente().getNombre(),
                registroAlquiler.getHoraRecogida(),
                registroAlquiler.getCantidadHoras(),
                registroAlquiler.getVehiculo().getPrecioHora()*registroAlquiler.getCantidadHoras()});
        }
    }

    public LocalTime getHoraRecogida() {
        return LocalTime.parse(txtFld_hora.getText(), DateTimeFormatter.ofPattern("HH:mm"));
    }
    
    public int getCantidadHoras() {
        return Integer.parseInt(txtFld_cantidad.getText());
    }
    
     public boolean setDatosAquilar() {
        boolean valido;
        try {
            vm.getVmRegistroAlquiler().setHoraRecogida(getHoraRecogida());
            vm.getVmRegistroAlquiler().setCantidadHoras(getCantidadHoras());
            valido = true;
        } catch (Exception e) {
            valido = false;
            showMensaje("Campo(s) no valido(s).");
        }
        return valido;
    }

    public void showMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_registro = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        cmbBx_vehiculos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_vehiculoDescripcion = new javax.swing.JTable();
        lbl_datos = new javax.swing.JLabel();
        lbl_hora = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        txtFld_hora = new javax.swing.JTextField();
        txtFld_cantidad = new javax.swing.JTextField();
        bttn_alquilar = new javax.swing.JButton();
        bttn_registro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_registroTotal = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        bttn_cerrarSesion = new javax.swing.JButton();
        lbl_patronFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_registro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_registro.setText("REGISTRO DE VEHICULOS");

        lbl_nombre.setText("Vehiculo");

        cmbBx_vehiculos.setModel(cmbBxModelVehiculo);
        cmbBx_vehiculos.setActionCommand("Cambiar Vehiculo");

        tbl_vehiculoDescripcion.setModel(tblModelCarro);
        tbl_vehiculoDescripcion.setPreferredSize(new java.awt.Dimension(350, 150));
        tbl_vehiculoDescripcion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_vehiculoDescripcion);

        lbl_datos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_datos.setText("Datos de Registro");

        lbl_hora.setText("Hora a recoger:");

        lbl_cantidad.setText("Cantidad de horas:");

        bttn_alquilar.setText("Alquilar");

        bttn_registro.setText("Ver registro");

        tbl_registroTotal.setModel(tblModelRegistroAlquiler);
        tbl_registroTotal.setPreferredSize(new java.awt.Dimension(550, 430));
        tbl_registroTotal.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_registroTotal);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        bttn_cerrarSesion.setText("Cerrar Sesión");

        lbl_patronFecha.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lbl_patronFecha.setForeground(new java.awt.Color(102, 102, 102));
        lbl_patronFecha.setText("Patrón: hh:mm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_datos)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(34, 34, 34)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl_hora)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(lbl_cantidad)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(txtFld_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtFld_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cmbBx_vehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(bttn_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(bttn_alquilar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbl_patronFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_nombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lbl_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_registro)
                    .addComponent(bttn_cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nombre)
                            .addComponent(cmbBx_vehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lbl_datos)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_hora)
                                    .addComponent(txtFld_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_patronFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_cantidad)
                                    .addComponent(txtFld_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bttn_alquilar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bttn_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))))
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cambiar Vehiculo" -> {
                switch (((String)cmbBxModelVehiculo.getSelectedItem())) {
                    case "Carro" -> {
                        setModelTable(tblModelCarro);
                        showTablaCarro(vm.getVmRegistroAlquiler().getListaCarros());
                    }
                    case "Moto" -> {
                        setModelTable(tblModelMoto);
                        showTablaMoto(vm.getVmRegistroAlquiler().getListaMotos());
                    }
                    case "Bicicleta" -> {
                        setModelTable(tblModelBicicleta);
                        showTablaBicicleta(vm.getVmRegistroAlquiler().getListaBicicletas());
                    }
                }
            }
            case "Alquilar" -> {
                if (setDatosAquilar()) vm.getVmRegistroAlquiler().alquilar();
            }
            case "Ver registro" -> {
                showTablaRegistroAlquiler(vm.getVmRegistroAlquiler().getListaRegistrosAquileres());
            }
            case "Cerrar Sesión" -> {
                dispose();
                vm.mostrarLogin();
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int filaSeleccionada = tbl_vehiculoDescripcion.getSelectedRow();
            if (filaSeleccionada != -1) {
                vm.getVmRegistroAlquiler().setVehiculo((Vehiculo)tbl_vehiculoDescripcion.getValueAt(filaSeleccionada, 0));
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bttn_alquilar;
    public javax.swing.JButton bttn_cerrarSesion;
    public javax.swing.JButton bttn_registro;
    public javax.swing.JComboBox<String> cmbBx_vehiculos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_datos;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_patronFecha;
    private javax.swing.JLabel lbl_registro;
    public javax.swing.JTable tbl_registroTotal;
    public javax.swing.JTable tbl_vehiculoDescripcion;
    public javax.swing.JTextField txtFld_cantidad;
    public javax.swing.JTextField txtFld_hora;
    // End of variables declaration//GEN-END:variables
}