import java.util.ArrayList;

public class Cidadao implements Contribuinte
{
    private int idade;
    private int id;
    private String nome;
    private ArrayList<Pessoa> dependentes;
    private ArrayList<Despesa> despesas;
    private ArrayList<Rendimento> rendimentos;



    public Cidadao(){}


    @Override
    public void cadastraDependente(Pessoa dependente)
    {

    }

    @Override
    public void cadastraDespesa(Despesa despesa)
    {

    }

    @Override
    public void cadastraRendimento(Rendimento rendimento) {

    }

    @Override
    public ArrayList<Pessoa> getDependentes() {
        return null;
    }

    @Override
    public ArrayList<Despesa> getDespesas() {
        return null;
    }

    @Override
    public ArrayList<Rendimento> getRendimentos() {
        return null;
    }

    @Override
    public double getTotalRendimentos() {
        return 0;
    }

    @Override
    public double getTotalDespesas() {
        return 0;
    }

    @Override
    public double getBaseDeCalculo() {
        return 0;
    }

    @Override
    public double getImpostoPagarSimplificado() {
        return 0;
    }

    @Override
    public double getImpostoPagarCompleto() {
        return 0;
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
}