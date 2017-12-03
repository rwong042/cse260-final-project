

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
    private int region;
    private int row,col;

    public Square() {
        this.value = 0;
        this.mutable = false;
        this.region = 0;
        this.row = -1;
        this.col = -1;
    }
    public Square(int value) {
        this.value = value;
        this.mutable = false;
    }

    public Square(int value, boolean mutable) {
        this.value = value;
        this.mutable = mutable;
    }
    public Square(int row, int col) {
        this.value = 0;
        this.mutable = false;
        this.region = 0;
        this.row = row;
        this.col = col;
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
     * @return the region
     */
    public int getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(int region) {
        this.region = region;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * @param mutable the mutable to set
     */
    public void setMutable() {
        this.mutable = true;
    }


}
