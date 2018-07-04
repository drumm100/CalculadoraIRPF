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

    private int id = 0;

    Persistencia p = Persistencia.getInstance();

    public void BuscaContribuinte(){
        System.out.println("O meu nome é: " + nomeDoSujeito.getText());
        System.out.println(p.retornaLista().toString());

        int idade = Integer.parseInt(idadeDoSujeito.getText());
        String nome = nomeDoSujeito.getText();

        if (p.buscaCidadao(nome, idade) == null){
            System.out.println("O cidadao nao existe");

            p.adicionaCidadao(new Cidadao(id++, idade, nome));

            if(p.buscaCidadao(nome, idade) != null)
                System.out.println(p.buscaCidadao(nome, idade).getNome());

        }else{
            System.out.println("Cidadao: " + p.buscaCidadao(nome, idade).getNome() + " existe");
        }

    }

}
