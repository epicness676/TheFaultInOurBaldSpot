//Program title: The FaultInOurBaldSpot 
//Author: John Diemert
//Date: june 17th, 2019
//Program Description: surgeon simulator game

package JohnPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author John Diemert
 */
public class lost extends javax.swing.JFrame {
    int counter=0;
    /**
     * Creates new form lost
     */
    public lost() {
        //initializes components and images
        initComponents();
        myInitComponents(graveStone);
        //hides buttons
        retry.setVisible(false);
        quit.setVisible(false);
        goToIntro.setVisible(false);
        //creates font
        Font font1 = new Font("SansSerif", Font.BOLD, 25);
        Font font2 = new Font("SansSerif", Font.BOLD, 40);
        //sets text to buttons
        retry.setText("RETRY");
        quit.setText("QUIT");
        goToIntro.setText("GO TO INTRO");
        //hides labels
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        //sets text, font and colou to labels
        jLabel1.setText("J");
        jLabel1.setFont(font1);
        jLabel1.setForeground(Color.red);
        jLabel2.setText("O");
        jLabel2.setFont(font1);
        jLabel2.setForeground(Color.red);
        jLabel3.setText("E");
        jLabel3.setFont(font1);
        jLabel3.setForeground(Color.red);
        jLabel4.setText("L");
        jLabel4.setFont(font1);
        jLabel4.setForeground(Color.red);
        jLabel5.setText("YOU LOSE!!!");
        jLabel5.setFont(font2);
        jLabel5.setForeground(Color.red);
        //starts timer
        graveTimer();
    }
    //makes "joel" appear on tombstone very suspensfully 
     public void graveTimer() {
         //creates timer
        Timer graveStoneTimer = new Timer();
        TimerTask moveBox = new TimerTask() {
            public void run() {
                //increases timer
                counter++;
                //when counter equals two make the first letter appear, when the counter goes up again, show the next letter etc.
                if (counter == 2) {
                    jLabel1.setVisible(true);
                } else if (counter == 3) {
                      jLabel4.setVisible(true);
                } else if (counter == 4) {
                      jLabel3.setVisible(true);
                } else if (counter == 5) {
                      jLabel2.setVisible(true);
                } else if (counter == 6) {
                    //makes buttons appear once all the letters have
                     retry.setVisible(true);
                     quit.setVisible(true);
                     goToIntro.setVisible(true);
                }
            }
        };
        //goes at a fixed rate
        graveStoneTimer.scheduleAtFixedRate(moveBox, 1500, 1500);
    }
public void myInitComponents(javax.swing.JLabel jLabel1) {
        //Initialize a Buffered Image
        BufferedImage img = null;
        //catchs IOExceptions
        try {
            //sets incons to labels
            graveStone.setIcon(new ImageIcon((ImageIO.read(new File("graveStone.png"))).getScaledInstance(graveStone.getWidth(), graveStone.getHeight(), Image.SCALE_SMOOTH)));
            background.setIcon(new ImageIcon((ImageIO.read(new File("deathBg.jpg"))).getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));
            brayden.setIcon(new ImageIcon((ImageIO.read(new File("braydenNude.png"))).getScaledInstance(brayden.getWidth(), brayden.getHeight(), Image.SCALE_SMOOTH)));
            jamesGrave.setIcon(new ImageIcon((ImageIO.read(new File("graveStone.png"))).getScaledInstance(jamesGrave.getWidth(), jamesGrave.getHeight(), Image.SCALE_SMOOTH)));
            james.setIcon(new ImageIcon((ImageIO.read(new File("james.jpg"))).getScaledInstance(james.getWidth(), james.getHeight(), Image.SCALE_SMOOTH)));
            aaron.setIcon(new ImageIcon((ImageIO.read(new File("aaronJohnGame.jpg"))).getScaledInstance(aaron.getWidth(), aaron.getHeight(), Image.SCALE_SMOOTH)));
            john.setIcon(new ImageIcon((ImageIO.read(new File("john.jpg"))).getScaledInstance(john.getWidth(), john.getHeight(), Image.SCALE_SMOOTH)));
            alex.setIcon(new ImageIcon((ImageIO.read(new File("alex.jpg"))).getScaledInstance(alex.getWidth(), alex.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(JohnF.class
                    .getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        graveStone = new javax.swing.JLabel();
        brayden = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        james = new javax.swing.JLabel();
        jamesGrave = new javax.swing.JLabel();
        aaron = new javax.swing.JLabel();
        john = new javax.swing.JLabel();
        alex = new javax.swing.JLabel();
        retry = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        goToIntro = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(825, 423));
        setName("Form"); // NOI18N
        getContentPane().setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(lost.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(540, 280, 41, 40);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(580, 280, 41, 40);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(620, 280, 30, 40);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(670, 280, 30, 40);

        graveStone.setText(resourceMap.getString("graveStone.text")); // NOI18N
        graveStone.setName("graveStone"); // NOI18N
        getContentPane().add(graveStone);
        graveStone.setBounds(461, 231, 320, 172);

        brayden.setText(resourceMap.getString("brayden.text")); // NOI18N
        brayden.setName("brayden"); // NOI18N
        getContentPane().add(brayden);
        brayden.setBounds(160, 310, 80, 150);

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(290, 20, 390, 50);

        james.setText(resourceMap.getString("james.text")); // NOI18N
        james.setName("james"); // NOI18N
        getContentPane().add(james);
        james.setBounds(640, 160, 70, 70);

        jamesGrave.setText(resourceMap.getString("jamesGrave.text")); // NOI18N
        jamesGrave.setName("jamesGrave"); // NOI18N
        getContentPane().add(jamesGrave);
        jamesGrave.setBounds(600, 130, 140, 130);

        aaron.setText(resourceMap.getString("aaron.text")); // NOI18N
        aaron.setName("aaron"); // NOI18N
        getContentPane().add(aaron);
        aaron.setBounds(50, 224, 80, 80);

        john.setText(resourceMap.getString("john.text")); // NOI18N
        john.setName("john"); // NOI18N
        getContentPane().add(john);
        john.setBounds(50, 300, 90, 90);

        alex.setText(resourceMap.getString("alex.text")); // NOI18N
        alex.setName("alex"); // NOI18N
        getContentPane().add(alex);
        alex.setBounds(170, 220, 80, 90);

        retry.setText(resourceMap.getString("retry.text")); // NOI18N
        retry.setName("retry"); // NOI18N
        retry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retryMouseClicked(evt);
            }
        });
        getContentPane().add(retry);
        retry.setBounds(700, 50, 100, 26);

        quit.setText(resourceMap.getString("quit.text")); // NOI18N
        quit.setName("quit"); // NOI18N
        quit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quitMouseClicked(evt);
            }
        });
        getContentPane().add(quit);
        quit.setBounds(700, 80, 100, 26);

