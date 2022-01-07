package game.gameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class acts as the GUI view for the Creator Info page, which has information about myself
 */

public class sgGUIView extends JFrame implements ActionListener {

    private JPanel infoPanel;
    private JPanel backPanel;

    private JLabel lbl;

    private JButton backBtn;

    private GameSetupGUIController controller;

    public sgGUIView(){
        super("Creator Info");

        backPanel = new JPanel();
        backBtn = new JButton("Back");
        backBtn.setHorizontalAlignment(SwingConstants.CENTER);
        backBtn.setSize(150, 100);
        backBtn.addActionListener(this);
        backPanel.add(backBtn);

        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1));

        lbl = new JLabel("This project was created by Shane Gaymon (Clemson University Computer Science '23)");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel email = new JLabel("Email: gaymons@gmail.com");
        email.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel github = new JLabel("Github: ShaneGaymon28");
        github.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel info = new JLabel("You can use this project however you want, just give me credit!");
        info.setHorizontalAlignment(SwingConstants.CENTER);

        infoPanel.add(email);
        infoPanel.add(github);
        infoPanel.add(info);

        this.setSize(700,500);
        this.setLayout(new GridLayout(3, 1));

        this.add(backPanel);
        this.add(infoPanel);
        this.add(lbl);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent event){
        Object src = event.getSource();

        if(src.equals(backBtn)){
            controller.closeSGPage();
        }
    }

    public void setController(GameSetupGUIController c){
        controller = c;
    }

    public void closeScreen(){
        this.dispose();
    }

}
