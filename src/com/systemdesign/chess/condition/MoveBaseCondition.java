package com.systemdesign.chess.condition;

import com.systemdesign.chess.model.Piece;

public interface MoveBaseCondition {

    boolean isBaseConditionFullfilled(Piece piece);
}
