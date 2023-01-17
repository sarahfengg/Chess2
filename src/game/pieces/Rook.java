package game.pieces;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece{
    private ImageView imageView;

    public Rook(TeamColor color) {
        this.teamColor = color;

        Image piece = new Image("game/res/chess_pieces.png", 600, 200, false, false);
        ImageView pieceView = new ImageView(piece);
        this.imageView = pieceView;
        Rectangle2D viewRect;
        if(this.teamColor == TeamColor.WHITE) {
            viewRect = new Rectangle2D( 400, 0, 100, 100);
        } else {
            viewRect = new Rectangle2D( 400, 100, 100, 100);
        }
        pieceView.setViewport(viewRect);
    }


    @Override
    public ImageView getImageView() {
        return imageView;
    }


}
