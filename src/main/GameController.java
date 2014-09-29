package main;

import logic.Player;
import graphic.FieldPanel;
import graphic.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by lushta on 28.04.14.
 */
public class GameController {

    private static Player player1;
    private static Player player2;
    private static JFrame frame = new JFrame();
    private static FieldPanel panel1;
    private static FieldPanel panel2;
    private static SwitchPanel switchPanel;

    public GameController(){
        player1 = new Player();
        player2 = new Player();
    }

    public void start(){
        frame.setSize(700, 350);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel1 = new FieldPanel();
        panel2 = new FieldPanel();
        frame.add(panel1, BorderLayout.WEST);
        frame.add(panel2, BorderLayout.EAST);
        switchPanel = new SwitchPanel();
        frame.add(switchPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        player1.setActive(true);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setActiveFalse(Player player){
        if (player1 == player){

            SwitchPanel sw = (SwitchPanel)frame.getContentPane().getComponent(2);
            JButton button = (JButton)sw.getComponent(2);
            button.setBackground(Color.GRAY);
            button = (JButton)sw.getComponent(4);
            button.setBackground(Color.RED);
            sw.setActionsPL1(""+player1.getCountActions());
            sw.setActionsPL2(""+player2.getCountActions());
            if (player1.isActive()){
                player1.setActive(false);
                player2.setActive(true);
                panel2.hideField();

            }
            panel1.hideField();
        }
        if (player2 == player){

            SwitchPanel sw = (SwitchPanel)frame.getContentPane().getComponent(2);
            JButton button = (JButton)sw.getComponent(2);
            button.setBackground(Color.RED);
            button = (JButton)sw.getComponent(4);
            button.setBackground(Color.GRAY);
            sw.setActionsPL1(""+player1.getCountActions());
            sw.setActionsPL2(""+player2.getCountActions());
            if(player2.isActive()){
                player2.setActive(false);
                player1.setActive(true);
                panel1.hideField();
            }
            panel2.hideField();

        }
    }

    public static void changeSwitch(ActionEvent event){

        if(event.getSource() == switchPanel.getComponent(3)){
            FieldPanel p1 = (FieldPanel) frame.getContentPane().getComponent(0);
            p1.hideField();
            FieldPanel p2 = (FieldPanel) frame.getContentPane().getComponent(1);
            p2.hideField();
        }
        else if(event.getSource() == switchPanel.getComponent(2) && player1.isActive()){
            FieldPanel p1 = (FieldPanel) frame.getContentPane().getComponent(0);
            p1.showField();
            FieldPanel p2 = (FieldPanel) frame.getContentPane().getComponent(1);
            p2.hideField();
        }
        else if(event.getSource() == switchPanel.getComponent(4) && player2.isActive()){
            FieldPanel p1 = (FieldPanel) frame.getContentPane().getComponent(0);
            p1.hideField();
            FieldPanel p2 = (FieldPanel) frame.getContentPane().getComponent(1);
            p2.showField();
        }

    }

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static FieldPanel getPanel1() {
        return panel1;
    }

    public static FieldPanel getPanel2() {
        return panel2;
    }
}

