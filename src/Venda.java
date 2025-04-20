import java.time.LocalDate;

public class Venda {
    private LocalDate data;
    private Produto produto;
    private int quantidade;

    public Venda(LocalDate data, Produto produto, int quantidade) {
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public LocalDate getData() { return data; }
    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    public double getValorTotal() {
        return quantidade * produto.getValor();
    }

    @Override
    public String toString() {
        return String.format("%s | %s | Qtd: %d | R$%.2f | Total: R$%.2f",
                data, produto.getNome(), quantidade, produto.getValor(), getValorTotal());
    }
}

