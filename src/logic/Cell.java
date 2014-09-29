package logic;

/**
 * Created by lushta on 28.04.14.
 */
public class Cell {

    private boolean isShot;
    private boolean isVisible;
    private boolean isInShip;

    public Cell(int x, int y){
        isShot = false;
        isVisible = false;
        isInShip = false;
    }

    public boolean isShot() {
        return isShot;
    }

    public void setShot(boolean isShot) {
        this.isShot = isShot;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean isInShip() {
        return isInShip;
    }

    public void setInShip(boolean isInShip) {
        this.isInShip = isInShip;
    }
}
