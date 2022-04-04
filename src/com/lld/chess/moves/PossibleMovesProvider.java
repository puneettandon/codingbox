package com.lld.chess.moves;

import com.lld.chess.condition.MoveBaseCondition;
import com.lld.chess.condition.PieceCellOccupyBlocker;
import com.lld.chess.condition.PieceMoveFurtherCondition;

public abstract class PossibleMovesProvider {

    int maxSteps;

    MoveBaseCondition baseCondition;
    PieceMoveFurtherCondition moveFurtherCondition;
    PieceCellOccupyBlocker baseBlocker;

    public PossibleMovesProvider(int maxSteps, MoveBaseCondition baseCondition, PieceMoveFurtherCondition moveFurtherCondition, PieceCellOccupyBlocker baseBlocker) {
        this.maxSteps = maxSteps;
        this.baseCondition = baseCondition;
        this.moveFurtherCondition = moveFurtherCondition;
        this.baseBlocker = baseBlocker;
    }


}
