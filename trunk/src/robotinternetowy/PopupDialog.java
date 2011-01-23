/*
 * Klasa tworzaca obiekt okienka alertu
 */
package robotinternetowy;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author yarpo
 */
public class PopupDialog
{
    public void createPopupDialog (String message)
    {
        JOptionPane pane = new JOptionPane(message);
        JDialog dialog = pane.createDialog(new JFrame(), "Dialog");
        dialog.setVisible(true);
    }
}
