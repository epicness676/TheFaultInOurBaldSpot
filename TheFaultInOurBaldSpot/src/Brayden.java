/*
 * Written by Mr. van Straten
 * May 21, 2019
 * JFrameImages
 * This is a demo program for images and collision detection
 */


import java.awt.Component;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Brayden extends javax.swing.JFrame {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JLabel();
        wallLabel = new javax.swing.JLabel();
        wallLabel1 = new javax.swing.JLabel();
        pot = new javax.swing.JLabel();
        potato = new javax.swing.JLabel();
        tomato = new javax.swing.JLabel();
        sink = new javax.swing.JLabel();
        dryRack = new javax.swing.JLabel();
        onion = new javax.swing.JLabel();
        pot1 = new javax.swing.JLabel();
        pot2 = new javax.swing.JLabel();
        table = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("mainFrame"); // NOI18N
        setSize(new java.awt.Dimension(1080, 720));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        user.setText("User");

        wallLabel.setText("wall1");

        wallLabel1.setText("wall2");

        pot.setText("Pot1");

        potato.setText("Potato");

        tomato.setText("Tomato");

        sink.setText("Sink");

        dryRack.setText("DishRack");

        onion.setText("onion");

        pot1.setText("Pot2");

        pot2.setText("Pot3");

        table.setText("table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(wallLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wallLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(potato, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(tomato, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(onion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sink, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dryRack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(pot, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pot1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pot2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(wallLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pot, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pot1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pot2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(potato, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tomato, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dryRack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(onion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sink, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)))
                .addComponent(wallLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        wallLabel.getAccessibleContext().setAccessibleName("wallLabel");
        wallLabel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //check if a collision between images is occurring
    private boolean checkCollision(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

//check if temporary rectangle intersect with wallLabel        
       // if (rect.intersects(wallLabel.getBounds())) {
      //      return true;
      //  } else {
      //      return false;
      //  }
        
        if (rect.intersects(wallLabel1.getBounds())) {
            return true;
        } else {
            return false;
        }
    }

    //checks which key is pressed and moves image if no collision is detected
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //prints KeyCode for the key pressed
        // System.out.println(evt.getKeyCode());

        //up key pressed
        if (evt.getKeyCode() == 38) {
            if (!checkCollision(user, 0, -10)) {
                user.setLocation(user.getLocation().x, user.getLocation().y - 20);
            }
        }
        //down key pressed
        if (evt.getKeyCode() == 40) {
            if (!checkCollision(user, 0, 10)) {
                user.setLocation(user.getLocation().x, user.getLocation().y + 20);
            }
        }
        //left key pressed
        if (evt.getKeyCode() == 37) {
            if (!checkCollision(user, -10, 0)) {
                user.setLocation(user.getLocation().x - 20, user.getLocation().y);
            }
        }
        //right key pressed
        if (evt.getKeyCode() == 39) {
            if (!checkCollision(user, 10, 0)) {
                user.setLocation(user.getLocation().x + 20, user.getLocation().y);
            }
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * Creates new form NewJFrame
     */
    public Brayden() {
        initComponents();
        //Initialize the label with the scaled image icon
        myInitComponents(user);
    }

    //Initializes the labels with their images
    public void myInitComponents(javax.swing.JLabel jLabel1) {
        //Initialize a Buffered Image
        BufferedImage img = null;
        //set the Buffered Image to the picture file
        try {
            img = ImageIO.read(new File("braydenNude.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Create a temporary Image and scale it to the size of the label 
        Image tempImg = img.getScaledInstance(jLabel1.getWidth(), user.getHeight(),
                Image.SCALE_SMOOTH);
        //Create and Image Icon from the new scaled image
        ImageIcon imageIcon = new ImageIcon(tempImg);
        //Set the label's icon property to the new icon
        user.setIcon(imageIcon);

        
        //same as above, but in a condensed version
        try {
            wallLabel.setIcon(new ImageIcon((ImageIO.read(new File("red.jpg"))).getScaledInstance(wallLabel.getWidth(), wallLabel.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                //same as above, but in a condensed version
        try {
            wallLabel1.setIcon(new ImageIcon((ImageIO.read(new File("red.jpg"))).getScaledInstance(wallLabel1.getWidth(), wallLabel1.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                //same as above, but in a condensed version
        try {
            pot1.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot1.getWidth(), pot1.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        //same as above, but in a condensed version
        try {
            pot2.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot2.getWidth(), pot2.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        //same as above, but in a condensed version
        try {
            pot.setIcon(new ImageIcon((ImageIO.read(new File("pot.png"))).getScaledInstance(pot.getWidth(), pot.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(Brayden.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Brayden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Brayden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Brayden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Brayden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Brayden().setVisible(true);
            }
        });
    }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dryRack;
    private javax.swing.JLabel onion;
    private javax.swing.JLabel pot;
    private javax.swing.JLabel pot1;
    private javax.swing.JLabel pot2;
    private javax.swing.JLabel potato;
    private javax.swing.JLabel sink;
    private javax.swing.JLabel table;
    private javax.swing.JLabel tomato;
    private javax.swing.JLabel user;
    private javax.swing.JLabel wallLabel;
    private javax.swing.JLabel wallLabel1;
    // End of variables declaration//GEN-END:variables
}
