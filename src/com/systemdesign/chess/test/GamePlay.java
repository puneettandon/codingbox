package com.systemdesign.chess.test;

import com.systemdesign.chess.model.Board;
import com.systemdesign.chess.model.Piece;
import com.systemdesign.chess.test.helpers.TestHelpers;

import java.util.List;

import static com.systemdesign.chess.model.Color.WHITE;
import static com.systemdesign.chess.moves.VerticalMoveDirection.UP;

public class GamePlay {

    void testSampleGamePlay(){
        Board board = TestHelpers.createBoard();
        List<Piece> whitePieces = TestHelpers.piecesSet(WHITE,board,0,1,UP);

    }
}
