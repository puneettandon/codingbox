package com.lld.chess.condition;

import com.lld.chess.model.Board;
import com.lld.chess.model.Cell;
import com.lld.chess.model.Piece;
import com.lld.chess.model.Player;

public class PieceCellOccupyBlockerSelfPiece implements PieceCellOccupyBlocker {

    @Override
    public boolean isCellNonOccupiableForPiece(Cell cell, Piece piece, Board board, Player player) {
        if(cell.isFree()){
            return false;
        }
        return cell.getCurrentPiece().getColor() == piece.getColor();
    }
}
