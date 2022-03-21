package com.systemdesign.chess.condition;

import com.systemdesign.chess.model.Piece;

public class NoMoveBaseCondition implements  MoveBaseCondition {
    @Override
    public boolean isBaseConditionFullfilled(Piece piece) {
        return false;
    }
}
