package Launcher;

import GUI.Main;
import java.awt.Point;

/**
 *
 * @author zeeshan
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        // Adding a new look and feel to the JSwing components
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException error");
        } catch (InstantiationException ex) {
            System.out.println("InstantiationException error");
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException error");
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("UnsupportedLookAndFeelException error");
        }

        // initiate the main class
        Main GUI = new Main();

        // Configs to the instance
        GUI.setTitle("Stock & Crypto Application");
        GUI.setLocation(new Point(150, 50));
        GUI.setVisible(true);
        GUI.setResizable(false);

    }
}
