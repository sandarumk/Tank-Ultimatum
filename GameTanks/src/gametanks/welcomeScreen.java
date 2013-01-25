/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * welcomeScreen.java
 *
 * Created on Jan 25, 2013, 12:09:36 PM
 */
package gametanks;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class welcomeScreen extends javax.swing.JFrame {

    /** Creates new form welcomeScreen */
    public welcomeScreen() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomePanel = new javax.swing.JPanel();
        joinButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        welcomeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        captionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TANKS ULTIMATUM");

        welcomePanel.setBackground(new java.awt.Color(255, 51, 255));
        welcomePanel.setFont(new java.awt.Font("Chiller", 1, 18)); // NOI18N
        welcomePanel.setName("WelcomeScreen\n"); // NOI18N
        welcomePanel.setLayout(null);

        joinButton.setFont(new java.awt.Font("Pescadero", 1, 14)); // NOI18N
        joinButton.setText("JOIN");
        joinButton.setToolTipText("Click to join the game");
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });
        welcomePanel.add(joinButton);
        joinButton.setBounds(107, 228, 80, 25);

        exitButton.setFont(new java.awt.Font("Pescadero", 1, 18)); // NOI18N
        exitButton.setText("EXIT");
        exitButton.setToolTipText("Click to exit the game");
        exitButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        welcomePanel.add(exitButton);
        exitButton.setBounds(572, 228, 71, 23);

        welcomeLabel.setFont(new java.awt.Font("Viner Hand ITC", 3, 24)); // NOI18N
        welcomeLabel.setText("Welcome");
        welcomePanel.add(welcomeLabel);
        welcomeLabel.setBounds(390, 20, 112, 39);

        nameLabel.setBackground(new java.awt.Color(153, 153, 153));
        nameLabel.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        nameLabel.setText("TANKS ULTIMATUM");
        welcomePanel.add(nameLabel);
        nameLabel.setBounds(130, 70, 582, 58);

        captionLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        captionLabel.setText("Let the battle begin");
        welcomePanel.add(captionLabel);
        captionLabel.setBounds(410, 150, 230, 33);

        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gametanks/Act_of_War_-_Direct_Action.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        welcomePanel.add(jLabel1);
        jLabel1.setBounds(-10, -10, 750, 330);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        //connection to the game and send the join signal to the server
        Connection connect=new Connection();
        try {
            connect.joingame();
        } catch (UnknownHostException ex) {
            Logger.getLogger(welcomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(welcomeScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_joinButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new welcomeScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel captionLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton joinButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JPanel welcomePanel;
    // End of variables declaration//GEN-END:variables
}
