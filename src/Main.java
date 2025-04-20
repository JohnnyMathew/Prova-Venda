import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();
        VendasManager vendasManager = new VendasManager();
        int opcao;
        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produtos");
            System.out.println("4 - Vendas por período (detalhado)");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Código: ");
                    int cod = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    estoque.adicionarProduto(new Produto(cod, nome, valor, qtd));
                    System.out.println("Produto adicionado!");
                }

                case 2 -> {
                    System.out.print("Código: ");
                    int cod = sc.nextInt();
                    Produto p = estoque.consultarProduto(cod);
                    if (p != null) System.out.println(p);
                    else System.out.println("Produto não encontrado.");
                }

                case 3 -> {
                    System.out.println("\n--- LISTAGEM DE PRODUTOS ---");
                    for (Produto p : estoque.listarProdutos()) {
                        System.out.println(p);
                    }
                    System.out.printf("\nValor médio: R$%.2f\n", estoque.getValorMedio());
                    System.out.printf("Valor máximo: R$%.2f\n", estoque.getValorMaximo());
                    System.out.printf("Valor mínimo: R$%.2f\n", estoque.getValorMinimo());
                }

                case 4 -> {
                    sc.nextLine();
                    System.out.print("Data início (AAAA-MM-DD): ");
                    LocalDate ini = LocalDate.parse(sc.nextLine());
                    System.out.print("Data fim (AAAA-MM-DD): ");
                    LocalDate fim = LocalDate.parse(sc.nextLine());
                    ArrayList<Venda> lista = vendasManager.vendasPorPeriodo(ini, fim);

                    System.out.println("\n--- RELATÓRIO DE VENDAS ---");
                    for (Venda v : lista) {
                        System.out.println(v);
                    }
                    System.out.printf("\nValor médio das vendas: R$%.2f\n", vendasManager.mediaVendasPeriodo(ini, fim));
                }

                case 5 -> {
                    System.out.print("Código do produto: ");
                    int cod = sc.nextInt();
                    Produto p = estoque.consultarProduto(cod);
                    if (p != null) {
                        System.out.print("Quantidade vendida: ");
                        int qtd = sc.nextInt();
                        if (p.getQuantidade() >= qtd) {
                            p.setQuantidade(p.getQuantidade() - qtd);
                            vendasManager.realizarVenda(new Venda(LocalDate.now(), p, qtd));
                            System.out.println("Venda realizada!");
                        } else {
                            System.out.println("Estoque insuficiente!");
                        }
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }

                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}

