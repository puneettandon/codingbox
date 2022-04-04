package com.lld.chess.moves;

import com.lld.chess.model.Cell;

public interface NextCellProvider {

    Cell nextCell(Cell cell);
}
