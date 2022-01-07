package game.gameOfLife;

import java.util.*;


public interface IBoard {


    /**
     * gets a list of the neighbors around the cell at the specified index
     *
     * @return - List<CellModel>
     */

    List<CellModel> getNeighborsFromCell(CellModel curCell);

    /**
     * gets the CellModel stored at the row, col position in the cellBoard
     *
     * @return - CellModel[row][col]
     */

    CellModel getCell(int row, int col);

    /**
     * determines the cell's next state from its current state of neighbors
     */

    boolean handleCell(CellModel cur);

    /**
     * checks to see if a cell's neighbor is out of bounds
     */

    boolean checkNeighbor(int row, int col);

    /**
     * updates the current state of the cell board to the newly calculated state
     * of the board
     */

    void update(CellModel newBoard[][]);

    /**
     * gets the number of rows in the board
     */

    int getRow();

    /**
     * gets the number of column in the board
     */

    int getCol();

}
