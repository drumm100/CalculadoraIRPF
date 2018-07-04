package app;

import java.util.ArrayList;

public interface IContribuinte extends IPessoa {

    //@ requires dependente != null;
    //@ requires !(getDependentes().contains(dependente));
    //@ ensures getDependentes().contains(dependentes);
    void cadastraDependente(IPessoa dependente);

    //@ requires despesa != null;
    //@ requires !(getDespesas().contains(despesa));
    //@ ensures getDespesas().contains(despesa);
    void cadastraDespesa(Despesa despesa);

    //@ requires rendimento != null;
    //@ requires !(getRendimentos().contains(rendimento));
    //@ ensures getRendimentos().contains(rendimento);
    void cadastraRendimento(IRendimento rendimento);


    ArrayList<Despesa> /*@ pure @*/ getDespesas();
    ArrayList<IPessoa> /*@ pure @*/ getDependentes();
    ArrayList<IRendimento> /*@ pure @*/ getRendimentos();
    ArrayList<IRendimentoAssalariado> /*@ pure @*/ getRendimentosAssalariado();
    ArrayList<IRendimentoNaoAssalariado> /*@ pure @*/ getRendimentoNaoAssalariado();

    //@ ensures \result == (\sum int i; 0<= i && i < getRendimentos().size(); getRendimentos().get(i).getTotalRecebidoAno());
    double getTotalRendimentos();

    //@ ensures \result == (\sum int i; 0<= i && i < getDespesas().size(); getDespesas().get(i).getValor());
    double getTotalDespesas();

    //@ ensures \result == getTotalTributavel() - getTotalRecolhidoFonte()
    double getBaseDeCalculoSimplificado();

    //@ ensures \result == getBaseDeCalculoSimplificado() - getTotalBonus()
    double getBaseDeCalculoCompleto();

    //@ requires getBaseDeCalculoSimplificado() <= 15000.00
    //@ ensures \result == 0
    //@
    //@ also
    //@
    //@ requires getBaseDeCalculoSimplificado() > 15000.00
    //@ requires getBaseDeCalculoSimplificado() <= 35000.00
    //@ ensures \result == getBaseDeCalculoSimplificado() * 0.15
    //@
    //@ also
    //@
    //@ requires getBaseDeCalculoSimplificado() > 35000.00
    //@ ensures \result == getBaseDeCalculoSimplificado() * 0.3
    double getImpostoPagarSimplificado();

    //@ requires getBaseDeCalculoCompleto() <= 15000.00
    //@ ensures \result == 0
    //@
    //@ also
    //@
    //@ requires getBaseDeCalculoCompleto() > 15000.00
    //@ requires getBaseDeCalculoCompleto() <= 35000.00
    //@ ensures \result == getBaseDeCalculoCompleto() * 0.15
    //@
    //@ also
    //@
    //@ requires getBaseDeCalculoCompleto() > 35000.00
    //@ ensures \result == getBaseDeCalculoCompleto() * 0.3
    double getImpostoPagarCompleto();
}
