package com.systemdesign.chess.condition;

import com.systemdesign.chess.model.Board;
import com.systemdesign.chess.model.Cell;
import com.systemdesign.chess.model.Piece;
import com.systemdesign.chess.model.Player;

public interface PieceCellOccupyBlocker {

    boolean isCellNonOccupiableForPiece(Cell cell, Piece piece, Board board, Player player);
}
