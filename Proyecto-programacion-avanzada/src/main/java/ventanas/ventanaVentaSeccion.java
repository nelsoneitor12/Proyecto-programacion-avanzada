/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import com.mycompany.avanzada.Bodega;
import com.mycompany.avanzada.TipoProducto;
import com.mycompany.avanzada.TipoSeccion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Sashi
 */
public class ventanaVentaSeccion extends javax.swing.JFrame {

    /**
     * Creates new form ventanaVentaSeccion
     */

    Bodega bodega;
    public ventanaVentaSeccion(Bodega bodega) throws FileNotFoundException {
        this.bodega = bodega;
        initComponents();
        this.generarComboBox1();
        Secciones.setSelectedIndex(-1);
    }
    

    
    public void generarComboBox1() throws FileNotFoundException{
        
        String[] opciones = new String[bodega.getMapa().size()];
        int i = 0;
        for(Map.Entry<String, TipoSeccion> r : bodega.getMapa().entrySet()) {
            opciones[i] = r.getValue().getNomSeccion();
            i++;
 	}
        Secciones.setModel(new javax.swing.DefaultComboBoxModel(opciones));
    }
    public void generarComboBox2() throws FileNotFoundException{
        if(Secciones.getSelectedItem() != null){
            //conseguir mapa de productos para asignar nombres a opciones de combobox2
            Map<String,TipoProducto> mapa = bodega.getMapa().get(Secciones.getSelectedItem()).getMapa();
            String[] opciones = new String[mapa.size()];
            int i = 0;
            for(Entry<String, TipoProducto> r : mapa.entrySet()) {
        	opciones[i] = r.getValue().getNombre();
    		i++;
            }
            Productos.setModel(new javax.swing.DefaultComboBoxModel(opciones));
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        bOkDialog = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Secciones = new javax.swing.JComboBox<>();
        Productos = new javax.swing.JComboBox<>();
        Slider = new javax.swing.JSlider();
        min = new javax.swing.JLabel();
        max = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel5.setText("Agregado! :)");

        bOkDialog.setText("Ok");
        bOkDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOkDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bOkDialog)
                .addContainerGap())
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel5)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(71, 71, 71)
                .addComponent(bOkDialog)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("X");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Secciones.setToolTipText("");
        Secciones.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SeccionesItemStateChanged(evt);
            }
        });
        Secciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeccionesActionPerformed(evt);
            }
        });

        Productos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ProductosItemStateChanged(evt);
            }
        });

        Slider.setMaximum(0);
        Slider.setPaintLabels(true);
        Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderStateChanged(evt);
            }
        });
        Slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SliderMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SliderMousePressed(evt);
            }
        });

        min.setText("0");

        max.setText("0");

        jLabel1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel1.setText("Seleccione la seccion del producto que busca");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel2.setText("Seleccione producto");

        jLabel3.setText("?");

        jLabel4.setText("Cantidad actual:");

        jButton3.setText("Finalizar compra");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Secciones, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(min)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(195, 195, 195))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(max)
                        .addGap(58, 58, 58))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(527, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Secciones, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(min)
                        .addComponent(max))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            // TODO add your handling code here:
            ppal ventana = new ppal();
            ventana.setVisible(true);
            ventana.init(bodega);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaVentaSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String sec = (String) Secciones.getSelectedItem();
        String prod = (String) Productos.getSelectedItem();
        Slider.getValue();
        try {
            bodega = bodega.Venta(sec,prod,Slider.getValue(), bodega);
        } catch (IOException ex) {
            Logger.getLogger(ventanaVentaSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) dim.getWidth();
        int screenHeight = (int) dim.getHeight();
        
        jDialog1.add( new JLabel ("Agregado! :)"));  
        jDialog1.setLocation(screenWidth / 2 - 150, screenHeight / 2 - 150);
        jDialog1.setSize(400,200);  
        jDialog1.setVisible(true);
         //setVisible(true);
        //bOkDialog; AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SeccionesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SeccionesItemStateChanged
        try {
            // TODO add your handling code here:
            generarComboBox2();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaVentaSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SeccionesItemStateChanged

    private void ProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ProductosItemStateChanged
        // TODO add your handling code here:
        //Slider = new javax.swing.JSlider();
        Slider.setMaximum(bodega.getMapa().get(Secciones.getSelectedItem()).getMapa().get(Productos.getSelectedItem()).getStock());
        if(bodega.getMapa().get(Secciones.getSelectedItem()).getMapa().get(Productos.getSelectedItem()).getStock()<=0){
            min.setText("0");
            Slider.setMinimum(0);
        }else{
            min.setText("1");
            Slider.setMinimum(1);
        }
        int maximo = bodega.getMapa().get(Secciones.getSelectedItem()).getMapa().get(Productos.getSelectedItem()).getStock();
        max.setText(Integer.toString(maximo));
        //Slider.setPaintTicks(true);
        //bodega.getMapa().get(Secciones.getSelectedItem()).getMapa().get(Productos.getSelectedItem()).getStock());
    }//GEN-LAST:event_ProductosItemStateChanged

    private void SliderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SliderMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SliderMouseClicked

    private void SliderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SliderMousePressed

    }//GEN-LAST:event_SliderMousePressed

    private void SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderStateChanged
        int num = Slider.getValue();
        jLabel3.setText(Integer.toString(num));
    }//GEN-LAST:event_SliderStateChanged

    private void bOkDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOkDialogActionPerformed
        // TODO add your handling code here:
        jDialog1.dispose();
    }//GEN-LAST:event_bOkDialogActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            bodega.finalizarVenta();

            ppal ventana = new ppal();
            ventana.init(bodega);
            ventana.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ventanaVentaSeccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ventanaVentaSeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SeccionesActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Productos;
    private javax.swing.JComboBox<String> Secciones;
    private javax.swing.JSlider Slider;
    private javax.swing.JButton bOkDialog;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel max;
    private javax.swing.JLabel min;
    // End of variables declaration//GEN-END:variables
}
