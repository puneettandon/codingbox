package com.lld.chess.moves;

import com.lld.chess.condition.MoveBaseCondition;
import com.lld.chess.condition.PieceCellOccupyBlocker;
import com.lld.chess.condition.PieceMoveFurtherCondition;

public class PossibleMovesProviderVertical extends  PossibleMovesProvider{

    private  VerticalMoveDirection verticalMoveDirection;

    public PossibleMovesProviderVertical(int maxSteps, MoveBaseCondition baseCondition,
                                         PieceMoveFurtherCondition moveFurtherCondition, PieceCellOccupyBlocker baseBlocker,
                                         VerticalMoveDirection verticalMoveDirection){
        super(maxSteps,baseCondition,moveFurtherCondition,baseBlocker);
        this.verticalMoveDirection = verticalMoveDirection;
    }
}
