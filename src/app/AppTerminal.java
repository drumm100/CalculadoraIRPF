package app;

import java.util.Scanner;

public class AppTerminal {
    private static Scanner s;
    static Persistencia p = Persistencia.getInstance();

    public AppTerminal()
    {
        s = new Scanner(System.in);
    }



    public static void main(String[] args)
    {
        while (true)
        {
            AppTerminal ap = new AppTerminal();
            System.out.println("########################");
            System.out.println("#### Insira o nome: ####");
            String nome = s.nextLine();
            System.out.println("#### Insira a idade: ####");
            String idade = s.nextLine();

            //Busca
            Cidadao aux = ControleTerminal.BuscaCidadao(nome, idade);

            //Teste
            System.out.println(p.retornaLista().toString());

            boolean control_1 = true;
            while (control_1)
            {
                System.out.println("Menû");
                System.out.println("[1] Relatórios");
                System.out.println("[2] Adicionar dados");
                System.out.println("[3] Sair");

                String op = s.nextLine();

                switch (op) {
                    case "1":
                        System.out.println("Relatorios:");
                        System.out.println("<1> ImpostoSimplificado");
                        System.out.println("<2> ImpostoCompleto");
                        String op2 = s.nextLine();

                        if (op2.equals("1")) System.out.println("Valor: " + aux.getImpostoPagarSimplificado());
                        if (op2.equals("2")) System.out.println("Valor: " + aux.getImpostoPagarCompleto());
                        else System.out.println("Opção inválida");

                        break;

                    case "2":
                        boolean control_2 = true;
                        while (control_2) {
                            System.out.println("Menû");
                            System.out.println("[1] Cadastrar Despesa");
                            System.out.println("[2] Cadastra Reindimento");
                            System.out.println("[3] Cadastra Dependente");
                            System.out.println("[4] Voltar");
                            String op3 = s.nextLine();

                            switch (op3) {
                                case "1":
                                    System.out.println("Digite o id da despesa.");
                                    String id_despesa = s.nextLine();
                                    System.out.println("Digite o id da pessoa");
                                    String id_pessoa = s.nextLine();
                                    System.out.println("Digite o tipo da desepsa");
                                    String tipo_despesa = s.nextLine();
                                    System.out.println("Digite a competência em numeros");
                                    String mes = s.nextLine();
                                    System.out.println("Digite o valor");
                                    String valor = s.nextLine();
                                    ControleTerminal.CadatraDespesa(aux, Integer.parseInt(id_despesa), Integer.parseInt(id_pessoa), Integer.parseInt(tipo_despesa), Integer.parseInt(mes), Double.parseDouble(valor));
                                    break;

                                case "2":
                                    System.out.println("É assalariado?[sim/nao]");
                                    String resposta = s.nextLine();
                                    if (resposta.equals("nao")) {
                                        System.out.println("Digite o id");
                                        String id = s.nextLine();
                                        System.out.println("Digite a descrição");
                                        String descricao = s.nextLine();
                                        System.out.println("Digite o mes");
                                        String mes_e = s.nextLine();
                                        System.out.println("Digite o valor");
                                        String valor_e = s.nextLine();

                                        ControleTerminal.CadastraRendimentoNaoAssalariado(aux, Integer.parseInt(id), descricao, Integer.parseInt(mes_e), Double.parseDouble(valor_e));
                                    } else {
                                        System.out.println("Digite o id");
                                        String id = s.nextLine();
                                        System.out.println("Digite a descrição");
                                        String descricao = s.nextLine();
                                        System.out.println("Digite o total recebido no ano");
                                        String recebido_ano = s.nextLine();
                                        System.out.println("Digite o IRRF");
                                        String irff = s.nextLine();
                                        System.out.println("Digite o INSS pago");
                                        String inss = s.nextLine();

                                        ControleTerminal.CadastraRendimentoAssalariado(aux, Integer.parseInt(id), descricao, Double.parseDouble(recebido_ano), Double.parseDouble(irff), Double.parseDouble(inss));
                                    }
                                    break;

                                case "3":
                                    System.out.println("Digite o nome do dependente");
                                    String nome_d = s.nextLine();
                                    System.out.println("Digite a idade do dependente");
                                    String idade_d = s.nextLine();

                                    ControleTerminal.cadastraDependente(aux, nome_d, idade_d);
                                    break;
                                case "4":
                                    control_2 = false;
                                    break;
                            }
                        }

                    case "3":
                        control_1 = false;
                        break;
                }

            }

        }

    }
}
