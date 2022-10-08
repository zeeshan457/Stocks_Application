package Data_Proccessing;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zeeshan
 */
public class Validation {

    /**
     *
     * @param options
     * @return true or false
     */
    public Boolean ValidateComboBox(JComboBox options) {

        String S_options = options.getSelectedItem().toString();

        if (S_options.equals("Select Stock") || S_options.equals("Select Crypto")) {
            JOptionPane.showMessageDialog(null,
                    "Please Select an Option", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;

    }

    /**
     *
     * @param table
     */
    public void Clear(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

    }

}
