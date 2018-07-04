package app;

import java.util.ArrayList;


public class Cidadao implements IContribuinte {
    private int idade;
    private int id;
    private String nome;
    private ArrayList<IPessoa> dependentes;
    private ArrayList<Despesa> despesas;
    private ArrayList<IRendimento> rendimentos;




    public Cidadao(int id, int idade, String nome)
    {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        despesas = new ArrayList<>();
        dependentes = new ArrayList<>();
        rendimentos = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getIdade() {
        return idade;
    }

    @Override
    public void cadastraDependente(IPessoa dependente)
    {
        dependentes.add(dependente);
    }

    @Override
    public void cadastraDespesa(Despesa despesa) {despesas.add(despesa);}

    @Override
    public void cadastraRendimento(IRendimento rendimento) {rendimentos.add(rendimento);}


    @Override
    public ArrayList<IPessoa> getDependentes() {
        return this.dependentes;
    }

    @Override
    public ArrayList<Despesa> getDespesas() {
        return this.despesas;
    }

    @Override
    public ArrayList<IRendimento> getRendimentos(){return this.rendimentos;}

    @Override
    public ArrayList<IRendimentoAssalariado> getRendimentosAssalariado()
    {
        ArrayList<IRendimentoAssalariado> aux = new ArrayList<>();

        for (IRendimento r: rendimentos)
        {
            if (r instanceof IRendimentoAssalariado)
            {
                aux.add((IRendimentoAssalariado) r);
            }
        }
        return aux;
    }

    @Override
    public ArrayList<IRendimentoNaoAssalariado> getRendimentoNaoAssalariado()
    {
        ArrayList<IRendimentoNaoAssalariado> aux = new ArrayList<>();

        for (IRendimento r: rendimentos)
        {
            if (r instanceof IRendimentoNaoAssalariado)
            {
                aux.add((IRendimentoNaoAssalariado) r);
            }
        }
        return aux;
    }

    @Override
    public double getTotalRendimentos()
    {
        int total = 0;
        for (IRendimento r: rendimentos)
        {
            total += r.getTotalRecebidoAno();
        }
        return total;
    }

    @Override
    public double getTotalDespesas()
    {
        int total = 0;
        for (Despesa d: despesas)
        {
            total += d.getValor();
        }
        return total;
    }

    @Override
    public double getBaseDeCalculoSimplificado()
    {
        return getTotalTributavel() - getTotalRecolhidoFonte();
    }

    @Override
    public double getBaseDeCalculoCompleto()
    {
        return getBaseDeCalculoSimplificado() - getTotalBonus();
    }

    //Métodos adicionais:
    private double getTotalTributavel()
    {
        int total = 0;
        for (IRendimento r: rendimentos)
        {
            total += r.getTotalTributavel();
        }
        return total;
    }
    private double getTotalRecolhidoFonte()
    {
        double total = 0;
        for (IRendimentoAssalariado r: getRendimentosAssalariado())
        {
           total += r.getTotalRecolhidoNaFonte();
        }
        return total;
    }
    private double getTotalBonus()
    {
        double total = 0;

        for (Despesa d: despesas)
        {
            if(d.getIdPessoa() == this.id) {
                if (d.getTipoDespesa() >= 0) {
                    total = (d.getValor() > 20000) ? 10000 : d.getValor() * 0.5;
                }
            }else{
                if(d.getTipoDespesa() == 1){
                    total += (d.getValor() >= 5000) ? 5000 : d.getValor();
                }
                if(d.getTipoDespesa() == 0){
                    total += (d.getValor() >= 6000) ? 3000 : d.getValor()*0.5;
                }
            }
        }
        return total;
    }

/**
 * a.	Base de cálculo até $ 15000,00 no ano é considerada isenta.
 * b.	 A faixa entre $ 15001,00 até 35000,00 deve pagar 15% de imposto.
 * c.	Os valores que excederem 35000,00 são tributados em 30%.
 * */

    @Override
    public double getImpostoPagarSimplificado()
    {
        if (getBaseDeCalculoSimplificado() <= 15000.00)
            return 0;
        if (getBaseDeCalculoSimplificado() > 15000.00 && getBaseDeCalculoSimplificado() <= 35000.00)
            return getBaseDeCalculoSimplificado()*0.15;
        else
            return getBaseDeCalculoSimplificado()*0.3;
    }

    @Override
    public double getImpostoPagarCompleto()
    {
        if (getBaseDeCalculoCompleto() <= 15000.00)
            return 0;
        if (getBaseDeCalculoCompleto() > 15000.00 && getBaseDeCalculoCompleto() <= 35000.00)
            return getBaseDeCalculoCompleto()*0.15;
        else
            return getBaseDeCalculoCompleto()*0.3;
    }

}
