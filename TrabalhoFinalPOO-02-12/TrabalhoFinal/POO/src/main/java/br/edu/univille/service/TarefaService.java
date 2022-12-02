package br.edu.univille.service;

import br.edu.univille.dao.DAOTarefa;
import br.edu.univille.model.Tarefa;

import javax.swing.*;
import java.time.LocalDate;

public class TarefaService {

    private final DAOTarefa tarefaDao;

    public TarefaService (DAOTarefa tarefaDao) {
        this.tarefaDao = tarefaDao;
    }

    public void adicionarTarefaEmUmaLista(Tarefa tarefa) {

        if (tarefa.getTitulo().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um título para a tarefa");
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio");
        }

        if(tarefa.isConcluida()){
            tarefa.setDataConclusao(LocalDate.now());
        }

        tarefa.setId(tarefaDao.getProximoId());
        tarefaDao.create(tarefa);
    }

}
