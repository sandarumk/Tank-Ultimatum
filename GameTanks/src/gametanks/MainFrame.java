/*
 * MainFrame.java
 *
 * Created on August 2, 2013, 2:06 PM
 */

package gametanks;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author  Dayathri
 */
public class MainFrame extends javax.swing.JFrame {

//    public static JPanel boardPanel = new JPanel(new GridLayout(10, 10, 2, 2));
    public static JLabel pieces[] = new JLabel[7];
    public static int[][] pointsTable;
    public static String[][] map;
    public static BufferedImage[][] images;
    public static final int SIZE = 20;
    private static JLabel[][] boardLabels = new JLabel[SIZE][SIZE];

    public MainFrame() {
        initComponents();
        this.setResizable(false);
    }
    
    public void loadImage(String[][] mapt) {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(mapt[i][j]!= null){
                if(mapt[i][j].equalsIgnoreCase("B")) {
                    pieces[0] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Resources/brick.png"));
                    boardLabels[i][j] = pieces[0];
                    gameBoard.add(boardLabels[i][j]);
                } else if(mapt[i][j].equalsIgnoreCase("W")) {
                    pieces[1] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Resources/water.png"));
                    boardLabels[i][j] = pieces[1];
                    gameBoard.add(boardLabels[i][j]);
                } else if(mapt[i][j].equalsIgnoreCase("S")) {
                    pieces[2] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Resources/stone.png"));
                    boardLabels[i][j] = pieces[2];
                    gameBoard.add(boardLabels[i][j]);
                } else if(mapt[i][j].equalsIgnoreCase("C")) {
                    pieces[3] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Resources/coinP.png"));
                    boardLabels[i][j] = pieces[3];
                    gameBoard.add(boardLabels[i][j]);
                } else if(mapt[i][j].equalsIgnoreCase("L")) {
                    pieces[4] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Resources/life.png"));
                    boardLabels[i][j] = pieces[4];
                    gameBoard.add(boardLabels[i][j]);
                } else if(mapt[i][j].equalsIgnoreCase("P")) {
                    pieces[5] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Resources/tank.png"));
                    boardLabels[i][j] = pieces[5];
                    gameBoard.add(boardLabels[i][j]);
                } else if(mapt[i][j].equalsIgnoreCase("V")) {
                    pieces[6] = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Resources/init.png"));
                    boardLabels[i][j] = pieces[6];
                    gameBoard.add(boardLabels[i][j]);
                }
                }
            }
        }
    }
    
    public static void getTable(int[][] pointsTab) {
            int num = 4;
         
         for(int i = 0; i < num; i++) {
             if(i == 0) {
                 p1Coins.setText(String.valueOf(pointsTab[0][0]));
                 p1Points.setText(String.valueOf(pointsTab[0][1]));
                 p1Health.setText(String.valueOf(pointsTab[0][2]));
             }
             else if(i == 1) {
                 p2Coins.setText(String.valueOf(pointsTab[1][0]));
                 p2Points.setText(String.valueOf(pointsTab[1][1]));
                 p2Health.setText(String.valueOf(pointsTab[1][2]));
             }
             else if(i == 2) {
                 p3Coins.setText(String.valueOf(pointsTab[2][0]));
                 p3Points.setText(String.valueOf(pointsTab[2][1]));
                 p3Health.setText(String.valueOf(pointsTab[2][2]));
             }
             else if(i == 3) {
                 p4Coins.setText(String.valueOf(pointsTab[3][0]));
                 p4Points.setText(String.valueOf(pointsTab[3][1]));
                 p4Health.setText(String.valueOf(pointsTab[3][2]));
             }
             else if(i == 4) {
                 p5Coins.setText(String.valueOf(pointsTab[4][0]));
                 p5Points.setText(String.valueOf(pointsTab[4][1]));
                 p5Health.setText(String.valueOf(pointsTab[4][2]));
             }
         }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pointTable = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        player = new javax.swing.JLabel();
        health = new javax.swing.JLabel();
        coins = new javax.swing.JLabel();
        points = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        p1Health = new javax.swing.JTextField();
        p2Health = new javax.swing.JTextField();
        p3Health = new javax.swing.JTextField();
        p4Health = new javax.swing.JTextField();
        p5Health = new javax.swing.JTextField();
        p1Coins = new javax.swing.JTextField();
        p2Coins = new javax.swing.JTextField();
        p3Coins = new javax.swing.JTextField();
        p4Coins = new javax.swing.JTextField();
        p5Coins = new javax.swing.JTextField();
        p1Points = new javax.swing.JTextField();
        p2Points = new javax.swing.JTextField();
        p3Points = new javax.swing.JTextField();
        p4Points = new javax.swing.JTextField();
        p5Points = new javax.swing.JTextField();
        gameBoard = new javax.swing.JPanel(new GridLayout(10, 10, 0, 0));
        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 680));
        getContentPane().setLayout(null);

        pointTable.setBackground(new java.awt.Color(0, 153, 0));
        pointTable.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 24)); // NOI18N
        jLabel2.setText("Point Table");

        player.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        player.setText("Player");

        health.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        health.setText("Health");

        coins.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        coins.setText("Coins");

        points.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        points.setText("Points");

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel3.setText("Player 1");

        jLabel4.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel4.setText("Player 2");

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel5.setText("Player 3");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel6.setText("Player 4");

        jLabel7.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel7.setText("Player 5");

        p1Health.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p1Health.setText("0");
        p1Health.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p1HealthActionPerformed(evt);
            }
        });

        p2Health.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p2Health.setText("0");
        p2Health.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2HealthActionPerformed(evt);
            }
        });

        p3Health.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p3Health.setText("0");
        p3Health.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p3HealthActionPerformed(evt);
            }
        });

        p4Health.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p4Health.setText("0");
        p4Health.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p4HealthActionPerformed(evt);
            }
        });

        p5Health.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p5Health.setText("0");
        p5Health.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p5HealthActionPerformed(evt);
            }
        });

        p1Coins.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p1Coins.setText("0");

        p2Coins.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p2Coins.setText("0");

        p3Coins.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p3Coins.setText("0");

        p4Coins.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p4Coins.setText("0");

        p5Coins.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p5Coins.setText("0");

        p1Points.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p1Points.setText("0");

        p2Points.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p2Points.setText("0");

        p3Points.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p3Points.setText("0");

        p4Points.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p4Points.setText("0");

        p5Points.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        p5Points.setText("0");

        javax.swing.GroupLayout pointTableLayout = new javax.swing.GroupLayout(pointTable);
        pointTable.setLayout(pointTableLayout);
        pointTableLayout.setHorizontalGroup(
            pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pointTableLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pointTableLayout.createSequentialGroup()
                        .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pointTableLayout.createSequentialGroup()
                                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(player)
                                    .addComponent(jLabel7))
                                .addGap(28, 28, 28)
                                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(p5Health, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(p1Health)
                                        .addComponent(health, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(p2Health)
                                        .addComponent(p3Health)
                                        .addComponent(p4Health))))
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p2Coins, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p3Coins, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p4Coins, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p5Coins, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p1Coins, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coins))))
                .addGap(18, 18, 18)
                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(points)
                    .addComponent(p1Points, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p5Points, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p4Points, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3Points, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2Points, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        pointTableLayout.setVerticalGroup(
            pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pointTableLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player)
                    .addComponent(points)
                    .addComponent(coins)
                    .addComponent(health))
                .addGap(25, 25, 25)
                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(p1Coins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1Points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1Health, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(p2Coins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2Points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2Health, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(p3Coins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3Points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p3Health, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(p4Coins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p4Points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p4Health, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pointTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p5Coins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(p5Points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p5Health, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(pointTable);
        pointTable.setBounds(590, 160, 330, 320);

        gameBoard.setBackground(new java.awt.Color(0, 0, 0));
        gameBoard.setMinimumSize(new java.awt.Dimension(400, 400));
        gameBoard.setLayout(new java.awt.GridLayout(20, 20, 2, 2));
        getContentPane().add(gameBoard);
        gameBoard.setBounds(40, 100, 540, 440);

        exitButton.setFont(new java.awt.Font("Perpetua Titling MT", 1, 18)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton);
        exitButton.setBounds(660, 550, 110, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/back.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setAlignmentX(5.0F);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 1030, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void p1HealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p1HealthActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_p1HealthActionPerformed

private void p2HealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2HealthActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_p2HealthActionPerformed

private void p3HealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p3HealthActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_p3HealthActionPerformed

private void p4HealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p4HealthActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_p4HealthActionPerformed

private void p5HealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p5HealthActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_p5HealthActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
        DataStore.isFinished = true;
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
    @Test Case
    */
//    public static void main(String args[]) {
//        
//        final String[][] map = {
//            {"B", "V", "V", "W", "V", "V", "V", "V", "V", "V", "B", "V", "V", "W", "V", "V", "V", "V", "V", "V"},
//            {"V", "V", "B", "V", "V", "V", "W", "V", "W", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "V", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "V", "V", "V", "V", "V", "V", "V", "S", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"S", "V", "W", "V", "V", "S", "V", "V", "W", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "V", "V", "V", "W", "P", "V", "V", "W", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "V", "V", "V", "V", "V", "W", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"W", "V", "W", "V", "P", "V", "V", "V", "S", "B", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"},
//            {"V", "W", "B", "V", "V", "V", "V", "V", "V", "V", "V", "V", "B", "V", "V", "V", "W", "V", "W", "V"}
//        };
//        
//        final int[][] points = {
//            {0, 0, 100},
//            {0, 0, 100},
//            {0, 0, 100},
//            {0, 0, 100},
//            {0, 0, 100},
//            {0, 0, 100},
//        };
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                    new MainFrame().setVisible(true);
//                    MainFrame.loadImage(map);
//                    MainFrame.getTable(points);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coins;
    private javax.swing.JButton exitButton;
    private static javax.swing.JPanel gameBoard;
    private javax.swing.JLabel health;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private static javax.swing.JTextField p1Coins;
    private static javax.swing.JTextField p1Health;
    private static javax.swing.JTextField p1Points;
    private static javax.swing.JTextField p2Coins;
    private static javax.swing.JTextField p2Health;
    private static javax.swing.JTextField p2Points;
    private static javax.swing.JTextField p3Coins;
    private static javax.swing.JTextField p3Health;
    private static javax.swing.JTextField p3Points;
    private static javax.swing.JTextField p4Coins;
    private static javax.swing.JTextField p4Health;
    private static javax.swing.JTextField p4Points;
    private static javax.swing.JTextField p5Coins;
    private static javax.swing.JTextField p5Health;
    private static javax.swing.JTextField p5Points;
    private javax.swing.JLabel player;
    private javax.swing.JPanel pointTable;
    private javax.swing.JLabel points;
    // End of variables declaration//GEN-END:variables

}
