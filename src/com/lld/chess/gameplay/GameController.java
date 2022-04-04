package com.lld.chess.gameplay;

import com.lld.chess.gameplay.contracts.PlayerMove;
import com.lld.chess.model.Board;
import com.lld.chess.model.Player;

import java.util.List;

public class GameController {

    public static void gamePlay(List<Player> players, Board board){

        int currentPlayer = 0;
        while (true) {
            Player player = players.get(currentPlayer);
            PlayerMove playerMove = player.makeMove();
        //    playerMove.getPiece().move(player,playerMove.getToCell(),board,defaultAdditionalBlockers());
       //     currentPlayer = (currentPlayer + 1) % players.size();
        }

    }
}
