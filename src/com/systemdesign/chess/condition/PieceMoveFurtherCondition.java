package com.systemdesign.chess.condition;

import com.systemdesign.chess.model.Board;
import com.systemdesign.chess.model.Cell;
import com.systemdesign.chess.model.Piece;

public interface PieceMoveFurtherCondition {

    boolean canPieceMoveFurtherFromCell(Piece piece, Cell cell, Board board);
}
