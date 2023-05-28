package br.com.alura.loja.teste;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {

        Categoria categoria = new Categoria("CELULAR");

        Produto celular = new Produto("Xiami redmi", "Smartphone", new BigDecimal(800), categoria);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(categoria);
        produtoDao.cadastrar(celular);

        celular.setNome("Teste");

        em.flush();
        em.clear();

        celular = produtoDao.atualizar(celular);

        celular.setNome("1234");
        em.flush();
        em.clear();

        produtoDao.remove(celular);

        em.flush();

    }
}
