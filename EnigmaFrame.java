import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {

private JComboBox<Integer> innerRotor;
private JComboBox<Integer> middleRotor;
private JComboBox<Integer> outerRotor;

private JTextField initialStartingchars;

private JButton encryptButton;
private JButton decryptButton;

private JTextArea inputArea;
private JTextArea outputArea;


public EnigmaFrame() {
setTitle("Enigma GUI");  

Integer[] rotorChoices = {1, 2, 3, 4, 5};

innerRotor  = new JComboBox<>(rotorChoices);
middleRotor = new JComboBox<>(rotorChoices);
outerRotor  = new JComboBox<>(rotorChoices);

initialStartingchars = new JTextField("", 3);

encryptButton = new JButton("Encrypt");
decryptButton = new JButton("Decrypt");

inputArea = new JTextArea(4, 40);
outputArea = new JTextArea(4, 40);
outputArea.setEditable(false);


//top panel
JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

topPanel.add(new JLabel("Inner"));
topPanel.add(innerRotor);

topPanel.add(new JLabel("Middle"));
topPanel.add(middleRotor);

topPanel.add(new JLabel("Out"));
topPanel.add(outerRotor);

topPanel.add(new JLabel("Initial Positions"));
topPanel.add(initialStartingchars);

topPanel.add(encryptButton);
topPanel.add(decryptButton);

//input box 
JPanel inputPanel = new JPanel(new BorderLayout());
inputPanel.add(new JLabel("Input"), BorderLayout.NORTH);
inputPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);


//output box 
JPanel outputPanel = new JPanel(new BorderLayout());
outputPanel.add(new JLabel("Output"), BorderLayout.NORTH);
outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);


//putting everything together
setLayout(new BorderLayout());

add(topPanel, BorderLayout.NORTH); //top panel 
add(inputPanel, BorderLayout.CENTER); //input panel 
add(outputPanel, BorderLayout.SOUTH); //output panel 


//listners 
EnigmaActionListener a = new EnigmaActionListener();
encryptButton.addActionListener(a);
decryptButton.addActionListener(a);

pack();

    }

private class EnigmaActionListener implements ActionListener {
    
    public void actionPerformed(ActionEvent e) {
            // get rotor choices
            int inner  = (Integer) innerRotor.getSelectedItem();
            int middle = (Integer) middleRotor.getSelectedItem();
            int outer  = (Integer) outerRotor.getSelectedItem();

            // read inputted positions 
            String position = initialStartingchars.getText();
            if (position.length() != 3) {
            return;
            }

            // get input 
            String message = inputArea.getText();

            // encrypt or decrypt 
            String button = e.getActionCommand(); 
            String option;
            if (button.equals("Encrypt")) {
                option = "encrypt";
            } else {
                option = "decrypt";
            }

            // build args 
            String[] args = new String[6];
            args[0] = String.valueOf(inner);
            args[1] = String.valueOf(middle);
            args[2] = String.valueOf(outer);
            args[3] = position;
            args[4] = option;
            args[5] = message;

            // call enigma/Comms
            String result = Comms.run(args);

            // return output result
            outputArea.setText(result);



    }
}


}
