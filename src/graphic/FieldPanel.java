package graphic;

import logic.Cell;
import logic.Field;
import main.GameController;
import logic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lushta on 29.04.14.
 */
public class FieldPanel extends JPanel {

    public FieldPanel(){
        setLayout(new GridLayout(10, 10));
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                JButton button = new JButton();
                add(button);
                button.setBackground(Color.BLACK);
                button.addActionListener(new ButtonListener());
            }
        }
        hideField();

    }

    public class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Player nativePlayer = null;
            Player rivalPlayer = null;
            if(GameController.getPanel1() == FieldPanel.this){
                nativePlayer = GameController.getPlayer1();
                rivalPlayer = GameController.getPlayer2();
            }
            else if(GameController.getPanel2() == FieldPanel.this){
                nativePlayer = GameController.getPlayer2();
                rivalPlayer = GameController.getPlayer1();
            }
            if(!nativePlayer.isActive()){

                JButton button = (JButton)event.getSource();
                int[] indexes = getIndexOfButton(button);
                Field field = nativePlayer.getPlayerField();
                Cell cell = field.getField().get(indexes[0]).get(indexes[1]);
                if(cell.isInShip()){
                    cell.setShot(true);
                    cell.setVisible(true);
                    rivalPlayer.addActions();
                    GameController.setActiveFalse(nativePlayer);
                }
                else {
                    cell.setVisible(true);
                    rivalPlayer.addActions();
                    GameController.setActiveFalse(rivalPlayer);
                }
            }
        }
    }

    public int[] getIndexOfButton(JButton button){
        int[] res = null;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(button == this.getComponent(i*10 + j)){
                    res = new int[2];
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public void hideField(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                JButton button = (JButton) this.getComponent(i*10 + j);
                Player nativePlayer = GameController.getPlayer2();
                if(GameController.getPanel1() == FieldPanel.this){
                    nativePlayer = GameController.getPlayer1();
                }
                Cell cell = nativePlayer.getPlayerField().getField().get(i).get(j);
                if(cell.isVisible()){
                    if(cell.isShot()){
                        button.setBackground(Color.RED);
                    }
                    else {
                        button.setBackground(Color.WHITE);
                    }
                }
                else {
                    button.setBackground(Color.BLACK);
                }
            }
        }
    }

    public void showField(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                JButton button = (JButton) this.getComponent(i*10 + j);
                Player nativePlayer = null;
                if(GameController.getPanel1() == FieldPanel.this){
                    nativePlayer = GameController.getPlayer1();
                }
                else if(GameController.getPanel2() == FieldPanel.this){
                    nativePlayer = GameController.getPlayer2();
                }
                Cell cell = nativePlayer.getPlayerField().getField().get(i).get(j);
                if(cell.isInShip()){
                    if(cell.isShot()){
                        button.setBackground(Color.RED);
                    }
                    else {
                        button.setBackground(Color.PINK);
                    }
                }
                else{
                    button.setBackground(Color.WHITE);
                }
            }
        }
    }
}
