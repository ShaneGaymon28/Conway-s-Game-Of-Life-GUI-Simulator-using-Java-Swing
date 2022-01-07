package game.gameOfLife;

/**
 * This class acts as the controller for the SimulationGUIView class and handles all logic for
 * the simulation
 */

public class SimulationGUIController {

    private SimulationGUIView view;
    private IBoard cellBoard;

    private int maxRow;
    private int maxCol;
    private int numGenerations;

    public SimulationGUIController(IBoard b, SimulationGUIView v) {
        this.cellBoard = b;
        this.view = v;

        maxRow = cellBoard.getRow();
        maxCol = cellBoard.getCol();

        numGenerations = 0;

        view.updateBoard(cellBoard, 0);
    }

    /**
     * this method runs a single generation from the current state of the cell board
     * and updates both the model and view for the next generation
     */

    public void runSingleIteration() {
        CellModel future[][];
        future = new CellModel[maxRow][maxCol];

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {

                CellModel cur = cellBoard.getCell(i, j);
                cur.setNeighbors(cellBoard.getNeighborsFromCell(cur));

                //the next state the cell will be in
                boolean futureState = cellBoard.handleCell(cur);

                CellModel updatedCell = new CellModel(i, j, futureState);
                future[i][j] = updatedCell;

            }
        }

        cellBoard.update(future);
        numGenerations++;
        view.updateBoard(cellBoard, numGenerations);

    }

}

