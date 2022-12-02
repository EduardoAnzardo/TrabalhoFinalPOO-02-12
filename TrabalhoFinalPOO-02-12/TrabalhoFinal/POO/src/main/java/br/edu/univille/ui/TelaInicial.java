package br.edu.univille.ui;

import br.edu.univille.model.Lista;
import br.edu.univille.service.ListaService;
import br.edu.univille.service.TarefaService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TelaInicial extends JFrame {

    private final ListaService listaService;
    private final TarefaService tarefaService;


    public TelaInicial(ListaService listaService, TarefaService tarefaService) {

        this.listaService = listaService;
        this.tarefaService = tarefaService;

        setTitle("Lista de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(650, 500);

        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        ArrayList<Lista> listas = listaService.listarTodasAsListas();
        List<Object> listObjects = UtilsMethods.newJTableByLista(listas, listaService, tarefaService,this);

        JTable table = (JTable) listObjects.get(0);
        JScrollPane scrollPane = (JScrollPane) listObjects.get(1);

        table.setBounds(50, 50, 540, 300);

        this.btnAdicionarUmaLista();
        this.labelJtable();
    }

    public void labelJtable() {
        JLabel ID = new JLabel("ID");
        JLabel Titulo = new JLabel("Titulo");
        JLabel Data = new JLabel("Data");
        JLabel Finalizado = new JLabel("Finalizado");
        JLabel Prioridade = new JLabel("Prioridade");

        ID.setBounds(50, 25, 50, 25);
        Titulo.setBounds(130, 25, 50, 25);
        Data.setBounds(200, 25, 150, 25);
        Finalizado.setBounds(280, 25, 150, 25);
        Prioridade.setBounds(350,25,150,25);

        this.add(ID);
        this.add(Titulo);
        this.add(Data);
        this.add(Finalizado);
        this.add(Prioridade);

    }

    public void btnAdicionarUmaLista(){
        JButton btnNewLista = UtilsMethods.newWindowPanel(200, 390, 20, 200, "Adicionar tarefa a lista", this, new NovaLista(listaService, tarefaService));
    }

}
