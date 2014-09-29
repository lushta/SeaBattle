package graphic;

import main.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lushta on 29.04.14.
 */
public class SwitchPanel extends JPanel {

    private JButton pl1Button;
    private JButton pl2Button;
    private JButton hideButton;
    private JLabel actionsPL1;
    private JLabel actionsPL2;

    public SwitchPanel(){
        init();
    }

    public void init(){
        actionsPL1 = new JLabel("0");
        pl1Button = new JButton("player1Move");
        hideButton = new JButton("Hide");
        pl2Button = new JButton("player2Move");
        actionsPL2 = new JLabel("0");

        pl1Button.addActionListener(new SwitchListener());
        pl2Button.addActionListener(new SwitchListener());
        hideButton.addActionListener(new SwitchListener());
        pl1Button.setBackground(Color.RED);
        add(new JLabel("Player 1 field               "));
        add(actionsPL1);
        add(pl1Button);
        add(hideButton);
        add(pl2Button);
        add(actionsPL2);
        add(new JLabel("               Player 2 field"));

    }

    public class SwitchListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            GameController.changeSwitch(event);
        }
    }

    public void setActionsPL1(String str) {
        actionsPL1.setText(str);
    }

    public void setActionsPL2(String str) {
        actionsPL2.setText(str);
    }
}
