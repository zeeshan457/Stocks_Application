
package Data_Proccessing;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author zeeshan
 */
public class Validation {

    public Boolean ValidateComboBox(JComboBox options) {

        if (options.equals("Select Stock") || options.equals("Select Crypto")) {
            JOptionPane.showMessageDialog(null,
                    "Please Select an Option", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;

    }
}
