import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
       
Integer[] rotorChoices = {1, 2, 3, 4, 5};

innerCombo  = new JComboBox<>(rotorChoices);
middleCombo = new JComboBox<>(rotorChoices);
outerCombo  = new JComboBox<>(rotorChoices);

initialPositionsField = new JTextField("", 3);

encryptButton = new JButton("Encrypt");
decryptButton = new JButton("Decrypt");

inputArea = new JTextArea(4, 40);
outputArea = new JTextArea(4, 40);
outputArea.setEditable(false);


//top part
JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

topPanel.add(new JLabel("Inner"));
topPanel.add(innerCombo);

topPanel.add(new JLabel("Middle"));
topPanel.add(middleCombo);

topPanel.add(new JLabel("Out"));
topPanel.add(outerCombo);

topPanel.add(new JLabel("Initial Positions"));
topPanel.add(initialPositionsField);

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




    }
}


}
