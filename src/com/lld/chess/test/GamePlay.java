package com.lld.chess.test;

import com.lld.chess.model.Board;
import com.lld.chess.model.Piece;
import com.lld.chess.test.helpers.TestHelpers;

import java.util.List;

import static com.lld.chess.model.Color.WHITE;
import static com.lld.chess.moves.VerticalMoveDirection.UP;

public class GamePlay {

    void testSampleGamePlay(){
        Board board = TestHelpers.createBoard();
        List<Piece> whitePieces = TestHelpers.piecesSet(WHITE,board,0,1,UP);

    }
}
