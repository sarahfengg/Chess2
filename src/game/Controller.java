package game;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import game.pieces.Piece;
import game.pieces.TeamColor;

public class Controller {
    Stage display;
    StackPane root;
    GridPane gridPane;
    Board board;

    public Controller(Stage display, StackPane root) {
        this.display = display;
        this.root = root;
        board = new Board();
        initializeDisplay();
    }

    //Game Controller
    public TeamColor checkWin() {
        return null;
    }

    public boolean checkChecks() {
        return false;
    }

    public void initializeDisplay() {
        gridPane = new GridPane();
        root.getChildren().add(gridPane);
        for(int i = 0; i < 8; i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(100)); // column 0 is 100 wide
            gridPane.getRowConstraints().add(new RowConstraints(100)); // column 0 is 100 wide
        }
        gridPane.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
            System.out.println("" + e.getX() + ' ' + e.getY());
            clicked(e.getX(), e.getY());
        });

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board.getBoardArray()[i][j] != null) {
                    gridPane.add(board.getBoardArray()[i][j].getImageView(), j, i);
                }
            }
        }
    }

    public void updateDisplay() {
        gridPane.getChildren().clear();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board.getBoardArray()[i][j] != null) {
                    gridPane.add(board.getBoardArray()[i][j].getImageView(), j, i);
                }
            }
        }
    }

    public void clicked(double x, double y) {

    }
}
