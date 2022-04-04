package com.lld.chess.condition;

import com.lld.chess.model.Board;
import com.lld.chess.model.Cell;
import com.lld.chess.model.Piece;

public class PieceMoveFurtherConditionDefault implements PieceMoveFurtherCondition {

    @Override
    public boolean canPieceMoveFurtherFromCell(Piece piece, Cell cell, Board board) {
        return  cell.isFree();
    }
}
