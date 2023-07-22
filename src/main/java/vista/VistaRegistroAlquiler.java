package vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        this.cmbBx_vehiculos.addActionListener(this);
        
        cargaEncabezadoTabla();
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
        tblModelCarro.addColumn(new String[]{"Nro", "Descripción", "Categoría", "Precio/Hora"});
        tblModelMoto.addColumn(new String[]{"Nro", "Descripción","Precio/Hora"});
        tblModelBicicleta.addColumn(new String[]{"Nro", "Descripción", "Precio/Hora"});
        tblModelRegistroAlquiler.addColumn(new String[]{"Nro", "Descripción", "Cliente", "Hora Recojo", "Total Horas", "Total Dinero"});
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
    }

    private void addFilaRegistroAlquiler(RegistroAlquiler registroAlquiler) {
        if (registroAlquiler != null) {
            tblModelRegistroAlquiler.addRow(new Object[]{
                registroAlquiler, //
                registroAlquiler.getVehiculo().getDescripcion(),
                registroAlquiler.getCliente().getNombre(),
                registroAlquiler.getHoraRecogida(),
                registroAlquiler.getCantidadHoras(),
                registroAlquiler.getVehiculo().getPrecioHora()*registroAlquiler.getCantidadHoras()});
        }
    }

    public LocalTime getHoraRecogida() {
        try {
            return LocalTime.parse(txtFld_hora.getText(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        } catch (Exception e) {
            showMensaje("Hora incorrecta, siga el patrón: HH:mm:ss");
            return LocalTime.now(); // Por el momento, devuelve la hora actual
        }
    }
    
    public int getCantidadHoras() {
        return Integer.parseInt(txtFld_cantidad.getText());
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
        tbl_registroTotal.setPreferredSize(new java.awt.Dimension(450, 350));
        tbl_registroTotal.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_registroTotal);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
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
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_nombre)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(lbl_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbl_registro)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre)
                    .addComponent(cmbBx_vehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lbl_datos)
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_hora)
                                    .addComponent(txtFld_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_cantidad)
                                    .addComponent(txtFld_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bttn_alquilar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bttn_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                vm.getVmRegistroAlquiler().setHoraRecogida(getHoraRecogida());
                vm.getVmRegistroAlquiler().setCantidadHoras(getCantidadHoras());
                vm.getVmRegistroAlquiler().alquilar();
            }
            case "Ver registro" -> {
                showTablaRegistroAlquiler(vm.getVmRegistroAlquiler().getListaRegistrosAquileres());
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
    public javax.swing.JButton bttn_registro;
    public javax.swing.JComboBox<String> cmbBx_vehiculos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_datos;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_registro;
    public javax.swing.JTable tbl_registroTotal;
    public javax.swing.JTable tbl_vehiculoDescripcion;
    public javax.swing.JTextField txtFld_cantidad;
    public javax.swing.JTextField txtFld_hora;
    // End of variables declaration//GEN-END:variables
}