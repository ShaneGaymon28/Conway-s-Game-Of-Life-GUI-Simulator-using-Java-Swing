package game.gameOfLife;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.util.List;

/**
 * This class acts as the view for setting up the game
 */

public class GameSetupGUIView extends JFrame implements ActionListener {

    private GameSetupGUIController controller;

    private JLabel welcomeLabel;
    private JLabel overviewTxt;
    private JLabel outBoundsTxt;
    private JLabel pickSize;
    private JLabel boardSizeLbl;

    private JPanel topPanel;
    private JPanel overviewPanel;
    private JPanel sizePanel;
    private JPanel startPanel;

    private JButton startButton;
    private JButton rulesBtn;
    private JButton licensesBtn;
    private List<JButton> buttons;

    private JComboBox sizeCB;
    private String [] sizeOptions = {"5", "10", "25", "50", "100"};


    public GameSetupGUIView(){
        super("Gaymon's (Conway's) Game of Life");

        buttons = new ArrayList<>();

        welcomeLabel = new JLabel("Welcome to my Conway's Game of Life Simulator!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // rules and creator info buttons
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        rulesBtn = new JButton("Rules");
        rulesBtn.addActionListener(this);
        licensesBtn = new JButton("SG");
        licensesBtn.addActionListener(this);

        buttons.add(rulesBtn);
        buttons.add(licensesBtn);
        topPanel.add(rulesBtn);
        topPanel.add(licensesBtn);


        //panel with text info
        overviewPanel = new JPanel();
        overviewPanel.setLayout(new GridLayout(5,1));
        overviewTxt = new JLabel("\tEach position in the board represents a cell (each cell will either be alive as a black colored cell or dead as a white colored cell)");
        outBoundsTxt = new JLabel("\tPlease note, cells outside of the board will not be shown (for obvious reasons)");
        pickSize = new JLabel("\tPick a board size in the dropdown below, note the integer selected will represent the number of rows and columns");
        overviewPanel.add(overviewTxt);
        overviewPanel.add(outBoundsTxt);
        overviewPanel.add(pickSize);

        // panel to pick size
        sizePanel = new JPanel();
        sizePanel.setLayout(new GridLayout(2,1));
        boardSizeLbl = new JLabel("Board Size: ");
        boardSizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        sizeCB = new JComboBox(sizeOptions);
        sizeCB.setSize(200,100);
        sizePanel.add(boardSizeLbl);
        sizePanel.add(sizeCB);

        //start button
        startPanel = new JPanel();
        startButton = new JButton("Start Simulation");
        startButton.addActionListener(this);
        buttons.add(startButton);
        startPanel.add(startButton);


        this.setLayout(new GridLayout(5, 1));
        this.setSize(700,800);

        this.add(welcomeLabel);
        this.add(topPanel);
        this.add(overviewPanel);
        this.add(sizePanel);
        this.add(startPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void setController(GameSetupGUIController c){
        controller = c;
    }


    @Override
    public void actionPerformed(ActionEvent event){

        Object src = event.getSource();

        if(src.equals(startButton)){
            String errorMsg = "";
            int s = 0;

            try {
                s = Integer.parseInt(sizeCB.getSelectedItem().toString());
            } catch (NumberFormatException e){
                errorMsg += "Try again!";
            }

            if(errorMsg.equals("")){
                controller.startSimulation(s, s);
            }
            else {
                welcomeLabel.setText(errorMsg);
            }

        }
        else if(src.equals(rulesBtn)){
            controller.openRulesPage();
        }
        else if(src.equals(licensesBtn)){
            controller.openSGPage();
        }
    }

    public void closeScreen(){
        this.dispose();
    }

}
