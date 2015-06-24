/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pr.nb.zip.wizard;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle.Messages;
import org.pr.nb.zip.UserSelections;

@Messages({
    "ExportZipVisualPanel1_NAME=Destination details",
    "ExportZipVisualPanel1.locationLabel.text=Location",
    "ExportZipVisualPanel1.fileNameLabel.text=File Name",
    "ExportZipVisualPanel1.jfilechooser.approvebutton.text=Select"
})
public final class ExportZipVisualPanel1 extends JPanel implements ComponentMessagingInterface {

    /**
     * Creates new form ExportZipVisualPanel1
     */
    public ExportZipVisualPanel1() {
        initComponents();
    }

    @Override
    public String getName() {
        return Bundle.ExportZipVisualPanel1_NAME();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        destinationFileNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        destinationDirectoryTextField = new javax.swing.JTextField();
        extensionLabel = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();

        jLabel1.setLabelFor(destinationFileNameTextField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, Bundle.ExportZipVisualPanel1_fileNameLabel_text());

        jLabel2.setLabelFor(destinationDirectoryTextField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, Bundle.ExportZipVisualPanel1_locationLabel_text());

        destinationDirectoryTextField.setText(org.openide.util.NbBundle.getMessage(ExportZipVisualPanel1.class, "ExportZipVisualPanel1.destinationDirectoryTextField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(extensionLabel, org.openide.util.NbBundle.getMessage(ExportZipVisualPanel1.class, "ExportZipVisualPanel1.extensionLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(browseButton, org.openide.util.NbBundle.getMessage(ExportZipVisualPanel1.class, "ExportZipVisualPanel1.browseButton.text")); // NOI18N
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(destinationFileNameTextField)
                    .addComponent(destinationDirectoryTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(extensionLabel)
                    .addComponent(browseButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {browseButton, extensionLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(destinationFileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extensionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(destinationDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(browseButton)))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {destinationDirectoryTextField, destinationFileNameTextField, extensionLabel, jLabel1, jLabel2});

    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        // TODO add your handling code here:
        String dirName = destinationDirectoryTextField.getText();
        if("".equals(dirName)){
            dirName = ".";
        }
        File curFile = new File(dirName);
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        chooser.setSelectedFile(curFile);
        chooser.setCurrentDirectory(curFile.getParentFile());
        chooser.setApproveButtonText(Bundle.ExportZipVisualPanel1_jfilechooser_approvebutton_text());
        int option = chooser.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            File selFile = chooser.getSelectedFile();
            FileObject fobj = FileUtil.toFileObject(selFile);
            destinationDirectoryTextField.setText(FileUtil.getFileDisplayName(fobj));
        }
        
    }//GEN-LAST:event_browseButtonActionPerformed
    @Override
    public void setValue(UserSelections selections) {
        this.selections = selections;
        //populate fields
        if (this.selections != null) {
            this.destinationFileNameTextField.setText(this.selections.getDestinationZipName());
            this.destinationDirectoryTextField.setText(FileUtil.getFileDisplayName(this.selections.getDestinationDirectory()));
            this.extensionLabel.setText("." + this.selections.getExtension());
        }
    }

    @Override
    public UserSelections getValue() {
        if (this.selections != null) {
            this.selections.setDestinationZipName(this.destinationFileNameTextField.getText());
            final String destinationDirectoryPath = destinationDirectoryTextField.getText();
            if (!"".equals(destinationDirectoryPath)) {
                File file = new File(destinationDirectoryPath);
                this.selections.setDestinationDirectory(FileUtil.toFileObject(file));
            }
        }
        return this.selections;
    }

    @Override
    public Boolean isPanelValid() {
        String archiveName = destinationFileNameTextField.getText();
        boolean verify1 = archiveName != null && !"".equals(archiveName);
        boolean verify2 = false;
        String destinationDirName = destinationDirectoryTextField.getText();
        if(destinationDirName != null && !"".equals(destinationDirName)){
            File file = new File(destinationDirName);
            FileObject obj = FileUtil.toFileObject(file);
            verify2 = !obj.isVirtual() && obj.isFolder() && obj.isValid();
        }
        return verify1 && verify2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JTextField destinationDirectoryTextField;
    private javax.swing.JTextField destinationFileNameTextField;
    private javax.swing.JLabel extensionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    private UserSelections selections;

}