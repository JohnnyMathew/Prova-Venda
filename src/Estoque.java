import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto consultarProduto(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }

    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }

    public double getValorMedio() {
        if (produtos.isEmpty()) return 0;
        double soma = 0;
        for (Produto p : produtos) soma += p.getValor();
        return soma / produtos.size();
    }

    public double getValorMaximo() {
        double max = 0;
        for (Produto p : produtos) {
            if (p.getValor() > max) max = p.getValor();
        }
        return max;
    }

    public double getValorMinimo() {
        if (produtos.isEmpty()) return 0;
        double min = produtos.get(0).getValor();
        for (Produto p : produtos) {
            if (p.getValor() < min) min = p.getValor();
        }
        return min;
    }
}

