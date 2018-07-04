package app;

import java.util.ArrayList;

public interface IContribuinte extends IPessoa {
    void cadastraDependente(IPessoa dependente);
    ArrayList<IPessoa> getDependentes();

    void cadastraDespesa(Despesa despesa);
    ArrayList<Despesa> getDespesas();

    void cadastraRendimento(IRendimento rendimento);
    ArrayList<IRendimento> getRendimentos();
    ArrayList<IRendimentoAssalariado> getRendimentosAssalariado();
    ArrayList<IRendimentoNaoAssalariado> getRendimentoNaoAssalariado();

    double getTotalRendimentos();
    double getTotalDespesas();
    double getBaseDeCalculoSimplificado();
    double getBaseDeCalculoCompleto();
    double getImpostoPagarSimplificado();
    double getImpostoPagarCompleto();
}
