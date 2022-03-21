package com.systemdesign.chess.gameplay.contracts;

import com.systemdesign.chess.model.Cell;
import com.systemdesign.chess.model.Piece;

public class PlayerMove {

    Piece piece;
    Cell toCell;

    public Piece getPiece() {
        return piece;
    }

    public Cell getToCell() {
        return toCell;
    }
}
