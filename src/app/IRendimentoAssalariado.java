package app;

public interface IRendimentoAssalariado extends IRendimento{
    double /*@ pure @*/ getTotalRecolhidoNaFonte();
    double /*@ pure @*/ getTotalINSSPago();
}
