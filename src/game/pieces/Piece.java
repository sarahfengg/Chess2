package game.pieces;

import javafx.scene.image.ImageView;

public abstract class Piece {
    protected int id;
    protected TeamColor teamColor;

    public abstract ImageView getImageView();

}
