package com.lld.chess.gameplay.contracts;

import com.lld.chess.model.Cell;
import com.lld.chess.model.Piece;

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
