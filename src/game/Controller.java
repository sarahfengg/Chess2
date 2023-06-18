package game;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import game.pieces.Piece;
import game.pieces.TeamColor;
import javafx.scene.image.Image;

//notes:
//detect if moe is legal or notlegal
//easiest way is too code for everysingle different piece :rook
//is rook in straight line
//is there a piece blocking?
// also do bisop

public class Controller {
    Stage display;
    StackPane root;
    GridPane gridPane;
    Board board;
    TeamColor currentPlayer = TeamColor.WHITE;

    int selectedPieceCordX = -1;
    int selectedPieceCordY = -1;

    boolean pieceSelected = false;

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
                    if (selectedPieceCordY == i && selectedPieceCordX == j) {
                        Image yellowSquare = new Image ("game/res/yellow_square.jpeg");
                        ImageView yellowSquareView = new ImageView(yellowSquare);
                        gridPane.add(yellowSquareView, j, i);
                        yellowSquareView.setFitHeight(100);
                        yellowSquareView.setFitWidth(100);

                    }
                    gridPane.add(board.getBoardArray()[i][j].getImageView(), j, i);
                }
            }
        }
    }

    public void clicked(double x, double y) {

        if (x < 0 || x >= 800 || y < 0 || y >= 800) {
            return;
        }

        int squareX;
        int squareY;

        squareY = (int) y / 100;
        squareX = (int) x / 100;


        if (!pieceSelected) {
            if (board.getBoardArray()[squareY][squareX] != null && board.getBoardArray()[squareY][squareX].getTeamColor() == currentPlayer) {
                selectedPieceCordX = squareX;
                selectedPieceCordY = squareY;
                pieceSelected = true;
            } else {
                return;
            }
        } else {
            if (selectedPieceCordX == squareX && selectedPieceCordY == squareY) {
                pieceSelected = false;
            }
            else if (board.getBoardArray()[squareY][squareX] == null || board.getBoardArray()[squareY][squareX].getTeamColor() != currentPlayer) {
                if (board.getBoardArray()[selectedPieceCordY][selectedPieceCordX].canMove(board.getBoardArray(), selectedPieceCordX, selectedPieceCordY, squareX, squareY)) {
                    board.getBoardArray()[squareY][squareX] = board.getBoardArray()[selectedPieceCordY][selectedPieceCordX];
                    board.getBoardArray()[selectedPieceCordY][selectedPieceCordX] = null;
                    pieceSelected = false;

                }
                switchPlayer();

            }

        }
        updateDisplay();
    }


    public void switchPlayer(){
        if(currentPlayer == TeamColor.WHITE) currentPlayer = TeamColor.BLACK;
        else{
             currentPlayer = TeamColor.WHITE;
        }
    }

}
