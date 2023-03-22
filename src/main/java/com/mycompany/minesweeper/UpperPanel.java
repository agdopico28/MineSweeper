/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author alu10701951
 */
public class UpperPanel extends javax.swing.JPanel implements TimerInterface, FlagInterface {

    /**
     * Creates new form UpperPanel
     */
    
    private Timer timer;
    private int seconds;
    private InitGamer initGamer;
    private int flagRemaining;
    
    
    public UpperPanel() {
        initComponents();
        myInit();
    }

    private void myInit() {
        resetFlagRemainig();
        buttonSmile.setFocusable(false);
        Border border = labelTime.getBorder();
        Border margin = new EmptyBorder(7, 5, 5,5);
        labelTime.setBorder(new CompoundBorder(border, margin));
        labelRemaining.setBorder(new CompoundBorder(border, margin));
        seconds = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tick();
            }
        });
        
    }

    private void resetFlagRemainig() {
        flagRemaining = Config.instance.getNumBombs();
        updateLabelRemaining();
    }
    
    private void tick(){
        seconds++;
        int min = seconds / 60;
        int sec = seconds % 60;
        updateTimerLabel(min, sec);
    }
    
    
    public void updateTimerLabel(int min, int sec){
        String timerStr = String.format("%02d:%02d", min, sec);
        labelTime.setText(timerStr);
    }

    public void setInitGamer(InitGamer initGamer) {
        this.initGamer = initGamer;
    }
    
    public void updateLabelRemaining(){
        String remainingStr = String.format("%03d",flagRemaining);
        labelRemaining.setText(remainingStr);
    }
    
    @Override
    public void incrementFlagRemaining() {
        flagRemaining++;
        updateLabelRemaining();
    }

    @Override
    public void decrementFlagRemaining() {
        flagRemaining--;
        updateLabelRemaining();
    }
    
     @Override
    public void startTimer() {
        if(!timer.isRunning()){
             timer.start();
        }
    }
    
    @Override
    public void stopTimer(){
       timer.stop();
    }
    



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        labelRemaining = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelTime = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        buttonSmile = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        labelRemaining.setBackground(new java.awt.Color(0, 0, 0));
        labelRemaining.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        labelRemaining.setForeground(new java.awt.Color(255, 0, 0));
        labelRemaining.setText("999");
        labelRemaining.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 18, 40, 18);
        jPanel1.add(labelRemaining, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        labelTime.setBackground(new java.awt.Color(0, 0, 0));
        labelTime.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        labelTime.setForeground(new java.awt.Color(255, 0, 0));
        labelTime.setText("00:00");
        labelTime.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 28, 30, 26);
        jPanel2.add(labelTime, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        buttonSmile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smiley.png"))); // NOI18N
        buttonSmile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSmileActionPerformed(evt);
            }
        });
        jPanel4.add(buttonSmile, new java.awt.GridBagConstraints());

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSmileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSmileActionPerformed
        initGamer.initGame();
        seconds = 0;
        timer.restart();
        updateTimerLabel(0, 0);
        resetFlagRemainig();
    }//GEN-LAST:event_buttonSmileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSmile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelRemaining;
    private javax.swing.JLabel labelTime;
    // End of variables declaration//GEN-END:variables

    

   
    
}
