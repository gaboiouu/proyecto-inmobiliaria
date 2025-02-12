/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.InmuebleControlador;
import PatronSingleton.DatabaseConnection;
import PatronesObserver.Observer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GestionPropiedad extends javax.swing.JPanel implements Observer{
    private InmuebleControlador imensaje;
    
    /**
     * Creates new form RegistrarPropiedad
     */
    public GestionPropiedad() {
        initComponents();
        this.imensaje = new InmuebleControlador();
        this.imensaje.agregarObservador(this);
        configurarTabla();
        cargarDatos("");
        
    }

    @Override
    public void actualizar(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        cargarDatos("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bregistrar = new javax.swing.JButton();
        tubicacion = new javax.swing.JTextField();
        tipo = new javax.swing.JTextField();
        testado = new javax.swing.JTextField();
        tprecio = new javax.swing.JTextField();
        tdescripcion = new javax.swing.JTextField();
        cochera = new javax.swing.JCheckBox();
        terraza = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        beditar = new javax.swing.JButton();
        batras = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jbuscar = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablainmueble = new javax.swing.JTable();
        bactualizar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/casa (2).png"))); // NOI18N
        jLabel7.setText("Nuevo Inmobiliaria");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ubicación:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Descripción:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tipo:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Estado:");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Precio:");

        bregistrar.setBackground(new java.awt.Color(51, 153, 255));
        bregistrar.setForeground(new java.awt.Color(255, 255, 255));
        bregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        bregistrar.setText("Registrar Nueva Propiedad");
        bregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bregistrarActionPerformed(evt);
            }
        });

        tubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tubicacionActionPerformed(evt);
            }
        });

        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });

        testado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testadoActionPerformed(evt);
            }
        });

        tprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tprecioActionPerformed(evt);
            }
        });

        tdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdescripcionActionPerformed(evt);
            }
        });

        cochera.setText("con Cochera");

        terraza.setText("con Terraza");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(bregistrar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cochera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(terraza)
                                .addGap(29, 29, 29))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(testado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(testado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cochera)
                    .addComponent(terraza))
                .addGap(18, 18, 18)
                .addComponent(bregistrar)
                .addGap(34, 34, 34))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Inmuebles"));

        beditar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        beditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        beditar.setText("Editar");
        beditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditarActionPerformed(evt);
            }
        });

        batras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        batras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        batras.setText("Atras");
        batras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batrasActionPerformed(evt);
            }
        });

        jLabel13.setText("Listar y Editar Propiedades");

        buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        buscar.setText("buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jtablainmueble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtablainmueble);

        bactualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar.png"))); // NOI18N
        bactualizar.setText("Actualizar");
        bactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualizarActionPerformed(evt);
            }
        });

        beliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        beliminar.setText("Eliminar");
        beliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(beditar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(batras, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addGap(18, 18, 18)
                    .addComponent(jbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(buscar)
                    .addGap(63, 63, 63)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beditar)
                    .addComponent(batras)
                    .addComponent(bactualizar)
                    .addComponent(beliminar))
                .addGap(18, 18, 18))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscar))
                    .addContainerGap(268, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 570, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void bregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bregistrarActionPerformed
        String ubicacion = tubicacion.getText().trim();
        String precioText = tprecio.getText().trim();
        String tipoInmueble = tipo.getText().trim();
        String descripcion = tdescripcion.getText().trim();
        String estado = testado.getText().trim();
        boolean tieneCochera = cochera.isSelected();
        boolean tieneTerraza = terraza.isSelected();

        if (ubicacion.isEmpty() || precioText.isEmpty() || tipoInmueble.isEmpty() || descripcion.isEmpty() || estado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que el precio sea un número válido
        double precio;
        try {
            precio = Double.parseDouble(precioText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

    // Guardar en la base de datos
        try {
            InmuebleControlador inmueble = new InmuebleControlador();
            inmueble.insertarInmueble(precio, descripcion, estado, tipoInmueble, ubicacion, tieneCochera, tieneTerraza);
            // Limpiar campos y mostrar mensaje de éxito
            limpiarCampos();
            imensaje.registrarInmueble();

           // Actualizar el JTable
            cargarDatos("");
        } catch (RuntimeException e) {
            imensaje.errorRegistrarInmueble();
        }
    }//GEN-LAST:event_bregistrarActionPerformed

    private void tubicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tubicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tubicacionActionPerformed

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoActionPerformed

    private void testadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testadoActionPerformed

    private void tprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tprecioActionPerformed

    private void tdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdescripcionActionPerformed

    private void batrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batrasActionPerformed

        java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);

        if (window instanceof javax.swing.JFrame) {
            imensaje.notificarInmueble();
            // Cerrar el JFrame actual
            window.dispose();
        }

        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_batrasActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String searchText = jbuscar.getText().trim();
        cargarDatos(searchText);       
    }//GEN-LAST:event_buscarActionPerformed

    private void bactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizarActionPerformed
        int selectedRow = jtablainmueble.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String ubicacion = tubicacion.getText().trim();
        String precioText = tprecio.getText().trim();
        String tipoInmueble = tipo.getText().trim();
        String descripcion = tdescripcion.getText().trim();
        String estado = testado.getText().trim();
        boolean tieneCochera = cochera.isSelected();
        boolean tieneTerraza = terraza.isSelected();

        if (ubicacion.isEmpty() || precioText.isEmpty() || tipoInmueble.isEmpty() || descripcion.isEmpty() || estado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(precioText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idInmueble = Integer.parseInt(jtablainmueble.getValueAt(selectedRow, 0).toString());

        try {
            InmuebleControlador inmueble = new InmuebleControlador();
            inmueble.actualizarInmueble(idInmueble, precio, descripcion, estado, tipoInmueble, ubicacion, tieneCochera, tieneTerraza);
            limpiarCampos();
            imensaje.actualizarInmueble();
            cargarDatos("");
        } catch (RuntimeException e) {
            imensaje.errorActualizar();
        }
    }//GEN-LAST:event_bactualizarActionPerformed

    private void beditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditarActionPerformed
        int selectedRow = jtablainmueble.getSelectedRow();
        if (selectedRow == -1) {
            imensaje.filaActualizar();
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jtablainmueble.getModel();
        tubicacion.setText(model.getValueAt(selectedRow, 5).toString());
        tprecio.setText(model.getValueAt(selectedRow, 1).toString());
        tdescripcion.setText(model.getValueAt(selectedRow, 2).toString());
        tipo.setText(model.getValueAt(selectedRow, 4).toString());
        testado.setText(model.getValueAt(selectedRow, 3).toString());
    }//GEN-LAST:event_beditarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
        int selectedRow = jtablainmueble.getSelectedRow(); // Obtiene la fila seleccionada
        if (selectedRow != -1) { // Verifica si hay una fila seleccionada
            // Obtén el ID del inmueble desde la tabla (columna 0 debe ser el id_inmueble)
            String inmuebleId = jtablainmueble.getValueAt(selectedRow, 0).toString();

            // Confirmar eliminación
            int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Estás seguro de que deseas eliminar este inmueble?", 
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                Connection con = null;
                PreparedStatement ps = null;
                try {
                    // Obtén la conexión usando DatabaseConnection
                    con = DatabaseConnection.getConnection();

                    // Crear consulta SQL para eliminar el inmueble
                    String sql = "DELETE FROM inmueble WHERE id_inmueble = ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, inmuebleId);

                    // Ejecutar la eliminación en la base de datos
                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        // Eliminar la fila seleccionada de la tabla
                        DefaultTableModel modelo = (DefaultTableModel) jtablainmueble.getModel();
                        modelo.removeRow(selectedRow); // Aquí elimina la fila de la tabla gráfica

                        imensaje.eliminarInmueble();
                    } else {
                        imensaje.errorEliminarBD();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    imensaje.errorEliminar();
                } finally {
                    try {
                        if (ps != null) ps.close(); // Cierra el PreparedStatement
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    // No cerramos la conexión directamente, DatabaseConnection la gestiona
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un inmueble para eliminar.");
        }
    }//GEN-LAST:event_beliminarActionPerformed

    private void cargarDatos(String searchText) {
        DefaultTableModel model = (DefaultTableModel) jtablainmueble.getModel();
        model.setRowCount(0); // Clear existing data

        String query = "SELECT id_inmueble, precio, descripcion, estado, tipo_inmueble, ubicacion FROM Inmueble";
        if (!searchText.isEmpty()) {
            query += " WHERE descripcion LIKE ? OR tipo_inmueble LIKE ? OR ubicacion LIKE ? OR estado LIKE ? ";
        }

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            if (!searchText.isEmpty()) {
                String searchPattern = "%" + searchText + "%";
                stmt.setString(1, searchPattern);
                stmt.setString(2, searchPattern);
                stmt.setString(3, searchPattern);
                stmt.setString(4, searchPattern);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Object[] row = {
                        rs.getString("id_inmueble"),
                        rs.getString("precio"),
                        rs.getString("descripcion"),
                        rs.getString("estado"),
                        rs.getString("tipo_inmueble"),
                        rs.getString("ubicacion"),
                    };
                    model.addRow(row);
                    }
                }
            } catch (SQLException e) {
            e.printStackTrace();
            }
    }
    
     private void configurarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel(
        new Object[][]{}, 
        new String[]{"ID", "Precio", "Descripción", "Estado", "Tipo Inmueble", "Ubicación"}
        ) {
        // Evitar edición de celdas directamente
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
        jtablainmueble.setModel(modeloTabla);
        }
     
     //limpiar los campos de texto
        private void limpiarCampos() {
            tubicacion.setText("");
            tprecio.setText("");
            tdescripcion.setText("");
            tipo.setText("");
            testado.setText("");
        }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bactualizar;
    private javax.swing.JButton batras;
    private javax.swing.JButton beditar;
    private javax.swing.JButton beliminar;
    private javax.swing.JButton bregistrar;
    private javax.swing.JButton buscar;
    private javax.swing.JCheckBox cochera;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jbuscar;
    private javax.swing.JTable jtablainmueble;
    private javax.swing.JTextField tdescripcion;
    private javax.swing.JCheckBox terraza;
    private javax.swing.JTextField testado;
    private javax.swing.JTextField tipo;
    private javax.swing.JTextField tprecio;
    private javax.swing.JTextField tubicacion;
    // End of variables declaration//GEN-END:variables
}
