package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public Produto atualizar(Produto produto) {
        return this.em.merge(produto);
    }

    public void remove(Produto produto) {
        produto = atualizar(produto);
        this.em.remove(produto);
    }

}
