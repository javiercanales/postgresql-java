/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Consultas;
import Clases.Modificaciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class VentanaEliminarEnfermedadesTuristas extends javax.swing.JFrame {
    public Modificaciones modificacion;
    public Consultas consulta;
    public String updateSQL;
    public String RUT;
    public ResultSet rs;
    
    public void setModificacion(Modificaciones modificacion) {
        this.modificacion = modificacion;
    }

    public void setConsulta(Consultas consulta) {
        this.consulta = consulta;
    }
    
    public JComboBox<String> getVerTuristas() {
        return verTuristas;
    }
    public JComboBox<String> getVerEnfermedadesTurista() {
        return verEnfermedadesTurista;
    }
    /**
     * Creates new form VentanaEliminarEnfermedadesTuristas
     */
    public VentanaEliminarEnfermedadesTuristas() {
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

        verTuristas = new javax.swing.JComboBox<>();
        seleccionarTurista = new javax.swing.JButton();
        verEnfermedadesTurista = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        eliminarEnfermedadTurista = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tituloElegirTour = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        seleccionarTurista.setText("Seleccionar");
        seleccionarTurista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarTuristaActionPerformed(evt);
            }
        });

        jLabel2.setText("Por favor, seleccione la Enfermedad a eliminar:");

        eliminarEnfermedadTurista.setText("Eliminar");
        eliminarEnfermedadTurista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarEnfermedadTuristaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Menú para eliminar Enfermedades de un Turista");

        tituloElegirTour.setText("Por favor, seleccione el Turista:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eliminarEnfermedadTurista)
                            .addComponent(seleccionarTurista)
                            .addComponent(tituloElegirTour)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verEnfermedadesTurista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verTuristas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(110, 110, 110))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addComponent(tituloElegirTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verTuristas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(seleccionarTurista)
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verEnfermedadesTurista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarEnfermedadTurista)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarTuristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarTuristaActionPerformed
        try {
            int n = verTuristas.getSelectedItem().toString().length();
            //seleccionar RUT desde el combobox (RUT al final)
            RUT = verTuristas.getSelectedItem().toString().substring(n-11, n);
            if(Character.isDigit(verTuristas.getSelectedItem().toString().charAt(n-12))){
                RUT = verTuristas.getSelectedItem().toString().substring(n-12, n);
            }

            //Consulta para llenar combobox con Nombre y Código de las Enfermedades.
            String consultaEnfermedadesTuristaSQL = "SELECT E.descrip_enfermedad, E.cod_enfermedad "
            + "FROM Enfermedades E, Padecen P "
            + "WHERE E.cod_enfermedad = P.cod_enfermedad AND P.RUT_turista = '" + RUT +"'";

            rs = consulta.hacerConsulta(consultaEnfermedadesTuristaSQL);
            while(rs.next()){
                getVerEnfermedadesTurista().addItem(rs.getString("descrip_enfermedad") + " - " + rs.getString("cod_enfermedad"));
            }

            if(getVerEnfermedadesTurista().getItemCount() == 0){
                JOptionPane.showMessageDialog(null, "No hay Guías en el Tour especificado.");
                this.setVisible(false);
            }

            tituloElegirTour.setText(verTuristas.getSelectedItem().toString());
            verTuristas.setVisible(false);
            seleccionarTurista.setVisible(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar." + ex.getMessage());
        }
    }//GEN-LAST:event_seleccionarTuristaActionPerformed

    private void eliminarEnfermedadTuristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarEnfermedadTuristaActionPerformed
        int n = verEnfermedadesTurista.getSelectedItem().toString().length();

        //seleccionar RUT desde el combobox (RUT al final)
        String IDe = verEnfermedadesTurista.getSelectedItem().toString().substring(n-1, n);
        if(Character.isDigit(verEnfermedadesTurista.getSelectedItem().toString().charAt(n-2))){
            IDe = verEnfermedadesTurista.getSelectedItem().toString().substring(n-2, n);
        }

        updateSQL = "DELETE FROM Padecen "
        + "WHERE RUT_turista = '"+ RUT +"' AND cod_enfermedad = "+IDe;

        modificacion.hacerModificacion(updateSQL);

        this.setVisible(false);
    }//GEN-LAST:event_eliminarEnfermedadTuristaActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaEliminarEnfermedadesTuristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminarEnfermedadesTuristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminarEnfermedadesTuristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminarEnfermedadesTuristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEliminarEnfermedadesTuristas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarEnfermedadTurista;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton seleccionarTurista;
    private javax.swing.JLabel tituloElegirTour;
    private javax.swing.JComboBox<String> verEnfermedadesTurista;
    private javax.swing.JComboBox<String> verTuristas;
    // End of variables declaration//GEN-END:variables
}