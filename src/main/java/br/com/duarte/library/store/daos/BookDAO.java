package br.com.duarte.library.store.daos;

import br.com.duarte.library.store.models.Book;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
public class BookDAO {
    @PersistenceContext
    private EntityManager manager;

    public void save(Book book) {
        manager.persist(book);
    }
}
