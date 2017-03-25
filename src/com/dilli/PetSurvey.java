package com.dilli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by dilli on 3/22/2017.
 */
public class PetSurvey extends JFrame{
    private JPanel rootPanel;
    private JCheckBox dogCheckbox;
    private JCheckBox fishCheckBox;
    private JCheckBox catCheckBox;
    private JButton quitButton;
    private JLabel resultsLabel;

    private boolean dog;
    private boolean cat;
    private boolean fish;

    protected PetSurvey(){
        setContentPane(rootPanel);//Set the contents of the Window to be the rootPane JPanel
        pack(); //Add the components to the window
        setSize(new Dimension(400,350)); //Set size - user will be able to resize
        setTitle("Pet Survey");  //Set the text in the title bar
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Close the program when you close this window.
        setVisible(true);

        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isSelected();
                updateResults();
            }
        });
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cat = catCheckBox.isSelected();
                updateResults();
            }
        });
        dogCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckbox.isSelected();
                updateResults();
            }
        });
        quitButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this,"Are you sure you want to quit?",
                        "Quit",JOptionPane.OK_CANCEL_OPTION);
                if(quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
    }

    private void updateResults() {
        String hasDog = dog ? "one dog" : "no dogs";
        String hasCat = cat ? "one cat" : "no cats";
        String hasFish = fish ? "one fish" : "no fish";

        String results = "You have " + hasDog + " and " + hasCat + " and " + hasFish;
        resultsLabel.setText(results);
    }
}
