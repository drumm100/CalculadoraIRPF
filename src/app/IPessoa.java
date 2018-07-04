package app;

import java.util.Set;

public interface IPessoa {


    int /*@ pure @*/ getId();

    String /*@ pure @*/ getNome();

    int /*@ pure @*/ getIdade();
}
