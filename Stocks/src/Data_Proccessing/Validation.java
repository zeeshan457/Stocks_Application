package Data_Proccessing;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author zeeshan
 */
public class Validation {

    /**
     *
     * @param j
     * @return
     */
    public Boolean ValidateComboBox(JComboBox j) {

        if (j.equals("Select Stock") || j.equals("Select Crypto")) {
            JOptionPane.showMessageDialog(null,
                    "Please Select an Option", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;

    }

}
