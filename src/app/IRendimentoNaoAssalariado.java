package app;

import java.util.ArrayList;

public interface IRendimentoNaoAssalariado extends IRendimento{

    //@ requires valor != null;
    //@ ensures !(valoresRecebidos().contains(valor));
    //@ ensures valoresRecebidos().contains(valor);
    void cadastraValorRecebido(Entrada valor);

    //@ requires valor != null;
    //@ ensures !(valoresGastos().contains(valor));
    //@ ensures valoresGastos().contains(valor);
    void cadastraDespesa(Despesa valor);

    //@ requires mes >= 1
    //@ requires mes <= 12
    double /*@ pure @*/ getTotalRecebidoMes(int mes);

    //@ requires mes >= 1
    //@ requires mes <= 12
    double /*@ pure @*/ getDespesaTotalMes(int mes);

    //@ require getTotalRecebidoMes(mes) - getDespesaTotalMes(mes) >= 0
    //@ ensures \result == getTotalRecebidoMes(mes) - getDespesaTotalMes(mes)
    //@
    //@ also
    //@
    //@ requires getTotalRecebidoMes(mes) - getDespesaTotalMes(mes) < 0
    //@ ensures \result == 0
    double /*@ pure @*/ getTotalTributavelMes(int mes);

    ArrayList<Entrada> /*@ pure @*/ valoresRecebidos();

    ArrayList<Entrada> /*@ pure @*/ valoresGastos();
}
