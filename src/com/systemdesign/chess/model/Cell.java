package com.systemdesign.chess.model;

public class Cell {

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private Piece currentPiece;

    public boolean isFree(){
        return  currentPiece == null;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }
}
