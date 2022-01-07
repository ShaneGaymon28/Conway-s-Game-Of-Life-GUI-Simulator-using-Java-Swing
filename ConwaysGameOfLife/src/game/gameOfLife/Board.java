package game.gameOfLife;

import java.util.ArrayList;
import java.util.List;

/**
 * This class acts as a model for the entire board of cells and determines the
 * next state for that cell
 */

public class Board extends AbsBoard implements IBoard{

    private CellModel cellBoard[][];

    private int rowSize;
    private int colSize;

    /**
     * initializes the board that will hold all cell positions
     */

    public Board(double prob, int row, int col){

        rowSize = row;
        colSize = col;

        cellBoard = new CellModel[rowSize][colSize];

        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                CellModel tmp;

                if(Math.random() <= prob) {
                    tmp = new CellModel(i, j, true);
                }
                else {
                    tmp = new CellModel(i, j, false);
                }

                cellBoard[i][j] = tmp;
            }
        }

    }


    public List<CellModel> getNeighborsFromCell(CellModel curCell) {

        int row = curCell.getRowPos();
        int col = curCell.getColPos();

        List<CellModel> n = new ArrayList<>();

        // right = i, j + 1
        // right down diagonal = i + 1, j + 1
        // down = i - 1, j
        // left down diagonal = i + 1, j - 1
        // left = i, j - 1
        // left up diagonal = i - 1, j - 1
        // up = i + 1, j
        // right up diagonal = i - 1, j + 1

        if(checkNeighbor(row, col + 1)) {
            n.add(cellBoard[row][col + 1]);
        }

        if(checkNeighbor(row + 1, col + 1)) {
            n.add(cellBoard[row + 1][col + 1]);
        }

        if(checkNeighbor(row + 1, col)) {
            n.add(cellBoard[row + 1][col]);
        }

        if(checkNeighbor(row + 1, col - 1)) {
            n.add(cellBoard[row + 1][col - 1]);
        }

        if(checkNeighbor(row, col - 1)) {
            n.add(cellBoard[row][col - 1]);
        }

        if(checkNeighbor(row - 1, col - 1)) {
            n.add(cellBoard[row - 1][col - 1]);
        }

        if(checkNeighbor(row - 1, col)) {
            n.add(cellBoard[row - 1][col]);
        }

        if(checkNeighbor(row - 1, col + 1)) {
            n.add(cellBoard[row - 1][col + 1]);
        }

        return n;
    }

    public CellModel getCell(int row, int col){
        return cellBoard[row][col];
    }

    public boolean checkNeighbor(int row, int col){

        if(row >= rowSize || row < 0){
            return false;
        }
        else if(col >= colSize || col < 0){
            return false;
        }

        return true;
    }

    public void update(CellModel newBoard[][]){
        cellBoard = newBoard;
    }

    public int getRow(){
        return rowSize;
    }

    public int getCol(){
        return colSize;
    }

    public boolean handleCell(CellModel cur){
        boolean curState = cur.getState();
        List<CellModel> curNeighbors = cur.getNeighbors();

        int aliveCellCount = 0;

        // loop through list of neighbors to determine current state
        for(int i = 0; i < curNeighbors.size(); i++){
            CellModel tmp = curNeighbors.get(i);

            if(tmp.getState()){
                aliveCellCount++;
            }

        }

        // cur cell is alive
        if(curState){
            // 1. any live cell with fewer than 2 live neighbors dies
            // 2. any live cell with more than 3 live neighbors dies
            if(aliveCellCount < 2 || aliveCellCount > 3){
                return false;
            }
            // any live cell with 2 or 3 live neighbors lives, unchanged
            else {
                return true;
            }
        }
        // cur cell is dead
        else {
            if(aliveCellCount == 3){
                return true;
            }
        }

        return false;
    }
}
