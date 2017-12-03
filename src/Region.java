import java.util.HashMap;

/**
 * Object used to represent a 3x3 region.
 *
 * @author Hackerman9000
 */
public class Region {

    private HashMap<Square,Integer> squareMap;
    
    public Region() {
        squareMap = new HashMap<Square,Integer>(9);
    }

    public boolean addSquare(Square s) {
        if(checkIfValuePresent(s)) {
            return false;
        }
        else {
            squareMap.put(s,s.getValue());
            return true;
        }
    }

    private boolean checkIfValuePresent(Square s) {
        return squareMap.containsValue(s.getValue());
    }

}
