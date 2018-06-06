import java.util.ArrayList;
import java.util.Set;
/*
* Mantem os dependentes, despesas e rendimentos de uma pessoa
* Retorna o total de rendimentos e desespeas
*
* */


public interface Contribuinte extends Pessoa {

    //@ requires dependente != null;
    //@ requires !(getDependentes().contains(dependente));
    //@ ensures getDependentes().contains(dependentes);
    void cadastraDependente(Pessoa dependente);

    //@ requires despesa != null;
    //@ requires !(getDespesas().contains(dependente));
    //@ ensures getDespesas().contains(despesas);
    void cadastraDespesa(Despesa despesa);

    //@ requires rendimento != null;
    //@ requires !(getRendimentos().contains(rendimento));
    //@ ensures getRendimentos().contains(rendimento);
    void cadastraRendimento(Rendimento rendimento);

    ArrayList<Pessoa> getDependentes();
    ArrayList<Despesa> getDespesas();
    ArrayList<Rendimento> getRendimentos();

    //@ requires !(getRendimentos().isEmpty());
    //@ ensures \result == (\sum int i; 0<= i && i < getRendimentos().size(); getRendimentos().get(i));
    double getTotalRendimentos();

    //@ requires !(getDespesas().isEmpty());
    //@ ensures \result == (\sum int i; 0<= i && i < getDespesas().size(); getDespesas().get(i));
    double getTotalDespesas();

    // TODO
    double getBaseDeCalculo();

    // TODO
    double getImpostoPagarSimplificado();

    // TODO
    double getImpostoPagarCompleto();
}
