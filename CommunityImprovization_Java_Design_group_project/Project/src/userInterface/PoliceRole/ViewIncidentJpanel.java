/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.PoliceRole;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Area;
import Business.Organization.CitizenOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkRequest.AlertsWorkRequest;
import Business.WorkRequest.CitizenToPoliceWorkrequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Properties;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userInterface.CitizenRole.CitizenCrimeWorkArea;

/**
 *
 * @author pruth
 */
public class ViewIncidentJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewIncidentJpanel
     */
    JPanel userProcessContainer;
    UserAccount userAccount;
    CitizenToPoliceWorkrequest incident;
    Enterprise enterprise;

    public ViewIncidentJpanel(JPanel userProcessContainer, UserAccount userAccount, CitizenToPoliceWorkrequest incident, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.incident = incident;
        this.enterprise = enterprise;
        populateFields();
    }

    public void populateFields() {
        txtNetwork.setText(String.valueOf(incident.getNetwork()));
        txtArea.setText(String.valueOf(incident.getArea()));
        txtName.setText(incident.getName());
        txtPhn.setText(incident.getPhn());
        txtIncident.setText(incident.getIncidentType());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPhn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtArea = new javax.swing.JTextField();
        txtNetwork = new javax.swing.JTextField();
        txtIncident = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtActionTaken = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Network");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 83, 89, -1));

        jLabel9.setText("Area");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 125, 89, -1));

        jLabel1.setText("Sender");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 167, 89, -1));

        txtName.setEnabled(false);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 164, 232, -1));

        jLabel4.setText("Phone Number");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 209, -1, -1));

        txtPhn.setEnabled(false);
        add(txtPhn, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 206, 232, -1));

        jLabel5.setText("Crime Incident");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 251, 106, -1));

        btnBack.setText("<<HEAD BACK TO PREVIOUS PAGE");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 42, 315, -1));

        txtArea.setEnabled(false);
        add(txtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 122, 232, -1));

        txtNetwork.setEnabled(false);
        add(txtNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 80, 232, -1));

        txtIncident.setEnabled(false);
        add(txtIncident, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 248, 232, -1));

        jLabel2.setText("Action Taken");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 293, 106, -1));
        add(txtActionTaken, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 290, 232, -1));

        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 334, 176, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("VIEW INCIDENTS AND PROCESS");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 4, 832, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PoliceWorkAreaJPanel panel = (PoliceWorkAreaJPanel) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    public static void sendMail(String from, String password, String message, String to[]) {
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress(from));

            InternetAddress[] toAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }
            for (int i = 0; i < toAddress.length; i++) {
                mimeMessage.addRecipient(RecipientType.TO, toAddress[i]);
            }
            mimeMessage.setSubject("Crime alert");
            mimeMessage.setText(message);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        if (txtActionTaken.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Mention The Action Taken", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            incident.setActionTaken(txtActionTaken.getText());
            incident.setStatus("Processed");
            Area area = incident.getArea();

            AlertsWorkRequest alert = new AlertsWorkRequest();
            alert.setCrimeType(incident.getIncidentType());
            alert.setArea(area);
            alert.setSender(userAccount);
            alert.setAlertStatus("New, Unread");
            alert.setMessage("New, Unread");

            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof CitizenOrganization) {
                    org = organization;
                    break;
                }
            }

            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(alert);
                for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
                    if (emp.getEmail() != null) {
                        if (emp.getArea().equals(area)) {
                            String[] to = {emp.getEmail()};
                            sendMail("donotreply829@gmail.com", "balu1994", "There was a " + incident.getIncidentType() + "in " + area + " . Please be safe.", to);
                        }
                    }

                }
                //userAccount.getWorkQueue().getWorkRequestList().add(patrolRequest);
            }

            JOptionPane.showMessageDialog(this, "ALERTS SENT TO CITIZENS IN THE AREA", "SUCCESS!!", JOptionPane.INFORMATION_MESSAGE);
            txtActionTaken.setEnabled(false);
            btnSubmit.setEnabled(false);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtActionTaken;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtIncident;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNetwork;
    private javax.swing.JTextField txtPhn;
    // End of variables declaration//GEN-END:variables
}
