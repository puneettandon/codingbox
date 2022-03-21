package com.systemdesign.chess.condition;

public class PieceCellOccupyBlockerFactory {

    public static PieceCellOccupyBlocker defaultBaseBlocker(){
        return new PieceCellOccupyBlockerSelfPiece();
    }
}
