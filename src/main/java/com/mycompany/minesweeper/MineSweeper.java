/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.minesweeper;

import java.awt.Dimension;

/**
 *
 * @author alu10701951
 */
public class MineSweeper extends javax.swing.JFrame {

    /**
     * Creates new form MineSweeper
     */
    public MineSweeper() {
        initComponents();
        myInit(); 
    }
    
    private Dimension getBoardDimension(){
        int width = Button.SIZE * Config.instance.getNumCols();
        int height = Button.SIZE * Config.instance.getNumRows();
        return new Dimension(width,height);
    }
    
     private void myInit() {
        setLocationRelativeTo(null);
        board.setTimerInterface(upperPanel);
        board.setPreferredSize(getBoardDimension());
        upperPanel.setPreferredSize(new Dimension(100,100));
        upperPanel.setInitGamer(board);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new com.mycompany.minesweeper.UpperPanel();
        board = new com.mycompany.minesweeper.Board();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().add(upperPanel, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(board, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 323, 402);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MineSweeper().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.minesweeper.Board board;
    private com.mycompany.minesweeper.UpperPanel upperPanel;
    // End of variables declaration//GEN-END:variables

   
}
