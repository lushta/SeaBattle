package logic;

/**
 * Created by lushta on 28.04.14.
 */
public class Player {

    private Field playerField;
    private boolean isActive;
    private int countActions;

    public Player(){
        playerField = new Field();
        countActions = 0;
    }

    public Field getPlayerField() {
        return playerField;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getCountActions() {
        return countActions;
    }

    public void addActions() {
        countActions++;
    }
}
