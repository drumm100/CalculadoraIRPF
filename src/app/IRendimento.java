package app;

public interface IRendimento {

    int /*@ pure @*/ getId();
    String /*@ pure @*/ getDescricao();

    double /*@ pure @*/ getTotalRecebidoAno();

    double /*@ pure @*/ getTotalTributavel();
}
