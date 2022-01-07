package game.gameOfLife;

import java.util.*;

/**
 * This class will act as a model for cells being created
 */

public class CellModel implements ICellModel {

    // list of neighboring cells
    private List<CellModel> neighbors;

    // state of the cell
    private boolean isAlive;

    // row and column position in board
    private int rowPos;
    private int colPos;

    /**
     * creates a Cell Model
     * @param state - state of the cell, false = dead, true = alive
     */

    public CellModel(int row, int col, boolean state){
        rowPos = row;
        colPos = col;
        isAlive = state;

    }

    public void setNeighbors(List<CellModel> n){
        neighbors = n;
    }

    public List<CellModel> getNeighbors(){
        return neighbors;
    }

    public int getRowPos(){
        return rowPos;
    }

    public int getColPos(){
        return colPos;
    }

    public boolean getState(){
        return isAlive;
    }
}
