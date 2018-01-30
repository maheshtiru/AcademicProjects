/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CitizenOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mahes
 */
public class CitizenJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CitizenJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization inOrganization;
    private Enterprise inEnterprise;
    private EcoSystem system;
    private Network inNetwork;

    public CitizenJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization inOrganization,
            Enterprise inEnterprise, EcoSystem system, Network inNetwork) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
       /* this.inOrganization = inOrganization;
        this.inEnterprise = inEnterprise;*/
        this.system = system;
        this.inNetwork = inNetwork;

        populateCombo();
    }

    private void populateCombo() {
        comboEnterprise.removeAllItems();
        for (Enterprise ent : inNetwork.getEnterpriseDirectory().getEnterpriseList()) {
            comboEnterprise.addItem(ent);
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

        jLabel1 = new javax.swing.JLabel();
        btnContinue = new javax.swing.JButton();
        comboEnterprise = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Select An Enterprise");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 113, -1, -1));

        btnContinue.setText("Continue>>");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        add(btnContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 303, -1, -1));

        comboEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 214, 149, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        // TODO add your handling code here:
        inEnterprise = (Enterprise) comboEnterprise.getSelectedItem();
        //Enterprise.EnterpriseType e = inEnterprise.getEnterpriseType();
        
        for(Organization org:inEnterprise.getOrganizationDirectory().getOrganizationList()){
            if(org instanceof CitizenOrganization){
                inOrganization=org;
            }
        }

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("citizenWorkArea", userAccount.getRole().createWorkArea(userProcessContainer, userAccount,
                inOrganization, inEnterprise, system, inNetwork));
        layout.next(userProcessContainer);
        
        MainJFrame mainf = (MainJFrame) SwingUtilities.getRoot(this);
        mainf.fillLogInDetails(inOrganization, inEnterprise, inNetwork,userAccount);
        
        mainf.logInBtnPress();
    }//GEN-LAST:event_btnContinueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JComboBox comboEnterprise;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
