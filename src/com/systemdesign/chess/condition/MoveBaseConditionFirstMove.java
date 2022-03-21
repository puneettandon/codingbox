package com.systemdesign.chess.condition;

import com.systemdesign.chess.model.Piece;

public class MoveBaseConditionFirstMove implements MoveBaseCondition{

    @Override
    public boolean isBaseConditionFullfilled(Piece piece) {
        return piece.getNumMoves() == 0;
    }
}
