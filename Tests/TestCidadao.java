import app.*;
import org.junit.BeforeClass;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class TestCidadao
{
    static Cidadao Neymar;
    static Cidadao Bruna;

    static Despesa d1;
    static Despesa d2;
    static Despesa d3;

    static IRendimentoAssalariado ra1;
    static IRendimentoNaoAssalariado rna1;

    static Entrada nike;

    @DataPoints public static RendimentoNaoAssalariado [] RNA = {new RendimentoNaoAssalariado(1, "Chuteira"),new RendimentoNaoAssalariado(2,"Bola")};
    @DataPoints public static RendimentoAssalariado [] RA;
    @DataPoints("app.Despesa") public static Despesa [] DE = {new Despesa(0,0,(-1),3,500), new Despesa(2,0,0,9,1000)};
    @DataPoints("app.Entrada") public static Entrada [] E = {new Entrada(1, 3, 200), new Entrada(2,10,5000)};


    @BeforeClass
    public static void setUp() throws Exception
    {
        Neymar = new Cidadao(0,26, "Neymar");
        d1 = new Despesa(1,0,1,12,500000);
        d2 = new Despesa(3, 1,(-1),12,100);

        nike = new Entrada(05,05,10000);

        Bruna = new Cidadao(1, 22,"Bruna");

        ra1 = new RendimentoAssalariado(0,"Salário PSG",30000000,10000000,937);
        rna1 = new RendimentoNaoAssalariado(0,"Gols marcados");

        RA = new RendimentoAssalariado[2];
        for (int i = 1; i < 3; i++)
        {
            RA[i-1] = new RendimentoAssalariado(i,"Salário Globo",20000*i,700*i,937);
        }


    }


    @Theory
    public void testGetImpostoComposto(RendimentoNaoAssalariado rna, RendimentoAssalariado ra, @FromDataPoints("app.Despesa") Despesa de,@FromDataPoints("app.Entrada") Entrada e)
    {
        rna.cadastraValorRecebido(e);
        Neymar.cadastraRendimento(rna);
        Neymar.cadastraRendimento(ra);
        Neymar.cadastraDespesa(de);

        //#### Rendimento NÃO ASSALARIADO
        double totalRNA = 0;
        for (IRendimentoNaoAssalariado r : Neymar.getRendimentoNaoAssalariado())
        {
            //totalRNA += r.getTotalTributavel();
            totalRNA += r.getTotalRecebidoAno();
        }

        //#### Rendimento ASSALARIADO
        double totalRA = 0;
        for (IRendimentoAssalariado r: Neymar.getRendimentosAssalariado())
        {
            //totalRA += r.getTotalTributavel();
            totalRA += r.getTotalRecebidoAno() - r.getTotalRecolhidoNaFonte() - r.getTotalINSSPago();
        }

        double totalRendimentos = totalRA + totalRNA;

        //#### RECOLHIDO NA FONTE
        double IRRF = 0;
        for (IRendimentoAssalariado r: Neymar.getRendimentosAssalariado())
        {
            IRRF += r.getTotalRecolhidoNaFonte();
        }

        //#### BONUS
        double totalBonus = 0;
        for (Despesa d: Neymar.getDespesas())
        {
            if(d.getIdPessoa() == Neymar.getId()) {
                if (d.getTipoDespesa() >= 0) {
                    totalBonus = (d.getValor() > 20000) ? 10000 : d.getValor() * 0.5;
                }
            }else{
                if(d.getTipoDespesa() == 1){
                    totalBonus += (d.getValor() >= 5000) ? 5000 : d.getValor();
                }
                if(d.getTipoDespesa() == 0){
                    totalBonus += (d.getValor() >= 6000) ? 3000 : d.getValor()*0.5;
                }
            }
        }



        double BCS = totalRendimentos - IRRF;
        double BCC = BCS - totalBonus;

        assertThat(Neymar.getBaseDeCalculoSimplificado(), is(BCS));
        assertThat(Neymar.getBaseDeCalculoCompleto(), is(BCC));

        double IBC;
        if (BCC <= 15000.00)
            IBC = 0;
        if (BCC > 15000.00 && BCC <= 35000.00)
            IBC = BCC * 0.15;
        else
            IBC = BCC * 0.3;

        assertThat(Neymar.getImpostoPagarCompleto(), is(IBC));


    }



}