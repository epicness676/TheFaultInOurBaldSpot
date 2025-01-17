

//Program title: The FaultInOurBaldSpot 
//Author: Aaron Bester,John Diemert,Brayden McQueen, Alex Rejep
//Date: June 17th, 2019
//Program Description: The level select screen for the game



package thefaultinourbaldspot;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import Brayden.Brayden1;
import AaronPackage.AaronForm;
import AaronPackage.AaronInstructions;
import AaronPackage.LoseScreen;
import JohnPackage.JohnF;
import AlexPackage.AlexForm;
import JohnPackage.intro;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

/**
 * The application's main frame.
 */
public class TheFaultInOurBaldSpotView extends FrameView {

    public TheFaultInOurBaldSpotView(SingleFrameApplication app) {
        super(app);

        initComponents();
                    try {
                        background.setIcon(new ImageIcon((ImageIO.read(new File("B1.png"))).getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(Brayden1.class.getName()).log(Level.SEVERE, null, ex);
                    }
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = TheFaultInOurBaldSpotApp.getApplication().getMainFrame();
            aboutBox = new TheFaultInOurBaldSpotAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        TheFaultInOurBaldSpotApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        brayden = new javax.swing.JButton();
        aaron = new javax.swing.JButton();
        Alex = new javax.swing.JButton();
        john = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(1080, 720));
        mainPanel.setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(thefaultinourbaldspot.TheFaultInOurBaldSpotApp.class).getContext().getResourceMap(TheFaultInOurBaldSpotView.class);
        brayden.setText(resourceMap.getString("brayden.text")); // NOI18N
        brayden.setName("brayden"); // NOI18N
        brayden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                braydenActionPerformed(evt);
            }
        });
        mainPanel.add(brayden);
        brayden.setBounds(140, 230, 200, 50);

        aaron.setText(resourceMap.getString("aaron.text")); // NOI18N
        aaron.setName("aaron"); // NOI18N
        aaron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaronActionPerformed(evt);
            }
        });
        mainPanel.add(aaron);
        aaron.setBounds(140, 630, 200, 50);

        Alex.setText(resourceMap.getString("Alex.text")); // NOI18N
        Alex.setName("Alex"); // NOI18N
        Alex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlexActionPerformed(evt);
            }
        });
        mainPanel.add(Alex);
        Alex.setBounds(760, 230, 200, 50);

        john.setText(resourceMap.getString("john.text")); // NOI18N
        john.setName("john"); // NOI18N
        john.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                johnActionPerformed(evt);
            }
        });
        mainPanel.add(john);
        john.setBounds(760, 630, 200, 50);

        background.setName("background"); // NOI18N
        background.setPreferredSize(new java.awt.Dimension(1080, 720));
        mainPanel.add(background);
        background.setBounds(0, 0, 1080, 700);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 910, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void braydenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_braydenActionPerformed
     Brayden1 braydenObject = new Brayden1();
     braydenObject.setVisible(true);
    }//GEN-LAST:event_braydenActionPerformed

    private void aaronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aaronActionPerformed
    
            AaronInstructions aaronObject = new AaronInstructions();
            aaronObject.setVisible(true);
         
      
      
    }//GEN-LAST:event_aaronActionPerformed

    private void AlexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlexActionPerformed
     JFrame alexObject = null;
        try {
            alexObject = new AlexForm();
            //  TheFaultInOurBaldSpotView.setVisible(false);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(TheFaultInOurBaldSpotView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TheFaultInOurBaldSpotView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(TheFaultInOurBaldSpotView.class.getName()).log(Level.SEVERE, null, ex);
        }
   
     alexObject.setVisible(true); 
     // TODO add your handling code here:
    }//GEN-LAST:event_AlexActionPerformed

    private void johnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_johnActionPerformed
   intro johnObject = new intro();   
   johnObject.setVisible(true);
   
    }//GEN-LAST:event_johnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton Alex;
    javax.swing.JButton aaron;
    javax.swing.JLabel background;
    javax.swing.JButton brayden;
    javax.swing.JButton john;
    javax.swing.JPanel mainPanel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
