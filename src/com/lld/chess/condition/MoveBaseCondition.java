package com.lld.chess.condition;

import com.lld.chess.model.Piece;

public interface MoveBaseCondition {

    boolean isBaseConditionFullfilled(Piece piece);
}
