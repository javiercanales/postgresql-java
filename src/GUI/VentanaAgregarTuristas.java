/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Consultas;
import Clases.Modificaciones;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class VentanaAgregarTuristas extends javax.swing.JFrame {
    public Modificaciones modificacion;
    //Nótese que Modificaciones enlaza con la BD, por lo que no se requiere instancia de clases PostgreSQL ni Connection
    public Consultas consulta;
    
    public ResultSet rs;
    public String updateSQL;

    public void setModificacion(Modificaciones modificacion) {
        this.modificacion = modificacion;
    }

    public void setConsulta(Consultas consulta) {
        this.consulta = consulta;
    }
    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    /**
     * Creates new form VentanaAgregarTuristas
     */
    public VentanaAgregarTuristas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RUT = new javax.swing.JTextField();
        edadTurista = new javax.swing.JTextField();
        nombreTurista = new javax.swing.JTextField();
        nombreEmergencia = new javax.swing.JTextField();
        agregarTurista = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        asociarEnfermedad = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        telefonoEmergencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Menu para agregar un Turista");

        jLabel1.setText("RUT:");

        jLabel2.setText("Nombre completo:");

        jLabel3.setText("Nombre del contacto de emergencia:");

        jLabel5.setText("Teléfono del contacto de emergencia:");

        agregarTurista.setText("Agregar Turista");
        agregarTurista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTuristaActionPerformed(evt);
            }
        });

        jLabel6.setText("Edad:");

        asociarEnfermedad.setText("Asociar Enfermedad a Turista");
        asociarEnfermedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asociarEnfermedadActionPerformed(evt);
            }
        });

        jLabel7.setText("Si desea asociar una Enfermedad a un Turista, click en el botón:");

        jLabel9.setText("Presione el botón para agregar el Turista:");

        telefonoEmergencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoEmergenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(RUT)
                                .addComponent(edadTurista)
                                .addComponent(nombreTurista, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(asociarEnfermedad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreEmergencia, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(telefonoEmergencia)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(154, 154, 154)
                        .addComponent(agregarTurista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edadTurista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTurista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telefonoEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarTurista)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(asociarEnfermedad))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarTuristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTuristaActionPerformed
        //if(!validarRut(RUT.getText())){
        //    JOptionPane.showMessageDialog(null, "RUT con formato invalido. Por favor, revise y vuelva a probar.");
        //    return;
        //}
        
        updateSQL = "INSERT INTO Turistas(RUT_turista, nombre_turista, nombre_cont_emerg, telef_cont_emerg, edad_turista) "
        + "VALUES "
        + "('"
        + RUT.getText()+"', '"
        + nombreTurista.getText() + "', '"
        + nombreEmergencia.getText()+"', '"
        + telefonoEmergencia.getText()+"', "
        + edadTurista.getText() +")";

        try{
            modificacion.hacerModificacion(updateSQL);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al agregar.");
        }
    }//GEN-LAST:event_agregarTuristaActionPerformed

    private void asociarEnfermedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asociarEnfermedadActionPerformed
        try {
            VentanaAsociarEnfermedadesTuristas ventanaAsociarEnfermedadesTuristas = new VentanaAsociarEnfermedadesTuristas();
            ventanaAsociarEnfermedadesTuristas.setModificacion(modificacion);
            ventanaAsociarEnfermedadesTuristas.setConsulta(consulta);

            String consultaTuristasSQL = "SELECT nombre_turista, RUT_turista "
            + "FROM Turistas ";
            
            String consultaEnfermedadesSQL = "SELECT descrip_enfermedad, cod_enfermedad "
            + "FROM Enfermedades "
            + "ORDER BY cod_enfermedad";

            //Consulta para llenar combobox con Nombre y Código de los Lugares.
            rs = consulta.hacerConsulta(consultaTuristasSQL);
            while(rs.next()){
                ventanaAsociarEnfermedadesTuristas.getVerTuristas().addItem(rs.getString("nombre_turista") + " - RUT: " + rs.getString("RUT_turista"));
            }
            
            rs = consulta.hacerConsulta(consultaEnfermedadesSQL);
            while(rs.next()){
                ventanaAsociarEnfermedadesTuristas.getVerEnfermedades().addItem(rs.getString("descrip_enfermedad") + " - " + rs.getString("cod_enfermedad"));
            }
            
            ventanaAsociarEnfermedadesTuristas.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al agregar.");
        }
    }//GEN-LAST:event_asociarEnfermedadActionPerformed

    private void telefonoEmergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoEmergenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoEmergenciaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarTuristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarTuristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarTuristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarTuristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregarTuristas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RUT;
    private javax.swing.JButton agregarTurista;
    private javax.swing.JToggleButton asociarEnfermedad;
    private javax.swing.JTextField edadTurista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nombreEmergencia;
    private javax.swing.JTextField nombreTurista;
    private javax.swing.JTextField telefonoEmergencia;
    // End of variables declaration//GEN-END:variables
}