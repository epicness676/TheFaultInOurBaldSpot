package AlexPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import AlexPackage.EnemiesClass.*;
import AlexPackage.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Timer;
import java.util.TimerTask;
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
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.io.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author alexander.rejep819
 */
public class AlexForm extends javax.swing.JFrame  {

    //URL url = AlexForm.class.getResource("PewPew.wav");
    







//Sound clip = new Sound(url);
//AudioClip clip = Applet.newAudioClip(url);
    public int health = 4;
    public int counter = 120;
    Timer gameTimer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            counter--;
            timerLabel.setText(String.valueOf(counter));
            // System.out.println("Seconds Passed: " + counter);
            if (counter == 115) {
                gameTimer.scheduleAtFixedRate(EnemyAnimation, 400, 400);
            }
            if (counter == 0) {
                //closeForm();
            }
        }
    };

    TimerTask Animate = new TimerTask() {
        public void run() {
            //System.out.println("MOVE");

            try {
                for (JLabel item : bullets) {
                    sound();
                    item.setLocation(item.getLocation().x, item.getLocation().y - 5);
                    if (checkBulletCollisionEnemies(item, 0, -5) == true) {
                        remove(item);
                        bullets.remove(item);
                    }
                }

                for (JLabel item : impBullets) {
                    if (checkBulletCollisionPlane(item, 0, 4, 1) == true) {
                        remove(item);
                        impBullets.remove(item);
                    } else {
                        item.setLocation(item.getLocation().x, item.getLocation().y + 4);
                    }
                }

                for (JLabel item : beholderBullets) {
                    if (checkBulletCollisionPlane(item, 0, 3, 2) == true) {
                        remove(item);
                        beholderBullets.remove(item);
                    } else {
                        item.setLocation(item.getLocation().x, item.getLocation().y + 3);
                    }
                }
                for (JLabel item : demonBulletsRight) {
                    if (checkBulletCollisionPlane(item, 1, 5, 1) == true) {
                        remove(item);
                        demonBulletsRight.remove(item);
                    } else {
                        item.setLocation(item.getLocation().x + 2, item.getLocation().y + 5);
                    }
                }
                for (JLabel item : demonBulletsMid) {
                    if (checkBulletCollisionPlane(item, 0, 5, 1) == true) {
                        remove(item);
                        demonBulletsMid.remove(item);
                    } else {
                        item.setLocation(item.getLocation().x, item.getLocation().y + 5);
                    }
                }
                for (JLabel item : demonBulletsLeft) {
                    if (checkBulletCollisionPlane(item, -1, 5, 1) == true) {
                        remove(item);
                        demonBulletsLeft.remove(item);
                    } else {
                        item.setLocation(item.getLocation().x - 2, item.getLocation().y + 5);
                    }
                }

                for (JLabel item : bullets) {
                    if (item.getLocation().y < -50) {
                        bullets.remove(item);
                    }
                }

                for (JLabel item : impBullets) {
                    if (item.getLocation().y > 980) {
                        impBullets.remove(item);
                    }
                }
                for (int i = 0; i < enemyStats1.length; i++) {
                    if (i == 0) {
                        for (EnemiesClass item : impStats) {
                            int fireBullet = (int) (Math.random() * 400 + 1);
                            if (fireBullet == 5) {
                                JLabel impBullet = new JLabel();
                                getContentPane().add(impBullet);
                                impBullet.setBounds(item.getLabel().getLocation().x + item.getLabel().getWidth() / 2, item.getLabel().getLocation().y + 40, 14, 20);
                                try {
                                    impBullet.setIcon(new ImageIcon((ImageIO.read(new File("impBullet.png"))).getScaledInstance(impBullet.getWidth(), impBullet.getHeight(), Image.SCALE_SMOOTH)));
                                } catch (IOException ex) {
                                    Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                impBullets.add(impBullet);
                            }
                            if (checkBulletCollisionPhysical(item.getLabel(), 0, 10) == true) {
                                getContentPane().remove(item.getLabel());
                                impStats.remove(item);
                            }
                            if (item.getLabel().getLocation().x >= 100 && item.getLabel().getLocation().y == 200) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x + 2, item.getLabel().getLocation().y);
                            }
                            if (item.getLabel().getLocation().x == 700 && item.getLabel().getLocation().y >= 200) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x, item.getLabel().getLocation().y + 2);
                            }
                            if (item.getLabel().getLocation().x <= 700 && item.getLabel().getLocation().y == 400) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x - 2, item.getLabel().getLocation().y);
                            }
                            if (item.getLabel().getLocation().x == 100 && item.getLabel().getLocation().y <= 400) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x, item.getLabel().getLocation().y - 2);
                            }
                        }

                    }
                    if (i == 1) {
                        for (EnemiesClass item : demonStats) {
                            if (checkBulletCollisionPhysical(item.getLabel(), 0, 10) == true) {
                                getContentPane().remove(item.getLabel());
                                demonStats.remove(item);
                            }
                            int demonBall = (int) (Math.random() * 150 + 1);
                            if (demonBall == 5) {
                                JLabel demonBulletRight = new JLabel();
                                JLabel demonBulletMid = new JLabel();
                                JLabel demonBulletLeft = new JLabel();
                                getContentPane().add(demonBulletRight);
                                getContentPane().add(demonBulletMid);
                                getContentPane().add(demonBulletLeft);

                                demonBulletRight.setBounds(item.getLabel().getLocation().x + item.getLabel().getWidth(), item.getLabel().getLocation().y + 80, 40, 40);
                                demonBulletMid.setBounds(item.getLabel().getLocation().x + item.getLabel().getWidth() / 2, item.getLabel().getLocation().y + 80, 30, 40);
                                demonBulletLeft.setBounds(item.getLabel().getLocation().x, item.getLabel().getLocation().y + 80, 40, 40);
                                try {
                                    demonBulletRight.setIcon(new ImageIcon((ImageIO.read(new File("dmonBullRight.png"))).getScaledInstance(demonBulletRight.getWidth(), demonBulletRight.getHeight(), Image.SCALE_SMOOTH)));
                                    demonBulletMid.setIcon(new ImageIcon((ImageIO.read(new File("beholderBall.png"))).getScaledInstance(demonBulletMid.getWidth(), demonBulletMid.getHeight(), Image.SCALE_SMOOTH)));
                                    demonBulletLeft.setIcon(new ImageIcon((ImageIO.read(new File("dmonBullLeft.png"))).getScaledInstance(demonBulletLeft.getWidth(), demonBulletLeft.getHeight(), Image.SCALE_SMOOTH)));
                                } catch (IOException ex) {
                                    Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                demonBulletsRight.add(demonBulletRight);
                                demonBulletsMid.add(demonBulletMid);
                                demonBulletsLeft.add(demonBulletLeft);
                            }
                            if (item.getLabel().getLocation().y >= 200) {
                            } else {
                                item.getLabel().setLocation(item.getLabel().getLocation().x, item.getLabel().getLocation().y + 2);
                            }
                        }

                    }
                    if (i == 2) {
                        for (EnemiesClass item : beholderStats) {
                            int fireBall = (int) (Math.random() * 200 + 1);
                            //
                            if (fireBall == 5) {
                                JLabel beholderBullet = new JLabel();
                                getContentPane().add(beholderBullet);
                                beholderBullet.setBounds(item.getLabel().getLocation().x + item.getLabel().getWidth() / 2, item.getLabel().getLocation().y + 40, 30, 40);
                                try {
                                    beholderBullet.setIcon(new ImageIcon((ImageIO.read(new File("beholderBall.png"))).getScaledInstance(beholderBullet.getWidth(), beholderBullet.getHeight(), Image.SCALE_SMOOTH)));
                                } catch (IOException ex) {
                                    Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                beholderBullets.add(beholderBullet);
                            }
                            //
                            if (checkBulletCollisionPhysical(item.getLabel(), 0, 10) == true) {
                                getContentPane().remove(item.getLabel());
                                beholderStats.remove(item);
                            }
                            if (item.getLabel().getLocation().x <= 80) {
                                item.setDirection(true);
                            }
                            if (item.getLabel().getLocation().x >= 720) {
                                item.setDirection(false);
                            }
                            if (item.getDirection() == true) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x + 2, item.getLabel().getLocation().y);
                            }
                            if (item.getDirection() == false) {
                                item.getLabel().setLocation(item.getLabel().getLocation().x - 2, item.getLabel().getLocation().y);
                            }
                        }
                    }
                    if (i == 3) {
                        for (EnemiesClass item : deathWishStats) {
                            item.getLabel().setLocation(item.getLabel().getLocation().x, item.getLabel().getLocation().y + 10);
                            if (checkBulletCollisionPhysical(item.getLabel(), 0, 10) == true) {
                                getContentPane().remove(item.getLabel());
                                deathWishStats.remove(item);
                            }
                            if (item.getLabel().getLocation().y >= 1000) {
                                getContentPane().remove(item.getLabel());
                                deathWishStats.remove(item);
                            }
                        }
                    }
                }

            } catch (Exception e) {
            }
            // bullets.forEach((bullet) ->System.out.println("BULLET") );//bullet.setLocation(bullet.getLocation().x, bullet.getLocation().y -10));
            repaint();
        }
    };

    TimerTask EnemyAnimation = new TimerTask() {
        public void run() {
            //System.out.println("MOVE");
            int createEnemy = (int) (Math.random() * 3 + 1);
            if (createEnemy == 3) {
                System.out.println("Enemy Spawning");
                enemySpawning();
            }
        }
    };

    static ArrayList<EnemiesClass> impStats = new ArrayList<EnemiesClass>(0);
    static ArrayList<EnemiesClass> beholderStats = new ArrayList<EnemiesClass>(0);
    static ArrayList<EnemiesClass> demonStats = new ArrayList<EnemiesClass>(0);
    static ArrayList<EnemiesClass> deathWishStats = new ArrayList<EnemiesClass>(0);
    //static ArrayList<EnemiesClass> enemyStats = new ArrayList<EnemiesClass>(0);
    static ArrayList[] enemyStats1 = new ArrayList[4];

    ArrayList<JLabel> bullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> impBullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> beholderBullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> demonBulletsRight = new ArrayList<JLabel>(0);
    ArrayList<JLabel> demonBulletsMid = new ArrayList<JLabel>(0);
    ArrayList<JLabel> demonBulletsLeft = new ArrayList<JLabel>(0);

    private boolean checkCollision(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//check if temporary rectangle intersect with wallLabel        
        if (rect.intersects(rightSideWall.getBounds()) || rect.intersects(leftSideWall.getBounds()) || rect.intersects(hellWallBottom.getBounds()) || rect.intersects(hellWallTop.getBounds())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkBulletCollisionEnemies(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//check if temporary rectangle intersect with wallLabel  
        try {
            for (int i = 0; i < enemyStats1.length; i++) {
                if (i == 0) {
                    for (EnemiesClass item : impStats) {
                        if (rect.intersects(item.getLabel().getBounds())) {
                            item.setHealth(item.getHealth() - 1);
                            if (item.getHealth() == 0) {
                                impStats.remove(item);
                                getContentPane().remove(item.getLabel());
                            }
                            return true;
                        }
                    }
                }
                if (i == 1) {
                    for (EnemiesClass item : demonStats) {
                        if (rect.intersects(item.getLabel().getBounds())) {
                            item.setHealth(item.getHealth() - 1);
                            if (item.getHealth() == 0) {
                                demonStats.remove(item);
                                getContentPane().remove(item.getLabel());
                            }
                            return true;
                        }
                    }
                }
                if (i == 2) {
                    for (EnemiesClass item : beholderStats) {
                        if (rect.intersects(item.getLabel().getBounds())) {
                            item.setHealth(item.getHealth() - 1);
                            if (item.getHealth() == 0) {
                                beholderStats.remove(item);
                                getContentPane().remove(item.getLabel());
                            }
                            return true;
                        }
                    }
                }
                if (i == 3) {
                    for (EnemiesClass item : deathWishStats) {
                        if (rect.intersects(item.getLabel().getBounds())) {
                            item.setHealth(item.getHealth() - 1);
                            if (item.getHealth() == 0) {
                                deathWishStats.remove(item);
                                getContentPane().remove(item.getLabel());
                            }
                            return true;
                        }
                    }
                }
            }

        } catch (Exception e) {
        }
        return false;
    }

    private boolean checkBulletCollisionPlane(javax.swing.JLabel _lbl, int _x, int _y, int damage) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//check if temporary rectangle intersect with wallLabel    

        if (rect.intersects(tataPlane.getBounds())) {
            health -= damage;
            healthLabel.setText(String.valueOf(health));
            if (health == 3) {
                try {
                    tataPlane.setIcon(new ImageIcon((ImageIO.read(new File("tataPlaneShieldMed.png"))).getScaledInstance(tataPlane.getWidth(), tataPlane.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(AlexForm.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (health == 2) {
                try {
                    tataPlane.setIcon(new ImageIcon((ImageIO.read(new File("tataPlaneShieldLow.png"))).getScaledInstance(tataPlane.getWidth(), tataPlane.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(AlexForm.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (health == 1) {
                try {
                    tataPlane.setIcon(new ImageIcon((ImageIO.read(new File("tataPlane2.png"))).getScaledInstance(tataPlane.getWidth(), tataPlane.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(AlexForm.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (health <= 0) {
                Losser gameOver = new Losser();

                gameOver.setVisible(true);
                this.setVisible(false);
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean checkBulletCollisionPhysical(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());
//check if temporary rectangle intersect with wallLabel    

        if (rect.intersects(tataPlane.getBounds())) {
            health -= 3;
            if (health == 3) {
                try {
                    tataPlane.setIcon(new ImageIcon((ImageIO.read(new File("tataPlaneShieldMed.png"))).getScaledInstance(tataPlane.getWidth(), tataPlane.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(AlexForm.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (health == 2) {
                try {
                    tataPlane.setIcon(new ImageIcon((ImageIO.read(new File("tataPlaneShieldLow.png"))).getScaledInstance(tataPlane.getWidth(), tataPlane.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(AlexForm.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (health == 1) {
                try {
                    tataPlane.setIcon(new ImageIcon((ImageIO.read(new File("tataPlane2.png"))).getScaledInstance(tataPlane.getWidth(), tataPlane.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    Logger.getLogger(AlexForm.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (health <= 0) {
                Losser gameOver = new Losser();
                gameOver.setVisible(true);
                this.setVisible(false);
            }
            healthLabel.setText(String.valueOf(health));
            return true;
        } else {
            return false;
        }
    }

    public AlexForm() {
        initComponents();
        myInitComponents();
    }

    public void myInitComponents() {
        BufferedImage img = null;
        //same as above, but in a condensed version
        gameTimer.scheduleAtFixedRate(task, 1000, 1000);
        try {
            // backGround.setIcon(new ImageIcon((ImageIO.read(new File("hellBackground5.png"))).getScaledInstance(backGround.getWidth(), backGround.getHeight(), Image.SCALE_SMOOTH)));
            tataPlane.setIcon(new ImageIcon((ImageIO.read(new File("tataPlaneShieldHigh.png"))).getScaledInstance(tataPlane.getWidth(), tataPlane.getHeight(), Image.SCALE_SMOOTH)));
            leftSideWall.setIcon(new ImageIcon((ImageIO.read(new File("hellWallLeft.png"))).getScaledInstance(leftSideWall.getWidth(), leftSideWall.getHeight(), Image.SCALE_SMOOTH)));
            rightSideWall.setIcon(new ImageIcon((ImageIO.read(new File("hellWallRight.png"))).getScaledInstance(rightSideWall.getWidth(), rightSideWall.getHeight(), Image.SCALE_SMOOTH)));
            hellWallBottom.setIcon(new ImageIcon((ImageIO.read(new File("hellWallBottom.png"))).getScaledInstance(hellWallBottom.getWidth(), hellWallBottom.getHeight(), Image.SCALE_SMOOTH)));
            // hellWallTop.setIcon(new ImageIcon((ImageIO.read(new File("hellWallTop.png"))).getScaledInstance(hellWallTop.getWidth(), hellWallTop.getHeight(), Image.SCALE_SMOOTH)));

        } catch (IOException ex) {
            Logger.getLogger(AlexForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        enemyStats1[0] = impStats;
        enemyStats1[1] = demonStats;
        enemyStats1[2] = beholderStats;
        enemyStats1[3] = deathWishStats;

        gameTimer.scheduleAtFixedRate(Animate, 100, 10);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hellWallTop1 = new javax.swing.JLabel();
        tataPlane = new javax.swing.JLabel();
        healthLabel = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        rightSideWall = new javax.swing.JLabel();
        leftSideWall = new javax.swing.JLabel();
        hellWallTop = new javax.swing.JLabel();
        hellWallBottom = new javax.swing.JLabel();
        backGround = new javax.swing.JLabel();

        hellWallTop1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(AlexForm.class);
        hellWallTop1.setText(resourceMap.getString("hellWallTop1.text")); // NOI18N
        hellWallTop1.setToolTipText(resourceMap.getString("hellWallTop1.toolTipText")); // NOI18N
        hellWallTop1.setName("hellWallTop1"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 1000));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 1000));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        tataPlane.setText(resourceMap.getString("tataPlane.text")); // NOI18N
        tataPlane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tataPlane.setName("tataPlane"); // NOI18N
        getContentPane().add(tataPlane);
        tataPlane.setBounds(410, 640, 60, 60);

        healthLabel.setFont(resourceMap.getFont("healthLabel.font")); // NOI18N
        healthLabel.setForeground(resourceMap.getColor("healthLabel.foreground")); // NOI18N
        healthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        healthLabel.setText(resourceMap.getString("healthLabel.text")); // NOI18N
        healthLabel.setToolTipText(resourceMap.getString("healthLabel.toolTipText")); // NOI18N
        healthLabel.setName("healthLabel"); // NOI18N
        getContentPane().add(healthLabel);
        healthLabel.setBounds(0, 0, 60, 60);

        timerLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        timerLabel.setForeground(resourceMap.getColor("timerLabel.foreground")); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText(resourceMap.getString("timerLabel.text")); // NOI18N
        timerLabel.setName("timerLabel"); // NOI18N
        getContentPane().add(timerLabel);
        timerLabel.setBounds(820, 0, 80, 50);

        rightSideWall.setIcon(resourceMap.getIcon("rightSideWall.icon")); // NOI18N
        rightSideWall.setText(resourceMap.getString("rightSideWall.text")); // NOI18N
        rightSideWall.setName("rightSideWall"); // NOI18N
        getContentPane().add(rightSideWall);
        rightSideWall.setBounds(820, 0, 80, 1000);

        leftSideWall.setText(resourceMap.getString("leftSideWall.text")); // NOI18N
        leftSideWall.setName("leftSideWall"); // NOI18N
        getContentPane().add(leftSideWall);
        leftSideWall.setBounds(0, 0, 80, 1000);

        hellWallTop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hellWallTop.setText(resourceMap.getString("hellWallTop.text")); // NOI18N
        hellWallTop.setName("hellWallTop"); // NOI18N
        getContentPane().add(hellWallTop);
        hellWallTop.setBounds(0, 0, 900, 60);
        hellWallTop.getAccessibleContext().setAccessibleName(resourceMap.getString("hellWallTop.AccessibleContext.accessibleName")); // NOI18N

        hellWallBottom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hellWallBottom.setText(resourceMap.getString("hellWallBottom.text")); // NOI18N
        hellWallBottom.setName("hellWallBottom"); // NOI18N
        getContentPane().add(hellWallBottom);
        hellWallBottom.setBounds(0, 920, 900, 80);

        backGround.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backGround.setText(resourceMap.getString("Background.text")); // NOI18N
        backGround.setName("Background"); // NOI18N
        getContentPane().add(backGround);
        backGround.setBounds(0, 0, 900, 1000);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        //up key pressed
//this.repaint();

        //Try layeredPane layout instead of Null layout
        //https://docs.oracle.com/javase/tutorial/uiswing/components/layeredpane.html#depth
        if (evt.getKeyCode() == 38) {
            if (!checkCollision(tataPlane, 0, -15)) {
                tataPlane.setLocation(tataPlane.getLocation().x, tataPlane.getLocation().y - 15);
            }
        }
        //down key pressed
        if (evt.getKeyCode() == 40) {
            if (!checkCollision(tataPlane, 0, 15)) {
                tataPlane.setLocation(tataPlane.getLocation().x, tataPlane.getLocation().y + 15);
            }
        }
        //left key pressed
        if (evt.getKeyCode() == 37) {
            if (!checkCollision(tataPlane, -25, 0)) {
                tataPlane.setLocation(tataPlane.getLocation().x - 25, tataPlane.getLocation().y);
            }
        }
        //right key pressed
        if (evt.getKeyCode() == 39) {
            if (!checkCollision(tataPlane, 25, 0)) {
                tataPlane.setLocation(tataPlane.getLocation().x + 25, tataPlane.getLocation().y);
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == 88) {
//            JLabel bullet = new JLabel();
//
//            System.out.println("Label Created");
//            getContentPane().add(bullet);
//            bullet.setBounds(tataPlane.getX() + tataPlane.getWidth() / 2, tataPlane.getY() - 10, 5, 10);
//
//            System.out.println("Bounds Set");
//            try {
//                bullet.setIcon(new ImageIcon((ImageIO.read(new File("bullet.png"))).getScaledInstance(bullet.getWidth(), bullet.getHeight(), Image.SCALE_SMOOTH)));
//            } catch (IOException ex) {
//                System.out.println("NO IMAGE");
//                Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            setComponentZOrder(bullet, 0);
//            System.out.println("Try performed");

            bullet();
            ///////////////////////////////////
            try {
         // Open an audio input stream.
        // URL url = this.getClass().getClassLoader().getResource("PewPew.wav");
         
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("PewPew.wav"));
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }catch (LineUnavailableException e) {
         e.printStackTrace();
      }
            catch(Exception e){
                System.out.println(e);
            }
          

            
            
         ////////////////////////////////   
            
            
        }
    }//GEN-LAST:event_formKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        int strength, speed, health;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlexForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlexForm().setVisible(true);
            }
        });

    }

//    public void int impMovement(int x, int y) {
//        
//        
//        return y;
//    }
    public void enemySpawning() {
        int spawn = (int) (Math.random() * 100 + 1);
        if (spawn <= 40) {
            impSpawn();
        }
        if (spawn > 40 && spawn <= 50) {
            demonSpawn();
        }
        if (spawn > 50 && spawn <= 70) {
            beholderSpawn();
        }
        if (spawn > 70 && spawn <= 100) {
            deathWishSpawn();
        }
    }

    public void impSpawn() {
        System.out.println("IMP Coming");

        if (impStats.size() < 10) {
            Imp imp = new Imp();
            impStats.add(imp);

            JLabel label = new JLabel();
            imp.setLabel(label);
            getContentPane().add(imp.getLabel());
            imp.getLabel().setBounds(100, imp.getHeight() * 50, 40, 40);
            try {
                imp.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("Impling.png"))).getScaledInstance(imp.getLabel().getWidth(), imp.getLabel().getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println("NO IMAGE");
                Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }

    }

    public void demonSpawn() {
        System.out.println("Demon Coming");
        if (demonStats.size() < 1) {
            Demon demon = new Demon();
            demonStats.add(demon);
            JLabel label = new JLabel();
            demon.setLabel(label);
            getContentPane().add(demon.getLabel());
            demon.getLabel().setBounds(390, -100, 120, 80);
            try {
                demon.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("Dmon.png"))).getScaledInstance(demon.getLabel().getWidth(), demon.getLabel().getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println("NO IMAGE");
                Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
    }

    public void beholderSpawn() {
        System.out.println("Beholder Coming");
        if (beholderStats.size() < 3) {
            Beholder beholder = new Beholder();
            beholderStats.add(beholder);
            JLabel label = new JLabel();
            beholder.setLabel(label);
            getContentPane().add(beholder.getLabel());
            beholder.getLabel().setBounds(80, beholder.getHeight() * 50, 80, 80);
            try {
                beholder.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("Beholder.png"))).getScaledInstance(beholder.getLabel().getWidth(), beholder.getLabel().getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println("NO IMAGE");
                Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }
    }

    public void deathWishSpawn() {
        System.out.println("deathWish Coming");
        DeathWish suicide = new DeathWish();
        deathWishStats.add(suicide);
        JLabel label = new JLabel();
        suicide.setLabel(label);
        getContentPane().add(suicide.getLabel());
        suicide.getLabel().setBounds(60 * suicide.getHeight(), -55, 50, 50);
        try {
            suicide.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("uicide.png"))).getScaledInstance(suicide.getLabel().getWidth(), suicide.getLabel().getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println("NO IMAGE");
            Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bullet() {
        JLabel bullet = new JLabel();
        if (bullets.size() < 3) {
            getContentPane().add(bullet);
            bullet.setBounds(tataPlane.getX() + tataPlane.getWidth() / 2 - 2, tataPlane.getY() - 10, 8, 12);
            try {
                bullet.setIcon(new ImageIcon((ImageIO.read(new File("bullet.png"))).getScaledInstance(bullet.getWidth(), bullet.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println("NO IMAGE");
                Logger.getLogger(AlexForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            //setComponentZOrder(bullet, 0);
            // getContentPane().repaint();
            bullets.add(bullet);
        }
    }

    public void closeForm(JFrame AlexForm) {
        Victory winner = new Victory();

        setVisible(false);

        winner.setVisible(true);

dispatchEvent(new WindowEvent(AlexForm, WindowEvent.WINDOW_CLOSING));
    }
    
    public void sound (){
             
//File fileIn = new File( "PewPew.wav");
//  try{
//        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fileIn);
//        audioInputStream.
//}catch(Exception e){}
//  URL file = AlexForm.class.getResource("PewPewPew.mp3");
//    final Media media = new Media(file.toString());
//    final MediaPlayer mediaPlayer = new MediaPlayer(media);
//    mediaPlayer.play();

//try {
//        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("PewPew.wav"));
//        Clip clip = AudioSystem.getClip();
//        clip.open(audioInputStream);
//        clip.start();
//    } catch(Exception ex) {
//    }

//String bip = "PewPewPew.mp3";
//Media hit = new Media(new File(bip).toURI().toString());
//MediaPlayer mediaPlayer = new MediaPlayer(hit);
//mediaPlayer.play();


    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backGround;
    private javax.swing.JLabel healthLabel;
    private javax.swing.JLabel hellWallBottom;
    private javax.swing.JLabel hellWallTop;
    private javax.swing.JLabel hellWallTop1;
    private javax.swing.JLabel leftSideWall;
    private javax.swing.JLabel rightSideWall;
    private javax.swing.JLabel tataPlane;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
