import java.util.stream.IntStream;
import java.util.stream.Stream;

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
                //System.out.println(getSquare(i,j).getRow() + "," + getSquare(i,j).getCol() + " region " + getSquare(i,j).getRegion());
            }
        }
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
     * Returns the square object at the specified position on the board.
     */
    public Square getSquare(int row, int col) {
        return squares[row][col];
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
        return (Square[])(IntStream.range(0, squares.length)
            .mapToObj(i -> squares[i][col]).toArray());
    }

}
