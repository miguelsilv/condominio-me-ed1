package condominio;

import estruturas.vetor.MyVetor;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Bloco;
import model.Condominio;
import model.Pessoa;

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

    public static boolean hasBloco(int cod, MyVetor<Bloco> listaCondominio) {
        for (Bloco b : listaCondominio) {
            if (b.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasAP(int num, MyVetor<Integer> listAP) {
        for (int b : listAP) {
            if (b == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyVetor<Condominio> listaCondominio = new MyVetor();
        MyVetor<Pessoa> listaPessoa = new MyVetor();

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
                            Double.parseDouble(JOptionPane.showInputDialog("Valor que cada apartamento paga:"))
                    ));
                    JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO \nCód: " + (codCondominio - 1));
                    break;
                case 2://cadastrar bloco
                    int codCondCadastroBloco = Integer.parseInt(JOptionPane.showInputDialog("Código do condomínio"));
                    if (hasCondominio(codCondCadastroBloco, listaCondominio)) {
                        for (Condominio c : listaCondominio) {
                            if (c.getCodigo() == codCondCadastroBloco) {
                                int codBlocoCadastroBloco = c.addBloco(JOptionPane.showInputDialog("Nome do bloco:"));
                                JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO \nCód: " + codBlocoCadastroBloco);
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Condominio não encontrado");
                    }
                    break;
                case 3: // cadastrar apartamento
                    int codCondCadastrarAP = Integer.parseInt(JOptionPane.showInputDialog("Código do condomínio"));
                    if (hasCondominio(codCondCadastrarAP, listaCondominio)) {
                        for (Condominio c : listaCondominio) {
                            if (c.getCodigo() == codCondCadastrarAP) {
                                int codBlocoCadastrarAP = Integer.parseInt(JOptionPane.showInputDialog("Código do bloco"));
                                if (hasBloco(codBlocoCadastrarAP, c.getListaBlocos())) {
                                    for (Bloco b : c.getListaBlocos()) {
                                        if (b.getCodigo() == codBlocoCadastrarAP) {
                                            b.addApartamento(Integer.parseInt(JOptionPane.showInputDialog("Número do apartamento")));
                                            JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO!");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Condominio não encontrado");
                    }
                    break;
                case 4: // cadastrar pessoa
                    String cpf = JOptionPane.showInputDialog("CPF:");
                    boolean isCpf = false;
                    for (Pessoa p : listaPessoa) {
                        if (p.getCpf().equals(cpf)) {
                            JOptionPane.showMessageDialog(null, "JÁ EXISTE ALGUEM COM ESSE CPF!");
                            isCpf = true;
                            break;
                        }
                    }
                    if (!isCpf) {
                        listaPessoa.adicionar(new Pessoa(
                                cpf,
                                JOptionPane.showInputDialog("Nome:")
                        ));
                        JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO!");
                    }
                    break;
                case 5://

            }
        } while (op != 0);
    }

}
