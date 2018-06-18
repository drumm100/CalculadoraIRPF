import java.util.ArrayList;

public class Cidadao implements IContribuinte
{
    private int idade;
    private int id;
    private String nome;
    private ArrayList<IPessoa> dependentes;
    private ArrayList<Despesa> despesas;
    private ArrayList<IRendimento> rendimentos;



    public Cidadao(int id, int idade, String nome){
        this.id = id;
        this.idade = idade;
        this.nome = nome;
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
    public void cadastraDespesa(Despesa despesa)
    {
        despesas.add(despesa);
    }

    @Override
    public void cadastraRendimento(IRendimento rendimento)
    {
        rendimentos.add(rendimento);
    }


    @Override
    public ArrayList<IPessoa> getDependentes() {
        return this.dependentes;
    }

    @Override
    public ArrayList<Despesa> getDespesas() {
        return this.despesas;
    }

    @Override
    public ArrayList<IRendimento> getRendimentos() {
        return this.rendimentos;
    }

    @Override
    public double getTotalRendimentos()
    {
        int total = 0;
        for (IRendimento r: rendimentos)
        {

        }
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

}
