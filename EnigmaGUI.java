import javax.swing.*;
import java.awt.*;
public class EnigmaGUI {
  public static void main(String[] args) {
        EnigmaFrame frame = new EnigmaFrame();
        frame.setTitle("Enigma GUI");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end program when you click x
        frame.setVisible(true);
    }  
}
