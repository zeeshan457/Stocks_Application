package API;

import java.math.BigDecimal;
import javax.swing.JComboBox;
import javax.swing.JTable;
import yahoofinance.Stock;

// importing packages to process methods for API
import Data_Proccessing.*;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yahoofinance.YahooFinance;

/**
 *
 * @author zeeshan
 */
public class API_Connect {

    // attributes and class calls from validation package
    Stock stock;
    Validation validate = new Validation();

    /**
     *
     * 
     * 
     * 
     * @param options
     * @param table
     */
    public void GetStock(JComboBox options, JTable table) {

        String S_options = options.getSelectedItem().toString();

        // validating the JCombobox
        if (validate.ValidateComboBox(options)) {
            try {

                stock = YahooFinance.get(S_options);

                String name = stock.getName().toString();
                String currency = stock.getCurrency();
                String price = stock.getQuote().getPrice().toString();
                String exchange = stock.getStockExchange().toString();
                String volume = stock.getQuote().getAvgVolume().toString();
                String marketcap = stock.getStats().getMarketCap().toString();
                String change = stock.getQuote().getChangeInPercent().toString();
                String dividend = stock.getDividend().getAnnualYieldPercent().toString();

                String tbData[] = {name, currency, exchange, price, change, volume, marketcap, dividend};
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // Adding data to the model
                model.addRow(tbData);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "API error the stock doesn't exist or check your connection", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public void GetCrypto(JComboBox options) {

    }
}
