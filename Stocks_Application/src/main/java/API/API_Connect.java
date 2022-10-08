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
    private Stock stock;
    private Stock crypto;
    private Validation validate = new Validation();

    /**
     *
     * This method allows a user to select a stock symbol and will process it
     * based on certain values, and then returns the values in a table.
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

    /**
     *
     * This method allows a user to select a crypto symbol and will process it
     * based on certain values, and then returns the values in a table.
     *
     * @param options
     * @param table
     */
    public void GetCrypto(JComboBox options, JTable table) {

        String S_options = options.getSelectedItem().toString();

        // validating the JCombobox
        if (validate.ValidateComboBox(options)) {
            try {
                crypto = YahooFinance.get(S_options);

                String name = crypto.getName().toString();
                String currency = crypto.getCurrency();
                String price = crypto.getQuote().getPrice().toString();
                String exchange = crypto.getStockExchange().toString();
                String volume = crypto.getQuote().getAvgVolume().toString();
                String change = crypto.getQuote().getChangeInPercent().toString();

                crypto.print();

                String tbData[] = {name, currency, exchange, price, change, volume};
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                // Adding data to the model
                model.addRow(tbData);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "API error the crypto doesn't exist or check your connection", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
