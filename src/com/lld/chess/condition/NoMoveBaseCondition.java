package com.lld.chess.condition;

import com.lld.chess.model.Piece;

public class NoMoveBaseCondition implements  MoveBaseCondition {
    @Override
    public boolean isBaseConditionFullfilled(Piece piece) {
        return false;
    }
}
