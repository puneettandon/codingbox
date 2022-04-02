package com.systemdesign.chess.test.helpers;

import com.google.common.collect.ImmutableList;
import com.systemdesign.chess.condition.*;
import com.systemdesign.chess.model.*;
import com.systemdesign.chess.moves.PossibleMovesProvider;
import com.systemdesign.chess.moves.PossibleMovesProviderVertical;
import com.systemdesign.chess.moves.VerticalMoveDirection;

import java.util.ArrayList;
import java.util.List;

public class TestHelpers {

    public static Board createBoard() {

        Cell[][] cells = new Cell[8][8];
        for(int i=0;i<8;i++){
            for(int j = 0;j<8;j++) {
                cells[i][j]  = new Cell(i,j);
            }
        }
        return new Board(8,cells);
     }

    public static List<Piece> piecesSet(Color color, Board board, int mainPiecesRowNum, int pawnPiecesRowNum, VerticalMoveDirection pawnDirection) {
        List<Piece> allPieces = new ArrayList<>();
        for(int i = 0;i< 8;i++ ){
            Piece pawn = pawn(color,pawnDirection);
            addPieceToBoard(board,pawn,pawnPiecesRowNum,i);
            allPieces.add(pawn);
        }

       // Piece king = king(color);
        return null;

    }

    private static void addPieceToBoard(Board board, Piece piece, int rowNum, int colNum) {
        Cell cell = board.getCellAtLocation(rowNum,colNum);
        piece.setCurrentCell(cell);
        cell.setCurrentPiece(piece);
    }

    public  static Piece pawn(Color color,VerticalMoveDirection pawnDirection){
        ImmutableList<PossibleMovesProvider> pawnMoveProviders = ImmutableList.of(
                new PossibleMovesProviderVertical(1,new NoMoveBaseCondition(),defaultMoveFurtherCondition(),defaultBaseBlocker(),pawnDirection),
                new PossibleMovesProviderVertical(2,new MoveBaseConditionFirstMove(),defaultMoveFurtherCondition(),defaultBaseBlocker(),pawnDirection)
        );
        return new Piece(color,pawnMoveProviders, PieceType.PAWN);
    }

    private static PieceCellOccupyBlocker defaultBaseBlocker() {
        return  new PieceCellOccupyBlockerFactory().defaultBaseBlocker();
    }

    private static PieceMoveFurtherCondition defaultMoveFurtherCondition() {
        return new PieceMoveFurtherConditionDefault();
    }
}
