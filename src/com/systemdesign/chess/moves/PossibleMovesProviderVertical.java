package com.systemdesign.chess.moves;

import com.systemdesign.chess.condition.MoveBaseCondition;
import com.systemdesign.chess.condition.PieceCellOccupyBlocker;
import com.systemdesign.chess.condition.PieceMoveFurtherCondition;

public class PossibleMovesProviderVertical extends  PossibleMovesProvider{

    private  VerticalMoveDirection verticalMoveDirection;

    public PossibleMovesProviderVertical(int maxSteps, MoveBaseCondition baseCondition,
                                         PieceMoveFurtherCondition moveFurtherCondition, PieceCellOccupyBlocker baseBlocker,
                                         VerticalMoveDirection verticalMoveDirection){
        super(maxSteps,baseCondition,moveFurtherCondition,baseBlocker);
        this.verticalMoveDirection = verticalMoveDirection;
    }
}
