package game.gameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.*;
import java.util.List;

/**
 * This class acts as the GUI view for the simulation and will be the page that updates and shows the
 * different generations on the screen
 */

public class SimulationGUIView extends JFrame implements ActionListener {

    private final int SCREEN_H = 1500;
    private final int SCREEN_W = 1500;
    private int rows;
    private int cols;

    private SimulationGUIController controller;

    private final JPanel topPanel;
    private final JLabel generationCount;
    private final JButton startBtn;

    private List<JTextArea> cellList;
    private List<JPanel> panelList = new ArrayList<>();

    private Timer timer;
    private int delay = 15;
    private boolean play = false;


    public SimulationGUIView(int row, int col){
        super("Simulation");

        rows = row;
        cols = col;

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2, 0, 5));
        topPanel.setSize(100,100);
        topPanel.setAlignmentY(SwingConstants.TOP);

        this.generationCount = new JLabel();
        this.generationCount.setText("Initial Generation Seeding ");
        generationCount.setHorizontalAlignment(SwingConstants.LEFT);

        startBtn = new JButton("Start");
        startBtn.setHorizontalAlignment(SwingConstants.CENTER);
        startBtn.addActionListener(this);

        topPanel.add(generationCount);
        topPanel.add(startBtn);
        this.add(topPanel);

        // create the cells
        cellList = new ArrayList<>();
        for(int i = 0; i < rows * cols; i++){
            JTextArea tmp = new JTextArea();
            tmp.setBackground(Color.white);
            tmp.setForeground(Color.white);
            tmp.setOpaque(true);
            tmp.setPreferredSize(new Dimension(1, 1));
            tmp.setMinimumSize(new Dimension(1, 1));
            tmp.setMaximumSize(new Dimension(1, 1));
            tmp.setEditable(false);

            cellList.add(tmp);
        }

        this.setLayout(new GridLayout(rows + 2, 1));
        this.setSize(SCREEN_W, SCREEN_H);

        JPanel tmpPanel = new JPanel(new GridLayout(1,1, 5, 5));
        this.add(tmpPanel);

        // add a row of cells to a panel
        for(int i = 0; i < rows; i++){
            JPanel cellPanel = new JPanel(new GridLayout(1, cols));
            for(int j = 0; j < cols; j++){
                int index = (i * cols) + j;
                cellPanel.add(cellList.get(index));
            }
            panelList.add(cellPanel);
            this.add(cellPanel);
        }

        // start the timer
        timer = new Timer(delay, this);
        timer.start();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent event){

        Object src = event.getSource();

        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        // user presses start button, start running the simulation
        if(!play) {
            if (src.equals(startBtn)) {
                startBtn.setText("Stop");
                play = true;
            }
        }
        else {
            // the start button will also be used to pause the simulation
            if(src.equals(startBtn)){
                startBtn.setText("Start");
                play = false;
            }
            // simulation continues running
            else {
                //timer.start();
                controller.runSingleIteration();
            }
        }
        this.setCursor(Cursor.getDefaultCursor());
    }

    /**
     * this method adds a controller to handle the information
     */

    public void setController(SimulationGUIController c){
        controller = c;
    }


    /**
     * this method will update the generation count and the GUI display of the board for the
     * current generation
     */

    public void updateBoard(IBoard board, int count){

        int index;
        JPanel tmpPanel;

        if(count > 0) {
            generationCount.setText("Generation: " + count);
        }

        // iterate through the list of panels, look at each cell's current state and update accordingly
        for(int i = 0; i < board.getRow(); i++){
            tmpPanel = panelList.get(i);
            for(int j = 0; j < board.getCol(); j++){
                CellModel tmp = board.getCell(i, j);
                int r = tmp.getRowPos();
                int c = tmp.getColPos();
                index = (r * cols) + c;

                JTextArea cell = cellList.get(index);
                // alive cell
                if(tmp.getState()){
                    cell.setBackground(Color.black);
                    cell.setForeground(Color.black);
                }
                // dead cell
                else {
                    cell.setBackground(Color.white);
                    cell.setForeground(Color.white);
                }
            }

            tmpPanel.repaint();
        }

    }


}
