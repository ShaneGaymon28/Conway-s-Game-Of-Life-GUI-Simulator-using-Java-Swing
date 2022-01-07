package game.gameOfLife;

public class ConwaysGameOfLifeGUI {
    public static void main(String []args){
        GameSetupGUIView view = new GameSetupGUIView();
        GameSetupGUIController controller = new GameSetupGUIController(view);
        view.setController(controller);

    }
}
