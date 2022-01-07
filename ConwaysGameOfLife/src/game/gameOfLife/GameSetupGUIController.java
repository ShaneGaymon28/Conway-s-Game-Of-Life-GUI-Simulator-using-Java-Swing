package game.gameOfLife;

/**
 * This class acts as the controller for the GameSetupGUIView class
 */

public class GameSetupGUIController {

    private GameSetupGUIView view;
    private RulesGUIView rView;
    private sgGUIView gView;
    private SimulationGUIView sView;
    private SimulationGUIController cont;


    public GameSetupGUIController(GameSetupGUIView v){
        view = v;
    }

    /**
     * this method creates an IBoard object and starts the simulation
     */

    public void startSimulation(int row, int col){

        // start the simulation
        IBoard cellBoard = new Board(0.2, row, col);
        sView = new SimulationGUIView(row, col);
        cont = new SimulationGUIController(cellBoard, sView);

        sView.setController(cont);

    }

    /**
     * creates a view to represent the rules page
     */

    public void openRulesPage(){

        rView = new RulesGUIView();
        rView.setController(this);
    }

    /**
     * closes the rules page
     */

    public void closeRulesPage(){
        rView.closeScreen();
    }

    /**
     * creates a view to represent the creator info page
     */

    public void openSGPage(){
        gView = new sgGUIView();
        gView.setController(this);
    }

    /**
     * closes the creator info page
     */

    public void closeSGPage(){
        gView.closeScreen();
    }




}
