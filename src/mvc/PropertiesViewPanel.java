/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author V
 */
public class PropertiesViewPanel extends javax.swing.JFrame {

    /**
     * Creates new form PropertiesViewPanel
     */
    public PropertiesViewPanel() {
        this.controller = controller;

        initComponents();
        localInitialization();
    }

     // ‹editor-fold defaultstate="collapsed" desc=" Local Initialization "›

    /**
     * Used to provide local initialization of Swing components
     * outside of the NetBeans automatic code generator
     */
    public void localInitialization() {

        opacitySpinner.setModel(new SpinnerNumberModel(100, 0, 100, 1));
        opacitySlider.setModel(new DefaultBoundedRangeModel(100, 0, 0, 100));

        rotationSpinner.setModel(new SpinnerNumberModel(0, -180, 180, 1));
        rotationSlider.setModel(new DefaultBoundedRangeModel(0, 0, -180, 180));

        text.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                textDocumentChanged(e);
            }

            public void removeUpdate(DocumentEvent e) {
                textDocumentChanged(e);
            }

            public void changedUpdate(DocumentEvent e) {
                textDocumentChanged(e);
            }

        });

    }

    public void modelPropertyChange(final PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals(
                   DefaultController.ELEMENT_X_PROPERTY)) {
            String newStringValue = evt.getNewValue().toString();
            xPositionTextField.setText(newStringValue);
        } else if
           (evt.getPropertyName().equals(
                   DefaultController.ELEMENT_Y_PROPERTY)) {
            String newStringValue = evt.getNewValue().toString();
            yPositionTextField.setText(newStringValue);
        } else if
           (evt.getPropertyName().equals(
                   DefaultController.ELEMENT_OPACITY_PROPERTY)) {
            int newIntegerValue = (Integer)evt.getNewValue();
            opacitySpinner.setValue(newIntegerValue);
            opacitySlider.setValue(newIntegerValue);
        } else if
            (evt.getPropertyName().equals(
                   DefaultController.ELEMENT_ROTATION_PROPERTY)) {
            int newIntegerValue = (Integer)evt.getNewValue();
            rotationSpinner.setValue(newIntegerValue);
            rotationSlider.setValue(newIntegerValue);
        } else if
           (evt.getPropertyName().equals(
                   DefaultController.ELEMENT_TEXT_PROPERTY)) {
            String newStringValue = evt.getNewValue().toString();
            text.setText(newStringValue);
        } else if
           (evt.getPropertyName().equals(
                   DefaultController.ELEMENT_FONT_PROPERTY)) {
            Font f = (Font)evt.getNewValue();
            String fontString = f.getFontName() + " " + f.getSize();
            font.setText(fontString);
            currentFont = f;
        }

        //  Remainder of the code omitted
    }
    
     private void yPositionTextFieldFocusLost(java.awt.event.FocusEvent evt) {
        try {
            controller.changeElementYPosition(
                Integer.parseInt(yPositionTextField.getText()));
        } catch (Exception e) {
            //  Handle exception.
        }
    }

    private void yPositionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            controller.changeElementYPosition(
                Integer.parseInt(yPositionTextField.getText()));
        } catch (Exception e) {
            //  Handle exception.
        }
    }

    //  Code omitted -- code for xPosition
    //  is nearly the same as for yPosition.

    private void changeFontButtonActionPerformed(java.awt.event.ActionEvent evt) {

        JFontChooserDialog fontChooser = new
            JFontChooserDialog((Dialog)this.getTopLevelAncestor());
        fontChooser.setSelectedFont(currentFont);
        fontChooser.setVisible(true);

        Font returnedFont = fontChooser.getSelectedFont();
        if (returnedFont != null) {
            controller.changeElementFont(returnedFont);
        }
    }

    private void opacitySliderStateChanged(javax.swing.event.ChangeEvent evt) {
        controller.changeElementOpacity((int)opacitySlider.getValue());
    }

    private void rotationSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        controller.changeElementRotation((int)rotationSlider.getValue());
    }

    private void opacitySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {
        controller.changeElementOpacity((Integer)opacitySpinner.getValue());
    }

    private void rotationSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {
        controller.changeElementRotation((Integer)rotationSpinner.getValue());
    }

    private void textDocumentChanged(DocumentEvent evt) {

        Document document = evt.getDocument();
        try {
            controller.changeElementText(document.getText(0,
            document.getLength()));
        } catch (BadLocationException ex) {
            //  Handle exception.
        }
    }
    
    
public void modelPropertyChange(final PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals(DefaultController.ELEMENT_X_PROPERTY)) {

            String newStringValue = evt.getNewValue().toString();
            if (!xPositionTextField.getText().equals(newStringValue))
                xPositionTextField.setText(newStringValue);

        }

        //  Remaining code omitted

    }
    // ‹/editor-fold›
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PropertiesViewPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PropertiesViewPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PropertiesViewPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PropertiesViewPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PropertiesViewPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
