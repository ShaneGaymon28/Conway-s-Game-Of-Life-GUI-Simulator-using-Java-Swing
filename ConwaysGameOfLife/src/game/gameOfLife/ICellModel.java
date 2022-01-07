package game.gameOfLife;

import java.util.*;

public interface ICellModel {

    /**
     * returns the list of neighbors for a single cell (neighbors are the 8 cells directly adjacent, diagonal as well,
     * to the current cell
     */

    List<CellModel> getNeighbors();

    /**
     * sets the list of neighbors for the cell
     */

    void setNeighbors(List<CellModel> n);

    /**
     * returns the state of the cell
     */

    boolean getState();

    /**
     * returns the row index that the cell is stored
     */

    int getRowPos();

    /**
     * returns the column index that the cell is stored
     */

    int getColPos();

}
