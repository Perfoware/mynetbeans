/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pr.nb.crypto.wizard;

import java.io.File;
import java.util.Objects;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;
import org.pr.nb.crypto.UserInputs;

@NbBundle.Messages({
    "step.name2=Step #2: Summary",
})
public final class GenCertSummaryVisualPanel extends JPanel {

    private UserInputs inputs;

    /**
     * Creates new form GenCertVisualPanel1
     */
    public GenCertSummaryVisualPanel() {
        initComponents();
    }

    @Override
    public String getName() {
        return Bundle.step_name();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        aliasTextField = new javax.swing.JTextField();
        keySizeSpinner = new javax.swing.JSpinner();
        storePassPasswordField = new javax.swing.JPasswordField();
        keyPassPasswordField = new javax.swing.JPasswordField();
        storeTextField = new org.pr.nb.crypto.NBFileObjectTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(GenCertSummaryVisualPanel.class, "GenCertSummaryVisualPanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(GenCertSummaryVisualPanel.class, "GenCertSummaryVisualPanel.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(GenCertSummaryVisualPanel.class, "GenCertSummaryVisualPanel.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(GenCertSummaryVisualPanel.class, "GenCertSummaryVisualPanel.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(GenCertSummaryVisualPanel.class, "GenCertSummaryVisualPanel.jLabel5.text")); // NOI18N

        aliasTextField.setEditable(false);
        aliasTextField.setText(org.openide.util.NbBundle.getMessage(GenCertSummaryVisualPanel.class, "GenCertSummaryVisualPanel.aliasTextField.text")); // NOI18N

        keySizeSpinner.setModel(new javax.swing.SpinnerNumberModel(1024, 256, 2048, 64));

        storePassPasswordField.setEditable(false);
        storePassPasswordField.setText(org.openide.util.NbBundle.getMessage(GenCertSummaryVisualPanel.class, "GenCertSummaryVisualPanel.storePassPasswordField.text")); // NOI18N

        keyPassPasswordField.setEditable(false);
        keyPassPasswordField.setText(org.openide.util.NbBundle.getMessage(GenCertSummaryVisualPanel.class, "GenCertSummaryVisualPanel.keyPassPasswordField.text")); // NOI18N

        storeTextField.setEditable(false);
        storeTextField.setText(org.openide.util.NbBundle.getMessage(GenCertSummaryVisualPanel.class, "GenCertSummaryVisualPanel.storeTextField.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keySizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aliasTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(storePassPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(storeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPassPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {keyPassPasswordField, storePassPasswordField, storeTextField});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(aliasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(keySizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(storePassPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(keyPassPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(storeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {aliasTextField, jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, keyPassPasswordField, keySizeSpinner, storePassPasswordField, storeTextField});

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aliasTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField keyPassPasswordField;
    private javax.swing.JSpinner keySizeSpinner;
    private javax.swing.JPasswordField storePassPasswordField;
    private org.pr.nb.crypto.NBFileObjectTextField storeTextField;
    // End of variables declaration//GEN-END:variables

    void showSettings(UserInputs inputs) {
        this.inputs = inputs;
        setIfNotNull(aliasTextField, inputs.getAlias());
        setIfNotNull(keySizeSpinner, inputs.getKeySize());
        setIfNotNull(storePassPasswordField, inputs.getStorePass());
        setIfNotNull(keyPassPasswordField, inputs.getKeyPass());
        storeTextField.setValue(inputs.getKeyStore());
    }

    UserInputs getInputs() {
        return this.inputs;
    }

    private void setIfNotNull(JTextField textField, String text) {
        if(Objects.nonNull(text)){
            textField.setText(text);
        }
    }

    private void setIfNotNull(JSpinner keySizeSpinner, Integer value) {
        if(Objects.nonNull(value)){
            keySizeSpinner.setValue(value);
        }
    }

    private void setIfNotNull(JPasswordField passwordField, char[] value) {
        if(Objects.nonNull(value)){
            passwordField.setText(new String(value));
        }
    }

}