package game.gameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class acts as the GUI view for the rules page
 */

public class RulesGUIView extends JFrame implements ActionListener {

    private JLabel topLabel;

    private JButton backBtn;

    private JPanel rulesPanel;
    private JPanel contentPanel;

    private GameSetupGUIController controller;


    public RulesGUIView(){
        super("Rules for Conway's Game of Life");

        contentPanel = new JPanel();
        contentPanel.setAlignmentY(SwingConstants.TOP);

        backBtn = new JButton("Back");
        backBtn.setSize(new Dimension(150,100));
        backBtn.addActionListener(this);

        contentPanel.add(backBtn);
        this.add(contentPanel);


        rulesPanel = new JPanel();
        rulesPanel.setLayout(new GridLayout(5, 1));

        topLabel = new JLabel("Rules:");

        JLabel ruleOne = new JLabel("\t\t1. Any live cell with fewer than two live neighbors dies, as if by underpopulation ");
        JLabel ruleTwo = new JLabel("\t\t2. Any live cell with two or three live neighbors lives on to the next generation");
        JLabel ruleThree = new JLabel("\t\t3. Any live cell with more than three live neighbors, as if by overpopulation");
        JLabel ruleFour = new JLabel("\t\t4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction");

        rulesPanel.add(topLabel);
        rulesPanel.add(ruleOne);
        rulesPanel.add(ruleTwo);
        rulesPanel.add(ruleThree);
        rulesPanel.add(ruleFour);

        this.setLayout(new GridLayout(3, 1));
        this.setSize(700, 500);

        this.add(rulesPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent event){

        Object src = event.getSource();

        if(src.equals(backBtn)){
            controller.closeRulesPage();
        }

    }

    public void setController(GameSetupGUIController c){
        controller = c;
    }

    public void closeScreen(){
        this.dispose();
    }


}
