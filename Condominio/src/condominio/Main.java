package condominio;

import estruturas.vetor.MyVetor;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Condominio;

/**
 *
 * @author migue
 */
public class Main {

    public static boolean hasCondominio(int cod, MyVetor<Condominio> listaCondominio) {
        for (Condominio c : listaCondominio) {
            if (c.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        MyVetor<Condominio> listaCondominio = new MyVetor();
        int codCondominio = 1;
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("--MENU--\n"
                    + "1 – Cadastrar condomínio\n"
                    + "2 – Cadastrar bloco (edifício de um condomínio)\n"
                    + "3 – Cadastrar apartamento\n"
                    + "4 – Cadastrar pessoa\n"
                    + "5 – Vender apartamento\n"
                    + "6 – Listar condomínios\n"
                    + "7 – Listar apartamentos de um condomínio\n"
                    + "8 – Listar apartamentos não vendidos de um condomínio\n"
                    + "9 – Gerar relatório por condomínio com as despesas dos apartamentos não vendidos\n"
                    + "10 – Listar os apartamentos de uma pessoa\n"
                    + "0- SAIR"));

            switch (op) {
                case 1://cadastrar condominio
                    listaCondominio.adicionar(new Condominio(codCondominio++,
                            JOptionPane.showInputDialog("Nome do condominio:"),
                            Double.parseDouble(JOptionPane.showInputDialog("Valor que cada apartamento paga"))
                    ));
                    break;
                case 2://cadastrar bloco
                    int codCondCadastroBloco = Integer.parseInt(JOptionPane.showInputDialog("Código do condomínio"));
                    if (hasCondominio(codCondCadastroBloco, listaCondominio)) {
                        for (Condominio c : listaCondominio) {
                            if (c.getCodigo() == codCondCadastroBloco) {
                                c.addBloco(JOptionPane.showInputDialog("Nome do bloco:"));
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Condominio não encontrado");
                    }

            }
        } while (op != 0);
    }

}
