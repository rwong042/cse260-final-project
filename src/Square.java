import java.util.ArrayList;
import java.util.Arrays;

/**
 * This object represents an individual Square in the sudoku grid,
 * not to be used with the actual implementation of the gui, or the puzzle object.
 * 
 *
 * @author Hackerman9000
 */
public class Square {
    public static final ArrayList<Integer> VALID_VALUES = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    private int value; 
    private boolean mutable;
    private int region;
    private int row,col;
    private ArrayList<Integer> possibleValues = new ArrayList<Integer>(VALID_VALUES);
    private ArrayList<Integer> resetValues = new ArrayList<Integer>(VALID_VALUES);

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

    public String toString() {
        return "(" + getRow() + "," + getCol() + "):" + getValue() + "r" + getRegion();
    }
    
    //GETTERS AND SETTERS
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
     * @return the possibleValues
     */
    public ArrayList<Integer> getPossibleValues() {
        return possibleValues;
    }

    /**
     * @param possibleValues the possibleValues to set
     */
    public void setPossibleValues(ArrayList<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    /**
     * @return the resetValues
     */
    public ArrayList<Integer> getResetValues() {
        return resetValues;
    }

    /**
     * @param mutable the mutable to set
     */
    public void setMutable() {
        this.mutable = true;
    }

}
