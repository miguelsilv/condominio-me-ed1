package condominio;

import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class Condominio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op = 0;
        do {
            JOptionPane.showInputDialog("--MENU--\n"
                    + "1-CADASTRAR COND.");

        } while (op == 0);
    }

}
