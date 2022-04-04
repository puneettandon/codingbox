Problem Statement: Chess Low Level Design

We have to design a simple chess game.


Entities

    Board : Board is the one entity that represents an actual board on which you play this game.
    Cell: A Board consists of grid of cells.
    Player: Someone who is actually playing right.
    Piece: There are various types of pieces

Pieces and their moves:
    
    King: Key entity in chess.If your king is killed then you lose.Its also called checkmate.
    Queen: It can move any number of steps in a single move and in any direction.
    Rook: It moves only in horizontal and vertical direction but 
          can move any number of steps in single move
    Bishop: It only moves in diagonal direction but can move any number of steps in single move.
    Knight: It makes L shaped moves.
    Pawn: It can move 1 step forward vertically.If it is its first turn , then it can also 
          choose to make 2 steps in single move.
    Note: All pieces except knight cannot jump any other piece.Knight can jump over the pieces.



    