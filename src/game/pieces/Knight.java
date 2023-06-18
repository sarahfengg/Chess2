package game.pieces;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
// cant be blocked
//make sure L shape
public class Knight extends Piece {
    private ImageView imageView;

    @Override
    public TeamColor getTeamColor() {
        return this.teamColor;
    }

    public Knight(TeamColor color) {
        this.teamColor = color;

        Image piece = new Image("game/res/chess_pieces.png", 600, 200, false, false);
        ImageView pieceView = new ImageView(piece);
        this.imageView = pieceView;
        Rectangle2D viewRect;
        if (this.teamColor == TeamColor.WHITE) {
            viewRect = new Rectangle2D(300, 0, 100, 100);
        } else {
            viewRect = new Rectangle2D(300, 100, 100, 100);
        }
        pieceView.setViewport(viewRect);
    }


    @Override
    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public boolean canMove(Piece[][] board, int currentX, int currentY, int targetX, int targetY) {
        //bounds
        if (targetX < 0 || targetX >= 8 || targetY < 0 || targetY >= 8) {
            return false;
        }
        //distance
        int distancex = Math.abs(targetX - currentX);
        int distancey = Math.abs(targetY - currentY);


        if ((distancex == 2 && distancey == 1) || (distancex == 1 && distancey == 2)) {
            return true;
        }

        return false;
    }
}