package game.pieces;

import javafx.scene.image.ImageView;

public abstract class Piece {
    protected int id;
    protected TeamColor teamColor;

    public abstract TeamColor getTeamColor();

    public abstract ImageView getImageView();

    public abstract boolean canMove( Piece[][] board,  int currantX, int currantY, int targetX, int targetY);

}
