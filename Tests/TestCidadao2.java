import app.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestCidadao2
{
    static Cidadao Neymar;
    static Cidadao Bruna;

    static Despesa d1;
    static Despesa d2;
    static Despesa d3;

    static IRendimentoAssalariado ra1;
    static IRendimentoNaoAssalariado rna1;

    static Entrada nike;



    @Before
    public void setUp() throws Exception
    {
        Neymar = new Cidadao(0,26, "Neymar");
        d1 = new Despesa(1,0,1,12,500000);
        d2 = new Despesa(3, 1,(-1),12,100);

        nike = new Entrada(05,05,10000);

        Bruna = new Cidadao(1, 22,"Bruna");

        ra1 = new RendimentoAssalariado(0,"Salário PSG",30000000,10000000,937);
        rna1 = new RendimentoNaoAssalariado(0,"Gols marcados");

    }




    @Test
    public void testGetImpostoSimplificado()
    {
        rna1.cadastraValorRecebido(nike);
        Neymar.cadastraRendimento(rna1);     //Neymar recebe bonus por gols
        Neymar.cadastraRendimento(ra1);      //Salário
        Neymar.cadastraDespesa(d3);          //app.Despesa da Bruna


        //Total Tributável - IRRF
        //TT salario : 30000000 - 10000000 - 937 = 19999063
        //TT = soma rendimentos = 19999063 + 10000 = 20009063
        //IRRF = 10000000
        // TT - IRRF = 10009063 * 0.3 = 3002718.9
        assertEquals(3002718.9,Neymar.getImpostoPagarSimplificado(),0.1);

    }

    @Test
    public void testGetDespesas()
    {
        Neymar.cadastraDespesa(d1);
        assertEquals(Neymar.getDespesas().size(), 1);
    }

    @Test
    public void testGetDependente()
    {
        Neymar.cadastraDependente(Bruna);
        assertEquals(Neymar.getDependentes().size(), 1);
    }

    @Test
    public void testGetRendimento()
    {
        Neymar.cadastraRendimento(ra1);
        assertEquals(Neymar.getRendimentos().size(), 1);
    }

}
