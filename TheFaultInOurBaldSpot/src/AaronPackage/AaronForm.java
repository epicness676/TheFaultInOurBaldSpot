package AaronPackage;

//Imported all the features I need for my program
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Main class of the form
public class AaronForm extends javax.swing.JFrame {
//Declaring all the different variables 

    int movementSpeed = 1;
    boolean jumping = false;
    boolean movingRight = false;
    boolean movingLeft = false;
    boolean officeWorkerMove = false;
    int jumpTimer = 0;
    int numberOfObjects = 0;
    //Declaring the player object
    MegaAaron playerCharacter;
    //Declaring all the different array lists for the objects
    ArrayList<JLabel> staplebullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> guardbullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> fatbullets = new ArrayList<JLabel>(0);
    ArrayList<JLabel> spikelist = new ArrayList<JLabel>(0);
    ArrayList<JLabel> floorlist = new ArrayList<JLabel>(0);
    ArrayList<String> blockType = new ArrayList<String>(0);
    ArrayList<String> blockX = new ArrayList<String>(0);
    ArrayList<String> blockY = new ArrayList<String>(0);
    ArrayList<JLabel> activeFloor = new ArrayList<JLabel>(0);
    ArrayList<JLabel> activeSpike = new ArrayList<JLabel>(0);
    ArrayList<JLabel> activeDoor = new ArrayList<JLabel>(0);
    //Declares the arraylists for all of the enemies
    static ArrayList<EnemyClass> securityGuardStats = new ArrayList<EnemyClass>(0);
    static ArrayList<EnemyClass> officeWorkerStats = new ArrayList<EnemyClass>(0);
    static ArrayList<EnemyClass> fatOfficeWorkerStats = new ArrayList<EnemyClass>(0);
    //Declares the 2d array that holds all of the objects and enemies
    String[][] objectsArray = new String[3][99];

//Declared the two timers that I use for the timer tasks
    Timer aaronGameTimer = new Timer();
    Timer aaronJumpTimer = new Timer();
//Moves all objects except the player to the character right
    TimerTask moveRight = new TimerTask() {
        public void run() {
            //Checks to see if moving right is true
            if (movingRight) {
                //Checks to see if there is any object in the way of the player
                if (!checkCollision(player, -movementSpeed, 0)) {
//Finds the location for every single object and enemy JLabel and moves it to the left by 1 x value.
                    for (JLabel item : activeFloor) {
                        item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

                    }
                    for (JLabel item : activeSpike) {
                        item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

                    }

                    for (JLabel item : activeDoor) {
                        item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

                    }
                    for (JLabel item : guardbullets) {
                        item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

                    }
                    for (JLabel item : fatbullets) {
                        item.setLocation(item.getLocation().x - movementSpeed, item.getLocation().y);

                    }

                    for (EnemyClass item : fatOfficeWorkerStats) {
                        item.getLabel().setLocation(item.getLabel().getLocation().x - movementSpeed, item.getLabel().getLocation().y);

                    }
                    for (EnemyClass item : officeWorkerStats) {
                        item.getLabel().setLocation(item.getLabel().getLocation().x - movementSpeed, item.getLabel().getLocation().y);

                    }
                    for (EnemyClass item : securityGuardStats) {
                        item.getLabel().setLocation(item.getLabel().getLocation().x - movementSpeed, item.getLabel().getLocation().y);

                    }
                }
            }
        }
    };
//Timer task responsible for moving every block and enemy left when the user wants to move right
    TimerTask moveLeft = new TimerTask() {
        public void run() {
            //Checks to see if moving left is true
            if (movingLeft) {
                if (!checkCollision(player, +movementSpeed, 0)) {
  //Finds the location for every single object and enemy JLabel and moves it to the right by 1 x value.
                    for (JLabel item : activeFloor) {
                        item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

                    }
                    for (JLabel item : activeSpike) {
                        item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

                    }
                    for (JLabel item : activeDoor) {
                        item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

                    }
                    for (JLabel item : guardbullets) {
                        item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

                    }
                    for (JLabel item : fatbullets) {
                        item.setLocation(item.getLocation().x + movementSpeed, item.getLocation().y);

                    }
                    for (EnemyClass item : fatOfficeWorkerStats) {
                        item.getLabel().setLocation(item.getLabel().getLocation().x + movementSpeed, item.getLabel().getLocation().y);

                    }
                    for (EnemyClass item : officeWorkerStats) {
                        item.getLabel().setLocation(item.getLabel().getLocation().x + movementSpeed, item.getLabel().getLocation().y);

                    }
                    for (EnemyClass item : securityGuardStats) {
                        item.getLabel().setLocation(item.getLabel().getLocation().x + movementSpeed, item.getLabel().getLocation().y);
                    }
                }
            }
        }
    };
//Timer task that is responsible for moving the player down when they aren't on solid ground or jumping
     TimerTask gravity = new TimerTask() {
        public void run() {
//Checks to see if there is no block 10 spaces below the player and that the player isn't jumping
            if ((!checkCollision(player, 0, +10) && (jumping == false))) {
//Takes the current player y location and sets it down blocks lower
                player.setLocation(player.getLocation().x, player.getLocation().y + 10);

            }

        }
    };
//Timer task that is responsible for moving the player up smoothly when the user jumps
    TimerTask jumpGravity = new TimerTask() {
        public void run() {
            System.out.println("Running jumpy " + jumping);
            //Checks to see if jumping is true
            if (jumping) {
                //Increases the jump timer by 1 every time it runs
                jumpTimer++;
                //Checks to see if the jump timer is greater less than 22
                if (jumpTimer <= 22) {
                    //Sets the players location to be ten y values up from its previous location
                    player.setLocation(player.getLocation().x, player.getLocation().y - 10);
                    //Checks to see if jump timer is above 22
                } else if (jumpTimer > 22) {
//Resets Jump Timer
                    jumpTimer = 0;
                    //Sets jumping to false which tells the computer when to stop jumping
                    jumping = false;
                    System.out.println("Stop Running jumpy");

                }
            }
        }
    };
    //TimerTask checks every object and enemy label and sees if its in the user's field of view then sets makes the labels visible if it's visible
  TimerTask checkVisible = new TimerTask() {
        public void run() {
//For loops check every single Object and enemy to see if its in the user's field of view
            for (JLabel item : activeFloor) {
                //Checks to see if the item is in the user's field of view
                if (item.getLocation().x > 0 && item.getLocation().x < 1080) {
                    //Makes the item visible to the user
                    getContentPane().add(item);
                }
            }
            for (JLabel item : activeSpike) {
                if (item.getLocation().x > 0 && item.getLocation().x < 1080) {
                    getContentPane().add(item);
                }

            }
            for (JLabel item : activeDoor) {
                if (item.getLocation().x > 0 && item.getLocation().x < 1080) {
                    getContentPane().add(item);
                }

            }
            for (JLabel item : guardbullets) {
                if (item.getLocation().x > 0 && item.getLocation().x < 1080) {
                    getContentPane().add(item);
                }

            }
            for (JLabel item : fatbullets) {

                if (item.getLocation().x > 0 && item.getLocation().x < 1080) {
                    getContentPane().add(item);
                }
            }
            for (EnemyClass item : fatOfficeWorkerStats) {
                if (item.getLabel().getBounds().getX() > 0 && item.getLabel().getBounds().getX() < 1080) {
                    getContentPane().add(item.getLabel());
                }

            }
            for (EnemyClass item : officeWorkerStats) {
                if (item.getLabel().getBounds().getX() > 0 && item.getLabel().getBounds().getX() < 1080) {
                    getContentPane().add(item.getLabel());
                    officeWorkerMove = true;
                }

            }
            for (EnemyClass item : securityGuardStats) {
                if (item.getLabel().getBounds().getX() > 0 && item.getLabel().getBounds().getX() < 1080) {
                    getContentPane().add(item.getLabel());
                }

            }
        }

    };
    
