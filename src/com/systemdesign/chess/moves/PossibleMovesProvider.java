package com.systemdesign.chess.moves;

import com.systemdesign.chess.condition.MoveBaseCondition;
import com.systemdesign.chess.condition.PieceCellOccupyBlocker;
import com.systemdesign.chess.condition.PieceMoveFurtherCondition;

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
