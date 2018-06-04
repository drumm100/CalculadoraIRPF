import java.util.Set;
/*
* Mantem os dependentes, despesas e rendimentos de uma pessoa
* Retorna o total de rendimentos e desespeas
*
* */


public interface Contribuinte extends Pessoa {

    void cadastraDependente(Pessoa dependente);
    Set<Pessoa> getDependentes();
    
    void cadastraDespesa(Despesa despesa);
    Set<Despesa> getDespesas();
    
    void cadastraRendimento(Rendimento rendimento);
    Set<Rendimento> getRendimentos();
    
    double getTotalRendimentos();
    double getTotalDespesas();
    double getBaseDeCalculo();
    double getImpostoPagarSimplificado();
    double getImpostoPagarCompleto();
}
