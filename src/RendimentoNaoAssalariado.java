import java.util.ArrayList;
import java.util.Set;

public class RendimentoNaoAssalariado implements IRendimentoNaoAssalariado
{

    private int id;
    private String descricao;
    private ArrayList<Entrada> rendimentos;
    private ArrayList<Entrada> despesas;



    public RendimentoNaoAssalariado(int id, String descricao)
    {
        this.id = id;
        this.descricao = descricao;
        rendimentos = new ArrayList<>();
        despesas = new ArrayList<>();
    }

    @Override
    public void cadastraValorRecebido(Entrada valor)
    {
        rendimentos.add(valor);
    }

    @Override
    public void cadastraDespesa(Despesa valor)
    {
        despesas.add(valor);
    }

    @Override
    public double getTotalRecebidoMes(int mes)
    {
        double total = 0;

        for (Entrada e: rendimentos)
        {
            if (e.getMes() == mes) total += e.getValor();
        }
        return total;
    }

    @Override
    public double getDespesaTotalMes(int mes)
    {
        double total = 0;

        for (Entrada e: despesas)
        {
            if (e.getMes() == mes) total += e.getValor();
        }
        return total;
    }

    @Override
    public double getTotalTributavelMes(int mes)
    {
        double total = getTotalRecebidoMes(mes) - getDespesaTotalMes(mes);

        if (total < 0) return 0;
        return total;
    }

    @Override
    public ArrayList<Entrada> valoresRecebidos()
    {
        return rendimentos;
    }

    @Override
    public ArrayList<Entrada> valoresGastos()
    {
        return despesas;
    }

    @Override
    public int getId()
    {
        return this.id;
    }

    @Override
    public String getDescricao()
    {
        return this.descricao;
    }

    @Override
    public double getTotalRecebidoAno()
    {
        double total = 0;
        for(Entrada e: rendimentos)
        {
            total += e.getValor();
        }
        return total;
    }

    @Override
    public double getTotalTributavel()
    {
        double total = 0;

        for (int i = 1; i <= 12 ; i++)
        {
            total += getTotalTributavelMes(i);
        }
        return total;
    }
}
