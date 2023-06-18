package game.pieces;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen extends Piece{
    private ImageView imageView;
    @Override
    public TeamColor getTeamColor(){
        return this.teamColor;
    }

    public Queen(TeamColor color) {
        this.teamColor = color;

        Image piece = new Image("game/res/chess_pieces.png", 600, 200, false, false);
        ImageView pieceView = new ImageView(piece);
        this.imageView = pieceView;
        Rectangle2D viewRect;
        if(this.teamColor == TeamColor.WHITE) {
            viewRect = new Rectangle2D( 100, 0, 100, 100);
        } else {
            viewRect = new Rectangle2D( 100, 100, 100, 100);
        }
        pieceView.setViewport(viewRect);
    }


    @Override
    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public boolean canMove(Piece[][] board, int currentX, int currentY, int targetX, int targetY) {
        //bottom right
        if(targetY - currentY == targetX - currentX && targetY - currentY > 0) {
            int dist = targetY - currentY;
            for(int i = 1; i < dist; i ++){
                if (board[currentY + i][currentX + i]!= null){
                    return false;
                }

            }
            return true;
            //top left
        } else if (Math.abs(targetY - currentY) == Math.abs(targetX - currentX) && Math.abs(targetY - currentY) > 0 && Math.abs(targetX - currentX) > 0) {
            int dist = Math.abs(targetY - currentY);
            for (int i = 1; i < dist; i++) {
                if (board[currentY - i][currentX - i] != null) {
                    return false;
                }
            }
            return true;
            //top right
        } else if ((targetY - currentY) == (targetX - currentX) && targetY - currentY > 0 && targetX - currentX > 0) {
            int dist = Math.abs(targetY - currentY);
            for (int i = 1; i < dist; i++) {
                if (board[currentY - i][currentX - i] != null) {
                    return false;
                }
            }
            return true;

            //bottom left
        } else if (targetY - currentY == Math.abs(targetX - currentX) && targetY - currentY > 0 && Math.abs(targetX - currentX) > 0) {
            int dist = Math.abs(targetY - currentY);
            for (int i = 1; i < dist; i++) {
                if (board[currentY + i][currentX - i] != null) {
                    return false;
                }
            }
            return true;
            //bottom right
        } else if (Math.abs(targetY - currentY) == Math.abs(targetX - currentX) && targetY - currentY > 0 && targetX - currentX > 0) {
            int dist = Math.abs(targetY - currentY);
            for (int i = 1; i < dist; i++) {
                if (board[currentY + i][currentX + i] != null) {
                    return false;
                }
            }
            return true;
        } else if (currentX != targetX && currentY != targetY) {
            return false;
        } else if (targetX > targetY) {
            int x = currentX + 1;
            while (x < targetX) {
                if (board[currentY][x] != null){
                    return false;
                }
                x++;
            }

        } else if (targetY > currentY) {
            int y = currentY + 1;
            while(y < targetY){
                if(board[y][currentX] != null){
                    return false;
                }
            }
        } else if (currentX > targetX) {
            int x = currentX - 1;
            while (x > targetX) {
                if (board[currentY][x] != null){
                    return false;
                }
                x--;
            }

        } else if (currentY > targetY) {
            int y = currentY - 1;
            while (y > targetY) {
                if (board[y][currentX] != null){
                    return false;
                }
                y--;
            }
        }
        return true;
    }

}


