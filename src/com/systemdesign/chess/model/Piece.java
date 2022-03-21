package com.systemdesign.chess.model;

import com.systemdesign.chess.moves.PossibleMovesProvider;

import java.util.List;

public class Piece {

    private  boolean isKilled = false;
    private final Color color;
    private  final List<PossibleMovesProvider> movesProviders;
    private Integer numMoves;
    PieceType pieceType;

    private Cell currentCell;

    public Piece(Color color, List<PossibleMovesProvider> movesProviders, PieceType pieceType) {
        this.color = color;
        this.movesProviders = movesProviders;
        this.pieceType = pieceType;
    }

    public void killIt(){
        this.isKilled = true;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public Color getColor() {
        return color;
    }

    public List<PossibleMovesProvider> getMovesProviders() {
        return movesProviders;
    }

    public Integer getNumMoves() {
        return numMoves;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }
}
