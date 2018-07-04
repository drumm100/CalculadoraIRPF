package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Controle {
    @FXML
    private TextField idadeDoSujeito;
    @FXML
    private Button btnEntrar;
    @FXML
    private TextField nomeDoSujeito;


    Persistencia p = Persistencia.getInstance();
    int id = 0;

    public void BuscaContribuinte()
    {
        System.out.println("O meu nome é: " + nomeDoSujeito.getText());

        int idade = Integer.parseInt(idadeDoSujeito.getText());
        String nome = nomeDoSujeito.getText();

        if (p.buscaCidadao(nome, idade) == null )
        {
            p.adicionaCidadao(new Cidadao(id++, idade, nome));
        }
        System.out.println(p.retornaLista().toString());
    }
}
