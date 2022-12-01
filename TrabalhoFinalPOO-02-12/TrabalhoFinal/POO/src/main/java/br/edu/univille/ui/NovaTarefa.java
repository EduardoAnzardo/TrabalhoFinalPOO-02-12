package br.edu.univille.ui;


import br.edu.univille.model.Lista;
import br.edu.univille.model.Tarefa;
import br.edu.univille.service.ListaService;
import br.edu.univille.service.TarefaService;

import javax.swing.*;
import java.awt.*;

public class NovaTarefa extends JFrame {

    private final ListaService listaService;
    private final TarefaService tarefaService;
    private Lista lista;

    public NovaTarefa(ListaService listaService, TarefaService tarefaService, Lista lista) {

        this.listaService = listaService;
        this.tarefaService = tarefaService;
        this.lista = lista;
        this.salvarTarefa();

    }
    private void salvarTarefa() {

            Tarefa tarefa = new Tarefa();
            tarefa.setLista(lista);
            tarefaService.adicionarTarefaEmUmaLista(tarefa);
            this.dispose();
        };
}


