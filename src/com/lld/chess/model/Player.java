package com.lld.chess.model;

import com.lld.chess.exception.PieceNotFoundException;
import com.lld.chess.gameplay.contracts.PlayerMove;

import java.util.List;

public abstract class Player {

    List<Piece> pieces;

    public Player(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(PieceType pieceType){
        for(Piece piece : getPieces()){
            if(piece.getPieceType() == pieceType){
                return piece;
            }
        }
        throw  new PieceNotFoundException();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public abstract PlayerMove makeMove();
}