        goToIntro.setText(resourceMap.getString("goToIntro.text")); // NOI18N
        goToIntro.setName("goToIntro"); // NOI18N
        goToIntro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToIntroMouseClicked(evt);
            }
        });
        getContentPane().add(goToIntro);
        goToIntro.setBounds(700, 110, 100, 26);

        background.setText(resourceMap.getString("background.text")); // NOI18N
        background.setName("background"); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 840, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //if retry buttons is clicked
    private void retryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retryMouseClicked
       //calls main game form
       JohnF johnObject = new JohnF();
       johnObject.setVisible(true);
       //closes form
       this.dispose();
    }//GEN-LAST:event_retryMouseClicked
    //if quit button is clicked
    private void quitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quitMouseClicked
        //closes game      
        System.exit(0);
    }//GEN-LAST:event_quitMouseClicked
    //if go to intro is clicked
    private void goToIntroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToIntroMouseClicked
         //closes form
        this.dispose();
    }//GEN-LAST:event_goToIntroMouseClicked

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
            java.util.logging.Logger.getLogger(lost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aaron;
    private javax.swing.JLabel alex;
    private javax.swing.JLabel background;
    private javax.swing.JLabel brayden;
    private javax.swing.JButton goToIntro;
    private javax.swing.JLabel graveStone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel james;
    private javax.swing.JLabel jamesGrave;
    private javax.swing.JLabel john;
    private javax.swing.JButton quit;
    private javax.swing.JButton retry;
    // End of variables declaration//GEN-END:variables
}
