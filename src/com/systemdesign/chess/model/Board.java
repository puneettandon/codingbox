package com.systemdesign.chess.model;


public class Board {

    int boardSize;
    Cell[][] cells;

    public Board(int boardSize,Cell[][] cells){
        this.boardSize = boardSize;
        this.cells = cells;
    }


    public Cell getCellAtLocation(int x, int y) {
        if(x >= boardSize || x < 0){
            return  null;
        }
        if(y >= boardSize || y < 0){
            return  null;
        }
        return cells[x][y];
    }
}