    //Timer tasks thats responsible for moving the player's bullets
    TimerTask bulletMovement = new TimerTask() {
        public void run() {
//Try catch catches any exceptions
            try {
//For statements ensures that the task checks every staplebullet
                for (JLabel item : staplebullets) {
                    //Sets the bullets location to 20 x values to the right from the previous location
                    item.setLocation(item.getLocation().x + 20, item.getLocation().y);
//Checks to see if the bullet label collides with an enemy label
                    if (bulletCollisionEnemies(item, +20, 0) == true) {
                        //Removes the staple bullet from the form if it hits an enemy
                        remove(item);
                        //Removes the stable bullet from the bullets array.
                        staplebullets.remove(item);
                    }
                    //Checks to see if the bullet is out of the player's view
                    if (item.getLocation().x > 1080) {
                        //Removes the bullet if the bullet is out of the player's view
                        remove(item);
                        staplebullets.remove(item);
                    }

                }
            } catch (Exception e) {
            }
        }
    };
    //TimerTask that creates the fat enemies bullets
TimerTask createFatBullets = new TimerTask() {
        public void run() {
//Finds each fatOfficeWorker object in the fatOfficeWorker array
            for (EnemyClass item : fatOfficeWorkerStats) {
//Creates a new JLabel for the fat bullet
            JLabel fatbullet = new JLabel();

            System.out.println("Label Created");
            //Makes the fatbullet visible to the user
            getContentPane().add(fatbullet);
            //Sets the location to be the same as the fat bullet enemy and the bullet size
            fatbullet.setBounds(item.getLabel().getLocation().x, item.getLabel().getLocation().y + 100, 50, 50);

            System.out.println("Bounds Set");
            //Try catch statement catches any IO exceptions
            try {
                //Sets the fatbullet icon to the hamburger png
                fatbullet.setIcon(new ImageIcon((ImageIO.read(new File("AaronHamburger.png"))).getScaledInstance(fatbullet.getWidth(), fatbullet.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println("NO IMAGE");
                Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            System.out.println("Try performed");
            //adds the fatbullets to the fatbullets array
            fatbullets.add(fatbullet);
        }

        }
    };

//Timertask creates the guards bullets
    TimerTask createGuardBullets = new TimerTask() {
        public void run() {
//Finds every security guard object in the enemyclass
              for (EnemyClass item : securityGuardStats) {
//Creates a new security guard JLabel
            JLabel guardbullet = new JLabel();

            System.out.println("Label Created");
            //Makes the label visible to the user
            getContentPane().add(guardbullet);
            //Sets the guardbullet location to be the same as the security guard
            guardbullet.setBounds(item.getLabel().getLocation().x, item.getLabel().getLocation().y + 100, 50, 50);

            System.out.println("Bounds Set");
         //Try catch statement catches any IO exceptions
            try {
                //Sets the guard bullet JLabel to the security guard bullet png
                guardbullet.setIcon(new ImageIcon((ImageIO.read(new File("SecurityGuardBullet.png"))).getScaledInstance(guardbullet.getWidth(), guardbullet.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                System.out.println("NO IMAGE");
                Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
            }
     
            System.out.println("Try performed");
            //Adds the guard bullet to the guard bullet array
            guardbullets.add(guardbullet);
        }

        }
    };
    //TimerTask moves the guard bullets
     TimerTask guardBulletMovement = new TimerTask() {
        public void run() {
            //Try catch statements catches any exceptions
            try {
                //For statement looks through every Jlabel in the guard bullets array and sets it to item
                for (JLabel item : guardbullets) {
                    //Sets the location of item 20 x values to the left of where it previously was
                    item.setLocation(item.getLocation().x - 20, item.getLocation().y);
                    //If statement checks if the bullet will hit the player or not
                    if (bulletCollisionPlayer(item, -20, 0) == true) {
                        //Runs the take damage function if the bullet collides with the player
                        takeDamage();
//Removes the guard bullet from the guardbullets array list
                        guardbullets.remove(item);
                        //Removes the guard bullet from the form
                        remove(item);

                    }
                    //Checks to see if the item is out of the bounds of the outside of a certain area around the player
                    if (item.getLocation().x > 1500 || (item.getLocation().x < 0)) {
                        //Removes the item if its outside of the certain area and removes it from the form and from the array.
                        remove(item);
                        guardbullets.remove(item);
                    }

                }
            } catch (Exception e) {
            }
        }
    };
     //TimerTask that moves the fat bullets
    TimerTask fatBulletMovement = new TimerTask() {
        public void run() {
            try {
                for (JLabel item : fatbullets) {

                    item.setLocation(item.getLocation().x - 15, item.getLocation().y);
                    if (bulletCollisionPlayer(item, -5, 0) == true) {
                        takeDamage();
                        fatbullets.remove(item);
                        remove(item);

                    }
                    if (item.getLocation().x > 1400 || (item.getLocation().x < 0)) {
                        remove(item);
                        fatbullets.remove(item);
                    }
                }

            } catch (Exception e) {

            }
        }
    };
    TimerTask officeWorkerMovement = new TimerTask() {
        public void run() {

            if (officeWorkerMove) {
                try {

                    for (EnemyClass item : officeWorkerStats) {

                        item.getLabel().setLocation(item.getLabel().getLocation().x - 15, (item.getLabel().getLocation().y));

                        if (bulletCollisionPlayer(item.getLabel(), -15, 0) == true) {
                            takeDamage();
                            remove(item.getLabel());
                            officeWorkerStats.remove(item);
                        }
                    }
                } catch (Exception e) {

                }
            }
        }
    };
 

    private boolean checkCollision(javax.swing.JLabel _lbl, int _x, int _y) {
//creating a temporary rectangle with (x, y) coordinates equal to where image is trying to move
//also same width and height as original
        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

//check if temporary rectangle intersect with wallLabel        
        if (rect.intersects(bottomFloor.getBounds())) {
            return true;
        } else {

            for (JLabel item : activeFloor) {

                if (rect.intersects(item.getBounds())) {
                    return true;
                }
            }
            for (JLabel item : activeSpike) {

                if (rect.intersects(item.getBounds())) {
                    takeDamage();
                    return true;
                }
            }
            for (JLabel item : activeDoor) {
                if (rect.intersects(item.getBounds())) {
                    AaronWinScreen winScreen = new AaronWinScreen();
                    winScreen.setVisible(true);
                    this.setVisible(false);
                    this.dispose();
                }
            }
            return false;
        }
    }

    public AaronForm() throws IOException {
        initComponents();

        myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bottomFloor = new javax.swing.JLabel();
        player = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1080, 617));
        setSize(new java.awt.Dimension(1080, 617));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(AaronForm.class);
        bottomFloor.setText(resourceMap.getString("bottomFloor.text")); // NOI18N
        bottomFloor.setName("bottomFloor"); // NOI18N
        getContentPane().add(bottomFloor);
        bottomFloor.setBounds(0, 542, 1420, 70);

        player.setText(resourceMap.getString("player.text")); // NOI18N
        player.setName("player"); // NOI18N
        getContentPane().add(player);
        player.setBounds(240, 340, 115, 198);

        jProgressBar1.setName("jProgressBar1"); // NOI18N
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(50, 40, 146, 7);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void myInitComponents() throws IOException {

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("AaronLevelMusic.wav"));
            // Get a sound clip resource.
            Clip clip1 = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip1.open(audio);
            clip1.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }

//Initialize a Buffered Image
        BufferedImage img = null;
        //set the Buffered Image to the picture file

//        same as above, but in a condensed version
        try {

            bottomFloor.setIcon(new ImageIcon((ImageIO.read(new File("AaronFloor.png"))).getScaledInstance(bottomFloor.getWidth(), bottomFloor.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            readLevelFile();
        } catch (IOException ex) {
            Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        playerSpawner();
        jProgressBar1.setMaximum(playerCharacter.getHealth());
        jProgressBar1.setValue(playerCharacter.getHealth());
        fillUpArray();
        spikeSpawner();
        floorSpawner();
        securityGuardSpawner();
        officeWorkerSpawner();
        fatAlbertSpawner();
        exitSpawner();

        aaronGameTimer.scheduleAtFixedRate(bulletMovement, 100, 10);
        aaronJumpTimer.scheduleAtFixedRate(jumpGravity, 20, 25);
        aaronGameTimer.scheduleAtFixedRate(gravity, 20, 25);
        aaronGameTimer.scheduleAtFixedRate(moveRight, 2, 2);
        aaronGameTimer.scheduleAtFixedRate(moveLeft, 2, 2);
        aaronGameTimer.scheduleAtFixedRate(createFatBullets, 10, 2000);
        aaronGameTimer.scheduleAtFixedRate(createGuardBullets, 10, 2000);
        aaronGameTimer.scheduleAtFixedRate(guardBulletMovement, 100, 100);
        aaronGameTimer.scheduleAtFixedRate(fatBulletMovement, 100, 100);
        aaronGameTimer.scheduleAtFixedRate(checkVisible, 10, 10);
        aaronGameTimer.scheduleAtFixedRate(officeWorkerMovement, 100, 10);
    }


    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode() == 90) {
            if (!checkCollision(player, 0, -100) && (checkCollision(player, 0, +10))) {
                jumping = true;
            }
        }
        //left key pressed
        if (evt.getKeyCode() == 37) {
//          
            movingLeft = true;
            System.out.println("moving Left" + movingLeft);
//            
        }
        //right key pressed
        if (evt.getKeyCode() == 39) {
            movingRight = true;
            System.out.println("moving Left" + movingRight);
  
        }


    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == 88) {
            if (staplebullets.size() < 1) {
                bullet();

                try {
                    // Open an audio input stream.
                    // URL url = this.getClass().getClassLoader().getResource("PewPew.wav");

                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("AaronShoot.wav"));
                    // Get a sound clip resource.
                    Clip clip = AudioSystem.getClip();
                    // Open audio clip and load samples from the audio input stream.
                    clip.open(audioIn);
                    clip.start();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
        if (evt.getKeyCode() == 37) {
            if (!checkCollision(player, 0, 0)) {
                movingLeft = false;
                System.out.println("stopped moving Left" + movingLeft);
            }
        }
        //right key pressed
        if (evt.getKeyCode() == 39) {
            if (!checkCollision(player, 0, 0)) {
                movingRight = false;
                System.out.println("stopped moving right" + movingRight);
            }
        }
    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new AaronForm().setVisible(true);
//    readLevelFile(block1);
                } catch (IOException ex) {
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

     public void readLevelFile() throws IOException {
        //Initilizises a string varibable that stores the line the program is currently reading
        String myLine = null;
        String blockAdd = myLine;

        BufferedReader readFile = new BufferedReader(new FileReader("AaronLevelFile.txt"));
        //Do statement ensures that the program only stops reading the file when it reaches a blank line
        do {
            //Stores the line that the program is currently looking at as the variable myLine
            myLine = readFile.readLine();
            if (myLine == null) {
                break;
            }

//If statement ensures that if the line the program is currently looking at is null then the program removes the null from the array list and breaks out of the loop
//TYPE 
            int index = myLine.indexOf(",");
            numberOfObjects++;
            blockAdd = myLine.substring(0, index);
            System.out.println("BLOCK" + blockAdd);
            blockType.add(blockAdd);

            myLine = myLine.substring(index + 1, myLine.length());
            System.out.println("NEW line " + myLine);

            //X- VALUE
            index = myLine.indexOf(",");
            blockAdd = myLine.substring(0, index);
            System.out.println(blockAdd);
            blockX.add(blockAdd);
            myLine = myLine.substring(index + 1, myLine.length());

            //Y=VALUE
            blockAdd = myLine;
            System.out.println(blockAdd);

            blockY.add(blockAdd);

        } while (true);
//Closez the file to ensure there is no complications
        readFile.close();

    }
  public void fillUpArray() {

        for (int i = 0; i < numberOfObjects; i++) {
            objectsArray[0][i] = blockType.get(i);
            System.out.println(objectsArray[0][i]);
            objectsArray[1][i] = blockX.get(i);
            System.out.println(objectsArray[1][i]);
            objectsArray[2][i] = blockY.get(i);
            System.out.println(objectsArray[2][i]);
        }

    }
    
  
    public void playerSpawner() throws IOException {
        playerCharacter = new MegaAaron();
        playerCharacter.setLabel(player);
        player.setIcon(new ImageIcon((ImageIO.read(new File("MegaAaron.png"))).getScaledInstance(player.getWidth(), player.getHeight(), Image.SCALE_SMOOTH)));
    }

    public void floorSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {

            if (objectsArray[0][i].equals("floor")) {

                JLabel floor1 = new JLabel();

                System.out.println("Label Created");

                floor1.setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 50, 50);

                System.out.println("Bounds Set");
                try {
                    floor1.setIcon(new ImageIcon((ImageIO.read(new File("AaronFloor.png"))).getScaledInstance(floor1.getWidth(), floor1.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("Try performed");
                activeFloor.add(floor1);
            }

        }

    }

    public void spikeSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {

            if (objectsArray[0][i].equals("spike")) {

                JLabel spike2 = new JLabel();

                System.out.println("Label Created");

                spike2.setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 50, 50);

                System.out.println("Bounds Set");
                try {
                    spike2.setIcon(new ImageIcon((ImageIO.read(new File("AaronSpikes.png"))).getScaledInstance(spike2.getWidth(), spike2.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("Try performed");
                activeSpike.add(spike2);
            }

        }
    }

    public void exitSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {

            if (objectsArray[0][i].equals("door")) {

                System.out.println("door Coming");
                JLabel door = new JLabel();

                door.setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 100, 250);

                System.out.println("Bounds Set");
                try {
                    door.setIcon(new ImageIcon((ImageIO.read(new File("Door.png"))).getScaledInstance(door.getWidth(), door.getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println("Try performed");
                activeDoor.add(door);

            }

        }
    }

    public void securityGuardSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {
            if (objectsArray[0][i].equals("guard")) {

                System.out.println("IMP Coming");
                SecurityGuard guard = new SecurityGuard();
                securityGuardStats.add(guard);
                JLabel label = new JLabel();
                guard.setLabel(label);
//           
                guard.getLabel().setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 100, 250);
                try {
                    guard.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("AaronSecurityGuard.png"))).getScaledInstance(guard.getLabel().getWidth(), guard.getLabel().getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);

                }

            }

        }
    }

    public void officeWorkerSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {

            if (objectsArray[0][i].equals("worker")) {

                System.out.println("Worker Coming");
                OfficeWorker worker = new OfficeWorker();
                officeWorkerStats.add(worker);
                JLabel label = new JLabel();
                worker.setLabel(label);

                worker.getLabel().setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 100, 200);
                try {
                    worker.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("officeWorker.png"))).getScaledInstance(worker.getLabel().getWidth(), worker.getLabel().getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    public void fatAlbertSpawner() {

        for (int i = 0; i < numberOfObjects; i++) {

            if (objectsArray[0][i].equals("fat")) {

                System.out.println("FAT Coming");
                FatOfficeWorker fat = new FatOfficeWorker();
                fatOfficeWorkerStats.add(fat);
                JLabel label = new JLabel();
                fat.setLabel(label);

                fat.getLabel().setBounds(Integer.parseInt(objectsArray[1][i]), Integer.parseInt(objectsArray[2][i]), 100, 250);
                try {
                    fat.getLabel().setIcon(new ImageIcon((ImageIO.read(new File("aaronFatAlbert.png"))).getScaledInstance(fat.getLabel().getWidth(), fat.getLabel().getHeight(), Image.SCALE_SMOOTH)));
                } catch (IOException ex) {
                    System.out.println("NO IMAGE");
                    Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

  
    public void bullet() {
        JLabel bullet1 = new JLabel();

        System.out.println("Label Created");
        getContentPane().add(bullet1);
        bullet1.setBounds(player.getX() + player.getWidth() + 10, player.getY(), 50, 100);

        System.out.println("Bounds Set");
        try {
            bullet1.setIcon(new ImageIcon((ImageIO.read(new File("StapleBullet.png"))).getScaledInstance(bullet1.getWidth(), bullet1.getHeight(), Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            System.out.println("NO IMAGE");
            Logger.getLogger(AaronForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Try performed");
        staplebullets.add(bullet1);

    }

   
    public void fatOfficeWorkerBullets() {
       
    }

    public boolean bulletCollisionEnemies(javax.swing.JLabel _lbl, int _x, int _y) {

        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

        for (EnemyClass item : officeWorkerStats) {
            if (rect.intersects(item.getLabel().getBounds())) {
                item.setHealth(item.getHealth() - 1);
                //  System.out.println("Enenmy Hit" + item.getHealth());
                if (item.getHealth() == 0) {
                    officeWorkerStats.remove(item);
                    getContentPane().remove(item.getLabel());
                    repaint();
                }
                return true;
            }
        }
        for (EnemyClass item : fatOfficeWorkerStats) {
            if (rect.intersects(item.getLabel().getBounds())) {
                item.setHealth(item.getHealth() - 1);
                //  System.out.println("Enenmy Hit" + item.getHealth());
                if (item.getHealth() == 0) {
                    fatOfficeWorkerStats.remove(item);
                    getContentPane().remove(item.getLabel());
                    repaint();
                }
                return true;
            }
        }
        for (EnemyClass item : securityGuardStats) {
            if (rect.intersects(item.getLabel().getBounds())) {
                item.setHealth(item.getHealth() - 1);
                //   System.out.println("Enenmy Hit" + item.getHealth());
                if (item.getHealth() == 0) {
                    securityGuardStats.remove(item);
                    getContentPane().remove(item.getLabel());
                    repaint();
                }
                return true;
            }
        }
        return false;

    }

    public boolean bulletCollisionPlayer(javax.swing.JLabel _lbl, int _x, int _y) {

        Rectangle rect = new Rectangle(_lbl.getBounds().x + _x, _lbl.getBounds().y + _y, _lbl.getWidth(), _lbl.getHeight());

        if (rect.intersects(playerCharacter.getLabel().getBounds())) {

            return true;
        }

        return false;
    }
  

    public void takeDamage() {
        System.out.println("OUCH");
        playerCharacter.setHealth(playerCharacter.getHealth() - 1);

        jProgressBar1.setValue(playerCharacter.getHealth() - 1);

        if (playerCharacter.getHealth() == 0) {
            DeathScreen deathScreen1 = new DeathScreen();
            deathScreen1.setVisible(true);
            this.setVisible(false);
            this.dispose();
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel bottomFloor;
    javax.swing.ButtonGroup buttonGroup1;
    javax.swing.JProgressBar jProgressBar1;
    javax.swing.JLabel player;
    // End of variables declaration//GEN-END:variables

}
