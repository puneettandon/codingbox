package com.systemdesign.chess.moves;

import com.systemdesign.chess.model.Cell;

public interface NextCellProvider {

    Cell nextCell(Cell cell);
}
