/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minesweeper;

import static com.mycompany.minesweeper.CellState.CLOSED;
import static com.mycompany.minesweeper.CellState.FLAG;
import static com.mycompany.minesweeper.CellState.QUESTION;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author alu10701951
 */
//SwingUtilities.isLeftMouseButton(MouseEvent anEvent) SwingUtilities.isRightMouseButton(MouseEvent anEvent) SwingUtilities.isMiddleMouseButton(MouseEvent anEvent)
public class Button extends JButton {

    public static final int SIZE = 30;
    private CellState state;

    private FlagInterface flagInterface;

    private class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            Button button = (Button) e.getSource();
            if (!SwingUtilities.isRightMouseButton(e)) {

                if (button.state == CellState.CLOSED) {
                    button.setIcon(Util.getIcon("/images/boton_pressed.jpg"));

                }
            }
        }

        public void mouseReleased(MouseEvent e) {
            Button button = (Button) e.getSource();
            if (SwingUtilities.isRightMouseButton(e)) {
                button.updateState();
            }

        }

        public void mouseClicked(MouseEvent e) {
            Button button = (Button) e.getSource();
            if (SwingUtilities.isLeftMouseButton(e)
                    && button.state == CellState.CLOSED) {
                button.state = CellState.OPEN;
                button.open();
            } else if (SwingUtilities.isRightMouseButton(e)) {
                processRightClick(button);
            }
        }

    }

    public void open() {
        state = CellState.OPEN;
        updateState();
    }

    private void processRightClick(Button button) {
        switch (button.state) {
            case CLOSED:
                button.state = CellState.FLAG;
                flagInterface.decrementFlagRemaining();
                break;
            case FLAG:
                button.state = CellState.QUESTION;
                flagInterface.incrementFlagRemaining();
                break;
            case QUESTION:
                button.state = CellState.CLOSED;
                break;
            default:
                break;
        }
        button.updateState();
        button.repaint();
    }

    private static MyMouseAdapter mouseAdapter;

    public Button() {
        super();
        myInit();
    }

    public void removeMouseAdapter() {
        removeMouseListener(mouseAdapter);
    }

    private void myInit() {
        setMargin(new Insets(0, 0, 0, 0));
        setBorderPainted(false);
        setContentAreaFilled(false);
        if (mouseAdapter == null) {
            mouseAdapter = new MyMouseAdapter();
        }
        addMouseListener(mouseAdapter);
        state = CellState.CLOSED;
        updateState();
    }

    public void updateState() {
        switch (state) {
            case CLOSED:
                setIcon(Util.getIcon("/images/boton.jpg"));
                break;
            case OPEN:
                setVisible(false);
                break;
            case FLAG:
                repaint();
                break;
            case QUESTION:
                repaint();
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (state == CellState.FLAG) {
            Icon flag = Util.getIcon("/images/flag.png");
            flag.paintIcon(this, g, 0, 0);
        } else if (state == CellState.QUESTION) {
            Icon question = Util.getIcon("/images/question.png");
            question.paintIcon(this, g, 0, 0);
        }
    }

    public void setFlagInterface(FlagInterface flagInterface) {
        this.flagInterface = flagInterface;
    }

    public boolean canBeOpened() {
        return state == CellState.CLOSED;
    }

    public boolean isOpen() {
        return state == CellState.OPEN;
    }

}
