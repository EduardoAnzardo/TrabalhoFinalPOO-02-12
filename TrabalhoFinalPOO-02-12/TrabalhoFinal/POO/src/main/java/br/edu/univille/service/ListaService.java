package br.edu.univille.service;

import br.edu.univille.dao.DAOLista;
import br.edu.univille.model.Lista;

import javax.swing.*;
import java.util.ArrayList;

public class ListaService {

    private final DAOLista listaDao;

    public ListaService (DAOLista listaDao) {
        this.listaDao = listaDao;
    }

    public void criarLista(Lista lista) {
        try{
            listaDao.create(lista);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao criar lista");
        }
    }

    public void excluirLista(int idLista) {
        Lista lista = listaDao.readOne(idLista);
        listaDao.delete(lista.getId());
    }

    public ArrayList<Lista> listarTodasAsListas() {
        return listaDao.readAll();
    }

    public Lista listarUmaListaPeloId(int idLista){
        return listaDao.readOne(idLista);
    }

}
