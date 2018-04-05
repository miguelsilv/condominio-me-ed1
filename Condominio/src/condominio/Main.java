package condominio;

import estruturas.vetor.MyVetor;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Apartamento;
import model.Bloco;
import model.Condominio;
import model.Pessoa;

/**
 *
 * @author migue
 */
public class Main {

    public static void getAPPessoa(Pessoa dono, MyVetor<Condominio> listaCondominio) {
        for (Condominio c : listaCondominio) {
            for (Bloco b : c.getListaBlocos()) {
                b.getListAP();
                for (Apartamento ap : b.getListAP()) {
                    if (ap.getDono().equals(dono) || dono == ap.getDono()) {
                        JOptionPane.showMessageDialog(null, dono.getCpf() + "–" + dono.getNome() + "\n"
                                + "\nCód cond:" + c.getCodigo() + "\n"
                                + "Cond:" + c.getNome() + "\n\n"
                                + "Cód Bloco" + b.getCodigo() + " \n"
                                + "Bloco: " + b.getNome() + "\n\n"
                                + "Apartamento: " + ap.getNumero());
                    }
                }

            }
        }
    }

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

    public static boolean hasAP(int num, MyVetor<Apartamento> listAP) {
        for (Apartamento ap : listAP) {
            if (ap.getNumero() == num) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPessoa(String cpf, MyVetor<Pessoa> listPessoa) {
        for (Pessoa p : listPessoa) {
            if (p.getCpf().equals(cpf)) {
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
                                            int numAp = Integer.parseInt(JOptionPane.showInputDialog("Número do apartamento"));
                                            if (!hasAP(numAp, b.getListAP())) {
                                                b.addApartamento(numAp);
                                                JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO!");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Esse Apartamento já existe, informe outro!");
                                            }
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "bloco não encontrado");
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Condominio não encontrado");
                    }
                    break;
                case 4: // cadastrar pessoa
                    String cpf = JOptionPane.showInputDialog("CPF:");
                    if (hasPessoa(cpf, listaPessoa)) {
                        JOptionPane.showMessageDialog(null, "JÁ EXISTE ALGUEM COM ESSE CPF!");
                    } else {
                        listaPessoa.adicionar(new Pessoa(
                                cpf,
                                JOptionPane.showInputDialog("Nome:")
                        ));
                        JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO!");
                    }

                    break;
                case 5://vender ap
                    int codCondVender = Integer.parseInt(JOptionPane.showInputDialog("Código do condomínio"));
                    if (hasCondominio(codCondVender, listaCondominio)) {
                        int codBlocoVender = Integer.parseInt(JOptionPane.showInputDialog("Código do bloco"));
                        for (Condominio c : listaCondominio) {
                            if (c.getCodigo() == codBlocoVender) {
                                if (hasBloco(codBlocoVender, c.getListaBlocos())) {

                                    for (Bloco b : c.getListaBlocos()) {
                                        if (b.getCodigo() == codBlocoVender) {
                                            int numApVender = Integer.parseInt(JOptionPane.showInputDialog("Nº do AP:"));
                                            if (hasAP(numApVender, b.getListAP())) {
                                                for (Apartamento ap : b.getListAP()) {
                                                    if (ap.getNumero() == numApVender) {
                                                        if (ap.getDono() == null) {
                                                            String cpfVender = JOptionPane.showInputDialog("CPF do comprador:");
                                                            if (hasPessoa(cpfVender, listaPessoa)) {
                                                                for (Pessoa p : listaPessoa) {
                                                                    if (p.getCpf().equals(cpfVender)) {
                                                                        b.venderAP(numApVender, p);
                                                                        JOptionPane.showMessageDialog(null, "Vendido com sucesso \n"
                                                                                + "Dono:" + p.getNome() + "\n"
                                                                                + "AP:" + numApVender + "\n"
                                                                                + "Bloco:" + b.getNome() + "\n"
                                                                                + "Condominio:" + c.getNome());
                                                                        break;
                                                                    }
                                                                }
                                                                break;
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "pessoa não encontrada");
                                                            }
                                                            break;
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Este AP já foi vendido!");
                                                        }
                                                        break;
                                                    }
                                                }
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Apartamento não encontrado");
                                            }
                                        }
                                    }
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Bloco não encontrado");
                                }
                                break;
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Condominio não encontrado");
                    }
                    break;
                case 6:
                    for (Condominio c : listaCondominio) {
                        JOptionPane.showMessageDialog(null, "Cód: " + c.getCodigo() + "\n"
                                + "Bloco:" + null + " \n"
                                + "Não vendidos: \n"
                                + "Vendidos: \n"
                                + "Total: \n");
                    }
                    break;
                case 7://Listar apartamentos de um condomínio
                case 8:
                case 9:
                    JOptionPane.showMessageDialog(null, "Ainda não implementado");
                    break;
                case 10: // listar cond pessoa
                    String cpfListagemAp = JOptionPane.showInputDialog("CPF:");
                    if (hasPessoa(cpfListagemAp, listaPessoa)) {
                        for (Pessoa p : listaPessoa) {
                            if (p.getCpf().equals(cpfListagemAp)) {
                                getAPPessoa(p, listaCondominio);
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
                    }
                    break;
            }
        } while (op != 0);
    }

}
