public class RendimentoAssalariado implements IRendimentoAssalariado
{
    //Total recebido no ano, recolhido de imposto na fonte, e o quanto foi pago de INNS

    private double totalRecebidoAno;
    private double recolhidoNaFonte;
    private double totalInssPago;
    private int id;
    private String descricao;


    public RendimentoAssalariado(int id, String descricao, double totalRecebidoAno, double recolhidoNaFonte, double totalInssPago)
    {
        this.totalRecebidoAno = totalRecebidoAno;
        this.recolhidoNaFonte = recolhidoNaFonte;
        this.totalInssPago = totalInssPago;
        this.id = id;
    }

    @Override
    public double getTotalIrRecolhidoNaFonte()
    {
        return this.recolhidoNaFonte;
    }

    @Override
    public double getTotalINSSPago()
    {
        return this.totalInssPago;
    }

    @Override
    public int getId()
    {
        return this.id;
    }

    @Override
    public String getDescricao()
    {
        return this.descricao;
    }

    @Override
    public double getTotalRecebidoAno()
    {
        return this.totalRecebidoAno;
    }

    @Override
    public double getTotalTributavel()
    {
        return this.totalRecebidoAno - this.totalInssPago;
    }
}
