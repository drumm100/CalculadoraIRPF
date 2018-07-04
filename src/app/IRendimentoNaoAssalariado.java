package app;

import java.util.ArrayList;

public interface IRendimentoNaoAssalariado extends IRendimento{
    void cadastraValorRecebido(Entrada valor);
    void cadastraDespesa(Despesa valor);
    double getTotalRecebidoMes(int mes);
    double getDespesaTotalMes(int mes);
    double getTotalTributavelMes(int mes);
    ArrayList<Entrada> valoresRecebidos();
    ArrayList<Entrada> valoresGastos();
}
