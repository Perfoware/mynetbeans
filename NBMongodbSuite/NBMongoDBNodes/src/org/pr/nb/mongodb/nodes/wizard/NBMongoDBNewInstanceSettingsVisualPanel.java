/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pr.nb.mongodb.nodes.wizard;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import org.apache.commons.lang.StringUtils;
import org.openide.WizardDescriptor;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle;
import org.pr.nb.mongodb.component.PropertyNames;
import org.pr.nb.mongodb.data.NBMongoDBInstance;
import org.pr.nb.nb.mongodb.NBMongoSupportFactory;

@NbBundle.Messages({
    "# {0} - host",
    "# {1} - port number",
    "ERROR_COULD_NOT_CONNECT=Conection to host {0} and port {1} failed or is not tested",
    "# {0} - host",
    "# {1} - port number",
    "SUCCESSFULLY_CONNECTED=Conection to host {0} and port {1} success",
    "STEP1_NAME=Step #1: Settings",
    "ERROR_EMPTY_PORT=Port number cannot be blank",
    "ERROR_EMPTY_HOSTNAME=Hostname cannot be blank"

})
public final class NBMongoDBNewInstanceSettingsVisualPanel extends JPanel implements WizardMessagingInterface {

    /**
     * Creates new form NBMongoDBNewInstanceVisualPanel1
     */
    public NBMongoDBNewInstanceSettingsVisualPanel() {
        changeSupport = new ChangeSupport(this);
        initComponents();
        Document prtDoc = portTextField.getDocument();
        if (prtDoc instanceof PlainDocument) {
            ((PlainDocument) prtDoc).setDocumentFilter(new WholeNumberDocumentFilter());
        }
    }

