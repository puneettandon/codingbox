package com.lld.chess.condition;

import com.lld.chess.model.Piece;

public class MoveBaseConditionFirstMove implements MoveBaseCondition{

    @Override
    public boolean isBaseConditionFullfilled(Piece piece) {
        return piece.getNumMoves() == 0;
    }
}
