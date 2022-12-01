package br.edu.univille;

import br.edu.univille.dao.DAOLista;
import br.edu.univille.dao.DAOTarefa;
import br.edu.univille.service.ListaService;
import br.edu.univille.service.TarefaService;
import br.edu.univille.ui.TelaInicial;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial frame = new TelaInicial(new ListaService(new DAOLista()), new TarefaService(new DAOTarefa()));
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