    @Override
    public String getName() {
        return Bundle.STEP1_NAME();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        displayNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        hostTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        testButton = new javax.swing.JButton();
        testProgressBar = new javax.swing.JProgressBar();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NBMongoDBNewInstanceSettingsVisualPanel.class, "NBMongoDBNewInstanceSettingsVisualPanel.jLabel1.text")); // NOI18N

        DocumentListener wizardDocumentListener = new DocumentListenerImpl();
        displayNameTextField.setText(org.openide.util.NbBundle.getMessage(NBMongoDBNewInstanceSettingsVisualPanel.class, "NBMongoDBNewInstanceSettingsVisualPanel.displayNameTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(NBMongoDBNewInstanceSettingsVisualPanel.class, "NBMongoDBNewInstanceSettingsVisualPanel.jLabel2.text")); // NOI18N

        hostTextField.setText("127.0.0.1");

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(NBMongoDBNewInstanceSettingsVisualPanel.class, "NBMongoDBNewInstanceSettingsVisualPanel.jLabel3.text")); // NOI18N

        portTextField.setText("27017"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(NBMongoDBNewInstanceSettingsVisualPanel.class, "NBMongoDBNewInstanceSettingsVisualPanel.jLabel4.text")); // NOI18N

        userNameTextField.setEditable(false);
        userNameTextField.setText("user"); // NOI18N
        userNameTextField.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(NBMongoDBNewInstanceSettingsVisualPanel.class, "NBMongoDBNewInstanceSettingsVisualPanel.jLabel5.text")); // NOI18N

        passwordField.setEditable(false);
        passwordField.setText(org.openide.util.NbBundle.getMessage(NBMongoDBNewInstanceSettingsVisualPanel.class, "NBMongoDBNewInstanceSettingsVisualPanel.passwordField.text")); // NOI18N
        passwordField.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(testButton, org.openide.util.NbBundle.getMessage(NBMongoDBNewInstanceSettingsVisualPanel.class, "NBMongoDBNewInstanceSettingsVisualPanel.testButton.text")); // NOI18N
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(displayNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(testButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, testButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {displayNameTextField, hostTextField, passwordField, portTextField, userNameTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(displayNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {displayNameTextField, hostTextField, jLabel1, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, passwordField, portTextField, userNameTextField});

        displayNameTextField.getDocument().addDocumentListener(wizardDocumentListener);
        hostTextField.getDocument().addDocumentListener(wizardDocumentListener);
        portTextField.getDocument().addDocumentListener(wizardDocumentListener);
        userNameTextField.getDocument().addDocumentListener(wizardDocumentListener);
        passwordField.getDocument().addDocumentListener(wizardDocumentListener);
        showProgress(false);
    }// </editor-fold>//GEN-END:initComponents

    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
        // TODO add your handling code here:
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    settings.putProperty(WizardDescriptor.PROP_INFO_MESSAGE, "");
                    showProgress(true);
                    String host = hostTextField.getText();
                    String prttext = portTextField.getText();
                    int port = 0;
                    try {
                        port = Integer.parseInt(prttext);
                    } catch (NumberFormatException e) {
                        port = 27017;
                    }
                    MongoClient client = NBMongoSupportFactory.getInstance().connect(host, port, null,null);
                    client.listDatabases();
                    settings.putProperty(WizardDescriptor.PROP_INFO_MESSAGE, Bundle.SUCCESSFULLY_CONNECTED(hostTextField.getText(), portTextField.getText()));
                    connectionOK = true;
                    changeSupport.fireChange();
                } catch (Exception e) {
                    connectionOK = false;
                    settings.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, Bundle.ERROR_COULD_NOT_CONNECT(hostTextField.getText(), portTextField.getText()));
                } finally {
                    showProgress(false);
                }
            }
        });
    }//GEN-LAST:event_testButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField displayNameTextField;
    private javax.swing.JTextField hostTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField portTextField;
    private javax.swing.JButton testButton;
    private javax.swing.JProgressBar testProgressBar;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables

    private WizardDescriptor settings;
    private boolean connectionOK = false;
    private ChangeSupport changeSupport;

    @Override
    public void readSettings(WizardDescriptor wiz) {
        this.settings = wiz;
        NBMongoDBInstance instance = (NBMongoDBInstance) wiz.getProperty(WizardMessagingInterface.KEY_USER_SETTINGS);
        setValuesInUI(instance);
        // use wiz.getProperty to retrieve previous panel state

    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        this.settings = wiz;
        NBMongoDBInstance instance = (NBMongoDBInstance) wiz.getProperty(WizardMessagingInterface.KEY_USER_SETTINGS);
        storeValues(instance);
        // use wiz.putProperty to remember current panel state
    }

    @Override
    public boolean isPanelValid() {
        boolean retValue = checkData();
        if (retValue) {
            if (connectionOK) {
                settings.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, null);
            } else {
                settings.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, Bundle.ERROR_COULD_NOT_CONNECT(hostTextField.getText(), portTextField.getText()));
            }
        }
        retValue = connectionOK;
        if (retValue) {
            NBMongoDBInstance instance = (NBMongoDBInstance) settings.getProperty(WizardMessagingInterface.KEY_USER_SETTINGS);
            settings.putProperty(PropertyNames.NEW_MONGODB_WIZARD_INSTANCE.name(), instance);
        }
        return retValue;
    }

    private void setValuesInUI(NBMongoDBInstance instance) {
        if (instance == null) {
            return;
        }

        hostTextField.setText(instance.getHostName());
        portTextField.setText(instance.getPortNumber() + "");
        userNameTextField.setText(instance.getUserName());
        displayNameTextField.setText(instance.getDisplayName());
        passwordField.setText(instance.getPassword());
    }

    private void storeValues(NBMongoDBInstance instance) {
        if (instance == null) {
            return;
        }
        instance.setHostName(hostTextField.getText());
        instance.setPortNumber(Integer.parseInt(portTextField.getText()));
        instance.setUserName(userNameTextField.getText());
        instance.setDisplayName(displayNameTextField.getText());
        instance.setPassword(new String(passwordField.getPassword()));
    }

    private void showProgress(boolean show) {
        this.testProgressBar.setIndeterminate(show);
        this.testProgressBar.setVisible(show);
    }

    private boolean checkData() {
        boolean retValue = StringUtils.isNotEmpty(hostTextField.getText());
        if (retValue) {
            retValue = StringUtils.isNotEmpty(portTextField.getText());
            if (retValue) {
                settings.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, Bundle.ERROR_EMPTY_PORT());
            }
        } else {
            settings.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, Bundle.ERROR_EMPTY_HOSTNAME());
        }
        if (retValue) {
            settings.putProperty(WizardDescriptor.PROP_ERROR_MESSAGE, null);
        }
        return retValue;
    }

    private class DocumentListenerImpl implements DocumentListener {

        public DocumentListenerImpl() {
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            changeSupport.fireChange();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            changeSupport.fireChange();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            changeSupport.fireChange();
        }
    }

    public void addChangeListener(ChangeListener l) {
        changeSupport.addChangeListener(l);
    }

    public void removeChangeListener(ChangeListener l) {
        changeSupport.removeChangeListener(l);
    }
}
