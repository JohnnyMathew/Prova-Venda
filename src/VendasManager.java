import java.time.LocalDate;
import java.util.ArrayList;

public class VendasManager {
    private ArrayList<Venda> vendas = new ArrayList<>();

    public void realizarVenda(Venda venda) {
        vendas.add(venda);
    }

    public ArrayList<Venda> vendasPorPeriodo(LocalDate inicio, LocalDate fim) {
        ArrayList<Venda> resultado = new ArrayList<>();
        for (Venda v : vendas) {
            if (!v.getData().isBefore(inicio) && !v.getData().isAfter(fim)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public double mediaVendasPeriodo(LocalDate inicio, LocalDate fim) {
        ArrayList<Venda> lista = vendasPorPeriodo(inicio, fim);
        if (lista.isEmpty()) return 0;
        double total = 0;
        for (Venda v : lista) total += v.getValorTotal();
        return total / lista.size();
    }
}

