package app;

import java.util.ArrayList;

public class Persistencia {

    public static Persistencia instance = null;

    public static ArrayList<Cidadao> ListaCidadoes;
    private static int id = 0;

    private Persistencia(){
        ListaCidadoes = new ArrayList<Cidadao>();
    }

    public static Persistencia getInstance(){
        if (instance == null){
            instance = new Persistencia();
            return instance;
        }else {
            return instance;
        }
    }

    public static Cidadao buscaCidadao(String cidadao, int idade){
        for (Cidadao c: ListaCidadoes) {
            if (c.getNome().equals(cidadao) && c.getIdade() == idade) return c;
        }
        return null;
    }

    public static void adicionaCidadao(Cidadao c)
    {
        ListaCidadoes.add(c);
    }

    public static ArrayList retornaLista(){return ListaCidadoes;}
}
