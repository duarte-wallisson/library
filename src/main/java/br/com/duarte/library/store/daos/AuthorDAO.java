package br.com.duarte.library.store.daos;

import br.com.duarte.library.store.models.Author;
import br.com.duarte.library.store.models.Book;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Dependent
public class AuthorDAO {
    @PersistenceContext
    private EntityManager manager;

    public List<Author> list() {
        return manager.createQuery("select a from Author a order by a.name asc", Author.class).getResultList();
    }
}
