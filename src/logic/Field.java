package logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lushta on 28.04.14.
 */
public class Field {

    private List<ArrayList<Cell>> field;

    public Field(){
        field = new ArrayList<ArrayList<Cell>>();
        init();
    }

    private void init(){
        for(int i = 0; i < 10; i++){
            field.add(new ArrayList<Cell>());
            for(int j = 0; j < 10; j++){
                field.get(i).add(new Cell(i, j));
            }
        }
        createShip(4);
        createShip(3);
        createShip(3);
        createShip(2);
        createShip(2);
        createShip(2);
        createShip(1);
        createShip(1);
        createShip(1);
        createShip(1);
    }

    private boolean getDirection(){
        int random = (int) (Math.random()*100);
        if(random < 50){
            return true;
        }
        return false;
    }

    private void createShip(int length){

        boolean direction = false;
        int begX = -1;
        int endX;
        int begY = -1;
        int endY;
        direction = getDirection();
        if(direction){
            endX = 9;
            endY = 10 - length;
        }
        else{
            endX = 10 - length;
            endY = 9;
        }

        while(true){
            int x = getRandomNumber(begX, endX);
            int y = getRandomNumber(begY, endY);
            int maxY = y + length + 2;
            int maxX = x + 3;
            if(!direction){
                maxY = y +3;
                maxX = x + length + 2;
            }
            boolean isEmpty = true;
            for(int i = x; i < maxX; i++){
                for(int j = y; j < maxY; j++){
                    if(i>=0 && i<10 && j>=0 && j<10){
                        if(field.get(i).get(j).isInShip()){
                            isEmpty = false;
                        }
                    }
                }
            }
            if(!isEmpty){
                continue;
            }
            if(direction){
                for(int i = y + 1; i <= y + length; i++){
                    field.get(x+1).get(i).setInShip(true);
                }
            }
            else {
                for(int i = x + 1; i <= x + length; i++){
                    field.get(i).get(y+1).setInShip(true);
                }
            }
            break;
        }
    }

    private int getRandomNumber(int beg, int end){
        return  (int) (Math.random()*(end-beg) + beg);
    }

    public List<ArrayList<Cell>> getField() {
        return field;
    }
}
