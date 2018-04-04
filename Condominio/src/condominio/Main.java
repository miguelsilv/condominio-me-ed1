package condominio;

import estruturas.vetor.MyVetor;
import javax.swing.JOptionPane;
import model.Condominio;

/**
 *
 * @author migue
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyVetor<Condominio> listaCondominio = new MyVetor();
        int codCondominio = 1;
        int op = 0;
        do {
            JOptionPane.showInputDialog("--MENU--\n"
                    + "1 – Cadastrar condomínio\n"
                    + "2 – Cadastrar bloco (edifício de um condomínio)\n"
                    + "3 – Cadastrar apartamento\n"
                    + "4 – Cadastrar pessoa\n"
                    + "5 – Vender apartamento\n"
                    + "6 – Listar condomínios\n"
                    + "7 – Listar apartamentos de um condomínio\n"
                    + "8 – Listar apartamentos não vendidos de um condomínio\n"
                    + "9 – Gerar relatório por condomínio com as despesas dos apartamentos não vendidos\n"
                    + "10 – Listar os apartamentos de uma pessoa");

            switch (op) {
                case 1://cadastrar condominio
                    listaCondominio.adicionar(new Condominio(codCondominio++,
                            JOptionPane.showInputDialog("Nome do condominio:"),
                            Double.parseDouble(JOptionPane.showInputDialog("Valor que cada apartamento paga"))
                    ));
                    break;
                case 2://cadastrar bloco
                    

            }
        } while (op == 0);
    }

}
