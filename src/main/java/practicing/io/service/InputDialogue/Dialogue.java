package practicing.io.service.InputDialogue;

import javax.swing.*;

public class Dialogue {
    public static String readFileNameFromInput(){
        return JOptionPane.showInputDialog( "Enter file name" );
    }
}
