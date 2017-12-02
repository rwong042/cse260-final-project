

/**
 * This object represents an individual Square in the sudoku grid,
 * not to be used with the actual implementation of the gui, or the puzzle object.
 * 
 *
 * @author Hackerman9000
 */
public class Square {
    private int value; 
    private boolean mutable;

    public Square(int value) {
        this.value = value;
        this.mutable = false;
    }

    public Square(int value, boolean mutable) {
        this.value = value;
        this.mutable = mutable;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the mutable
     */
    public boolean isMutable() {
        return mutable;
    }

    /**
     * @param mutable the mutable to set
     */
    public void setMutable() {
        this.mutable = true;
    }
}
