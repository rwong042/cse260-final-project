import java.util.ArrayList;

public class SudokuGenerator {

    public static SudokuPuzzle generate() {
        SudokuPuzzle board = new SudokuPuzzle();
        
        assignValues(board,1);
        
        return board;
    }

    /**
     * Algorithm that assigns all of the squares values in order to create the sudoku board.
     * 
     * @param squareNumber The number of the square that we are going to modify.
     */
    private static void assignValues(SudokuPuzzle board, int squareNumber) {
        
        //check if the square has any possible values
        Square toModify = board.getSquare(squareNumber);
        int sizeOfPossibleValues = toModify.getPossibleValues().size();
        //**
        System.out.println("Square to modify is " + toModify.getRow() + "," + toModify.getCol() + "Number " + squareNumber);
        System.out.println("Possible values: " + toModify.getPossibleValues().toString());
        //**
        
        if(sizeOfPossibleValues == 0) {
            //**
            System.out.println("no possible values"); 
            //**
            //if there are no possible values, set all possible values back and go back one square
            toModify.setPossibleValues(new ArrayList<Integer>(Square.VALID_VALUES));
            //additionally, set the value of the square to 0 so that the generator doesn't count it
            toModify.setValue(0);
            board.setSquare(toModify, squareNumber);
            //cleanup
            toModify = null;
            assignValues(board, squareNumber-1);
            return;
        }
        
        //generate a random number, use it to pick a random value for the square 
        int random = RandomValueSelector.choose(sizeOfPossibleValues);
        int randomValue = toModify.getPossibleValues().get(random);
        
        //check if the value is a valid value, check if region has value first
        for(int value : board.getValuesInRegion(toModify.getRegion())) {
            if(randomValue == value) {
                toModify.getPossibleValues().remove(Integer.valueOf(value));
                board.setSquare(toModify, squareNumber);
                toModify = null;
                assignValues(board, squareNumber);
                return;
            }
        }
        //continue checking if value is valid, check against row now
        for(Square s : board.getRow(toModify.getRow())) {
            if(randomValue == s.getValue()) {
                toModify.getPossibleValues().remove(Integer.valueOf(s.getValue()));
                board.setSquare(toModify, squareNumber);
                toModify = null;
                assignValues(board, squareNumber);
                return;
            }   
        }
        //continue checking against column
        for(Square s : board.getCol(toModify.getCol())) {
            if(randomValue == s.getValue()) {
                toModify.getPossibleValues().remove(Integer.valueOf(s.getValue()));
                board.setSquare(toModify, squareNumber);
                toModify = null;
                assignValues(board, squareNumber);
                return;
            }
        }
        
        //assuming there are no conflicts, this value may be used
        toModify.setValue(randomValue);
        toModify.getPossibleValues().remove(Integer.valueOf(randomValue));
        board.setSquare(toModify, squareNumber);
        //**
        System.out.println("value selected: " + toModify.getValue());
        //**
        toModify = null;
        //now move on to next square
        
        if(squareNumber == 81) {
            return;
        }
        
        assignValues(board, squareNumber+1);
        return;
    }
}
