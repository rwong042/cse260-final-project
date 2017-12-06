import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is meant to represent a Sudoku puzzle object, namely an array of squares with values in them.
 *
 * @author Hackerman9000
 */
public class SudokuPuzzle {

    private Square[][] squares;

    /**
     * Constructor with a specified array of values.
     *
     * @param values
     */
    public SudokuPuzzle(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * {@inheritDoc}
     * If no parameters are provided, this constructor generates a blank 9x9 grid with Square values set to null.
     *
     * @see Object#SudokuPuzzle()
     */
    public SudokuPuzzle() {
        this.squares = new Square[9][9];
        for(int i=0;i<squares.length;i++) {
            for(int j=0;j<squares[0].length;j++) {
                
                
                squares[i][j] = new Square(i,j);
                
                squares[i][j].setRow(i);
                squares[i][j].setCol(j);
                
                setRegion(squares[i][j]);
                
                System.out.println(getSquare(i,j).getRow() + "," + getSquare(i,j).getCol() + " region " + getSquare(i,j).getRegion());
            }
        }
        System.out.println(Arrays.toString(getRow(3)) + "   |||   " + Arrays.toString(getCol(3)));
    }

    /**
     * Private method for setting the region of a specified square, by checking all possible 9 cases
     */
    private void setRegion(Square s) {
        int row = s.getRow();
        int col = s.getCol();
        
        if(row<=2) {
            if(col<=2) {
                s.setRegion(1);
            }
            else if(col<=5) {
                s.setRegion(2);
            }
            else if(col<=8) {
                s.setRegion(3);
            }
        }
        else if(row<=5) {
            if(col<=2) {
                s.setRegion(4);
            }
            else if(col<=5) {
                s.setRegion(5);
            }
            else if(col<=8) {
                s.setRegion(6);
            }
        }
        else if(row<=8) {
            if(col<=2) {
                s.setRegion(7);
            }
            else if(col<=5) {
                s.setRegion(8);
            }
            else if(col<=8) {
                s.setRegion(9);
            }
        }
    }

    /**
     * Returns an arraylist of all the values of the squares in a specified region
     *
     * @return a list of all values in the specified region
     */
    public ArrayList<Integer> getValuesInRegion(int regionNum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Square s : getAllSquares()) {
            if(s.getRegion() == regionNum) {
                list.add(s.getValue());
            }
        }
        return list;
    }

    /**
     * Returns an arraylist of all the square objects in the board, in order
     */
    public ArrayList<Square> getAllSquares() {
        ArrayList<Square> list = new ArrayList<Square>();
        for(int i=0;i<81;i++) {
            list.add(getSquare(i+1));
        }
        return list;
    }


    /**
     * Returns the square object at the specified position on the board.
     */
    public Square getSquare(int row, int col) {
        return squares[row][col];
    }

    public Square getSquare(int squareNumber) {
        int counter = 0;
        
        int i=0;
        while(i<9) {
            int j=0;
            while(j<9) {
                counter++;
                if(counter == squareNumber) {
                    return squares[i][j];
                }
                j++;
            }
            i++;
        }
        return null;
    }

    public void setSquare(Square toSet, int squareNumber) {
        int counter = 0;
        
        int i=0;
        while(i<9) {
            int j=0;
            while(j<9) {
                counter++;
                if(counter == squareNumber) {
                    squares[i][j] = toSet;
                }
                j++;
            }
            i++;
        }
    }

    /**
     * Sets the square at the specified position to a new square specified by the Square parameter.
     */
    public void setSquare(int row, int col, Square toSet) {
        squares[row][col] = toSet;
    }

    public Square[] getRow(int row) {
        return squares[row];
    }

    public Square[] getCol(int col) {
        Square[] colArray = new Square[9];
        for(int i=0;i<squares[0].length;i++) {
            colArray[i] = squares[i][col];
        }
        return colArray;
    }

}
