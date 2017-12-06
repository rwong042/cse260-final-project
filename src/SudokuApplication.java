import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SudokuApplication extends Application {

    private static final int NUM_OF_TILES = 81;
    private static final int NUM_PER_ROW = 9;
    private static final int NUM_PER_COL = 9;

    private Parent createContent() {
        Pane root = new Pane();
        root.getChildren().add(initializeBoard());
        return root;
    }

    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private Parent initializeBoard() {
        Pane root = new Pane();
        root.setPrefSize(600,600);
        
        ArrayList<Square> squares = SudokuGenerator.generate().getAllSquares();
        Iterator<Square> it = squares.iterator();
        
        char c = 'A';
        List<Tile> tiles = new ArrayList<Tile>();
        //for(int i=0;i<NUM_OF_TILES;i++) {
            //Tile toAdd = new Tile(String.valueOf(c), true);
            //tiles.add(toAdd);
        //}
        
        for(int i=0;i<NUM_PER_COL;i++) {
            for(int j=0;j<NUM_PER_ROW;j++) {
                Tile toAdd = new Tile(String.valueOf(it.next().getValue()), true);
                if(j==2) {
                    toAdd.setBorder(new Border(new BorderStroke(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,
                                BorderStrokeStyle.NONE,BorderStrokeStyle.SOLID,BorderStrokeStyle.NONE,BorderStrokeStyle.NONE,
                                CornerRadii.EMPTY, new BorderWidths(5), Insets.EMPTY)));
                }
                if(j==6) {
                    toAdd.setBorder(new Border(new BorderStroke(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,
                                BorderStrokeStyle.NONE,BorderStrokeStyle.NONE,BorderStrokeStyle.NONE,BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY, new BorderWidths(5), Insets.EMPTY)));
                }
                if(i==2) {
                    toAdd.setBorder(new Border(new BorderStroke(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,
                                BorderStrokeStyle.NONE,BorderStrokeStyle.NONE,BorderStrokeStyle.SOLID,BorderStrokeStyle.NONE,
                                CornerRadii.EMPTY, new BorderWidths(5), Insets.EMPTY)));
                }
                if(i==6) {
                    toAdd.setBorder(new Border(new BorderStroke(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,
                                BorderStrokeStyle.SOLID,BorderStrokeStyle.NONE,BorderStrokeStyle.NONE,BorderStrokeStyle.NONE,
                                CornerRadii.EMPTY, new BorderWidths(5), Insets.EMPTY)));
                }
                if(i==2 && j==2) {
                    toAdd.setBorder(new Border(new BorderStroke(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,
                                BorderStrokeStyle.NONE,BorderStrokeStyle.SOLID,BorderStrokeStyle.SOLID,BorderStrokeStyle.NONE,
                                CornerRadii.EMPTY, new BorderWidths(5), Insets.EMPTY)));
                }
                if(i==2 && j==6) {
                    toAdd.setBorder(new Border(new BorderStroke(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,
                                BorderStrokeStyle.NONE,BorderStrokeStyle.NONE,BorderStrokeStyle.SOLID,BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY, new BorderWidths(5), Insets.EMPTY)));
                }
                if(i==6 && j==2) {
                    toAdd.setBorder(new Border(new BorderStroke(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,
                                BorderStrokeStyle.SOLID,BorderStrokeStyle.SOLID,BorderStrokeStyle.NONE,BorderStrokeStyle.NONE,
                                CornerRadii.EMPTY, new BorderWidths(5), Insets.EMPTY)));
                }
                if(i==6 && j==6) {
                    toAdd.setBorder(new Border(new BorderStroke(Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,
                                BorderStrokeStyle.SOLID,BorderStrokeStyle.NONE,BorderStrokeStyle.NONE,BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY, new BorderWidths(5), Insets.EMPTY)));
                }
                tiles.add(toAdd);
            }
        }
        
        for(int i=0;i<tiles.size();i++) {
            Tile tile = tiles.get(i);
            tile.setTranslateX(55 * (i % NUM_PER_ROW));
            tile.setTranslateY(55 * (i / NUM_PER_ROW));
            root.getChildren().add(tile);
        }
        
        return root;
    }


    private class Tile extends Button {
        
        public Tile(String value, boolean modifiable) {
            setDisable(!modifiable);
            setPrefSize(55,55);
            //Rectangle border = new Rectangle(50,50);
            //border.setFill(null);
            //border.setStroke(Color.BLACK);
            
            //getChildren().add(border);
            
            updateText(value);
            
        }
        
        public void updateText(String newText) {
            setFont(Font.font(18));
            setText(newText);
            setTextAlignment(TextAlignment.CENTER); 
        }
        
    }

}
