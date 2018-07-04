package app;

import java.util.Scanner;

public class ControleTerminal
{

    private static int id = 0;
    static Persistencia p = Persistencia.getInstance();



    public ControleTerminal() { }

    public static Cidadao BuscaCidadao(String nome, String idade)
    {
        int idade_int = Integer.parseInt(idade);

        if (p.buscaCidadao(nome, idade_int) == null )
        {
            Cidadao c = new Cidadao(id++, idade_int, nome);
            p.adicionaCidadao(c);
            return c;
        }
        return p.buscaCidadao(nome, idade_int);
    }

    public static void CadatraDespesa(Cidadao c, int id, int id_pessoa, int tipo, int mes, double valor)
    {
        Despesa d = new Despesa(id, id_pessoa, tipo, mes, valor);
        c.cadastraDespesa(d);
    }

    public static void CadastraRendimentoNaoAssalariado(Cidadao c, int id, String des, int mes, double valor)
    {
        Entrada entry = new Entrada(id, mes , valor);
        RendimentoNaoAssalariado rna = new RendimentoNaoAssalariado(id, des);
        rna.cadastraValorRecebido(entry);
        c.cadastraRendimento(rna);
    }

    public static void CadastraRendimentoAssalariado(Cidadao c, int id, String des, double total, double irrf, double inss)
    {
        RendimentoAssalariado ra = new RendimentoAssalariado(id, des, total, irrf, inss);
        c.cadastraRendimento(ra);
    }

    public static void cadastraDependente(Cidadao c, String nome, String idade)
    {
       Cidadao aux =  BuscaCidadao(nome, idade);
       c.cadastraDependente(aux);
    }

    }
