package proyecto2;

import Models.UsuarioCRUD;
import Datos.Usuario;
import Datos.Ciudad;
import Datos.Pregunta;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Models.CiudadCrud;
import Models.PreguntaConsulta;

public class Vistaproyecto extends javax.swing.JFrame {

    Pattern pat = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
    public static List<Object> listaU = new ArrayList();

    Usuario user = new Usuario();
    UsuarioCRUD uc = new UsuarioCRUD();
    DefaultTableModel dtl = new DefaultTableModel();
    CiudadCrud cc = new CiudadCrud();
    PreguntaConsulta pc = new PreguntaConsulta();

    public Vistaproyecto() {
        initComponents();
        modelarTabla();
        llenarTabla();
        llenarComCiudad();
        llenarComPreguntas();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jconSuscrito = new javax.swing.JComboBox<>();
        jtpassw = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        luser = new javax.swing.JTable();
        jtBusqueda = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        comCiudad = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtDireccionPrincipal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtDireccionsecundaria = new javax.swing.JTextField();
        btnEntrega = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cmbPregunta = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jtRespuesta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Apellidos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Email*");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Suscrito?");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Contraseña*");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Nombre*");

        jtNombre.setToolTipText("");

        jconSuscrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));

        luser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        luser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        luser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                luserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(luser);

        jtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBusquedaKeyReleased(evt);
            }
        });

        jLabel6.setText("Buscar por correo:");

        btnActualizar.setText("Actualizar usuario");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar usuario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ciudad*");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Dirección secundaria");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Dirección principal*");

        btnEntrega.setText("Registrar entrega");
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Pregunta de seguridad");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Respuesta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(21, 21, 21)
                        .addComponent(jtDireccionPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(20, 20, 20)
                        .addComponent(jtDireccionsecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jtNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jconSuscrito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(20, 20, 20)
                                .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(20, 20, 20)
                                .addComponent(comCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jtpassw, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPregunta, 0, 424, Short.MAX_VALUE)
                                    .addComponent(jtRespuesta)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(100, 100, 100)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addGap(37, 37, 37)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                    .addGap(37, 37, 37)
                                    .addComponent(btnEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jconSuscrito, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jtpassw, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtDireccionsecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDireccionPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnEntrega, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(154, 154, 154))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void modelarTabla() {
        Object[] titus = {
            "idUsuario", "Nombre", "Apellido", "Email", "Direccion principal", "Direccion secundaria"
        };
        dtl.setColumnIdentifiers(titus);
        luser.setModel(dtl);
    }

    public void llenarTabla() {
        var users = uc.listarUser();

        dtl.setNumRows(0);

        for (Usuario usuario : users) {

            Object[] us = {
                usuario.getId(), usuario.getNombre(), usuario.getApellidos(), usuario.getCorreoElectronico(), usuario.getDireccionPrincipal(), usuario.getDireccionSecundaria()
            };

            dtl.addRow(us);

        }
    }


    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (jtNombre.getText().isEmpty() || jtApellido.getText().isEmpty() || jtpassw.getPassword().length == 0 || jtEmail.getText().isEmpty() || jtDireccionPrincipal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los campos con asteriscos son obligatorios");
        } else {
            Matcher mather = pat.matcher(jtEmail.getText().trim());
            if (mather.find() == true) {

                user.setNombre(jtNombre.getText());
                user.setApellidos(jtApellido.getText());
                user.setPassw(String.valueOf(jtpassw.getPassword()));
                user.setCorreoElectronico(jtEmail.getText());

                user.setSuscripto(jconSuscrito.getSelectedItem().toString());
                user.setDireccionPrincipal(jtDireccionPrincipal.getText());
                user.setDireccionSecundaria(jtDireccionsecundaria.getText());
                user.setIdCiudad(comCiudad.getSelectedIndex() + 1);
                user.setIdPregunta(cmbPregunta.getSelectedIndex()+1);
                user.setRespuesta(jtRespuesta.getText().trim());
                if (uc.vericarcarEmails(user)) {
                    JOptionPane.showMessageDialog(null, "Email ya se encuentra enlazado a una cuenta");
                } else {
                    if (uc.registrarUser(user)) {
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                        jtNombre.setText(null);
                        jtApellido.setText(null);
                        jtpassw.setText(null);
                        jtEmail.setText(null);
                        jtDireccionPrincipal.setText(null);
                        jtDireccionsecundaria.setText(null);
                        user.setIdPregunta(cmbPregunta.getSelectedIndex() + 1);
                        user.setRespuesta(jtRespuesta.getText().trim());

                        llenarTabla();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Email invalido");
            }
        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (luser.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione el usuario a actualizar");
        } else {
            setVisible(false);
            VistaActualizarUsuario au = new VistaActualizarUsuario();
            au.setVisible(true);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBusquedaKeyReleased
        if (jtBusqueda.getText().isEmpty()) {
            llenarTabla();
        } else {
            var users = uc.busquedaUsuario(jtBusqueda.getText().strip());
            if (users.isEmpty()) {

                dtl.setNumRows(0);

            } else {
                dtl.setNumRows(0);

                for (Usuario usuario : users) {

                    Object[] us = {
                        usuario.getId(), usuario.getNombre(), usuario.getApellidos(), usuario.getCorreoElectronico(), usuario.getDireccionPrincipal(), usuario.getDireccionSecundaria()
                    };

                    dtl.addRow(us);

                }
            }
        }
    }//GEN-LAST:event_jtBusquedaKeyReleased

    private void luserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_luserMouseClicked
        listaU.removeAll(listaU);
        listaU.add(luser.getValueAt(luser.getSelectedRow(), 0));
        listaU.add(luser.getValueAt(luser.getSelectedRow(), 1));
        listaU.add(luser.getValueAt(luser.getSelectedRow(), 2));
        listaU.add(luser.getValueAt(luser.getSelectedRow(), 3));
        listaU.add(luser.getValueAt(luser.getSelectedRow(), 4));
        listaU.add(luser.getValueAt(luser.getSelectedRow(), 5));
    }//GEN-LAST:event_luserMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (luser.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione el usuario a eliminar");
        } else {
            int w = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea eliminar el usuario seleccionado?");
            if (w == 0) {
                Usuario user = new Usuario();
                user.setCorreoElectronico(luser.getValueAt(luser.getSelectedRow(), 3).toString().trim());
                uc.elimanrUsuario(user);
                llenarTabla();
            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregaActionPerformed
        if (luser.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Seleccione el usuario al cual se le asignará la entrega");
        } else {
            setVisible(false);
            VistaEntrega ve = new VistaEntrega();
            ve.setVisible(true);
        }
    }//GEN-LAST:event_btnEntregaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vistaproyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbPregunta;
    private javax.swing.JComboBox<String> comCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jconSuscrito;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtBusqueda;
    private javax.swing.JTextField jtDireccionPrincipal;
    private javax.swing.JTextField jtDireccionsecundaria;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtRespuesta;
    private javax.swing.JPasswordField jtpassw;
    private javax.swing.JTable luser;
    // End of variables declaration//GEN-END:variables

    private void llenarComCiudad() {

        for (Ciudad ciudad : cc.listarCiudades()) {
            comCiudad.addItem(ciudad.getNombreCiudad());
        }
    }

    private void llenarComPreguntas() {
        for (Pregunta pregunta : pc.listarPreguntas()) {
            cmbPregunta.addItem(pregunta.getPregunta());
        }
    }

}
