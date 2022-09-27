package API;

import java.math.BigDecimal;
import javax.swing.JComboBox;
import javax.swing.JTable;
import yahoofinance.Stock;

// importing packages to process methods for API
import Data_Proccessing.*;

/**
 *
 * @author zeeshan
 */
public class API_Connect {

    // attributes
    Stock stock;
    Validation validate = new Validation();

    public void GetStock(JComboBox options) {

        if (validate.ValidateComboBox(options)) {
            stock = new Stock(options.getSelectedItem().toString());

            String currency = stock.getCurrency();
            String price = stock.getQuote().getPrice().toString();
            String change = stock.getQuote().getChangeInPercent().toString();
            String peg = stock.getStats().getPeg().toString();
            String dividend = stock.getDividend().getAnnualYieldPercent().toString();

            JTable table = new JTable();

        }
    }

    public void GetCrypto(JComboBox options) {

    }
}
