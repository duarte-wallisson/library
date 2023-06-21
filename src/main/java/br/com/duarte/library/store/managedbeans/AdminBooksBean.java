package br.com.duarte.library.store.managedbeans;

import br.com.duarte.library.store.daos.BookDao;
import br.com.duarte.library.store.models.Book;
import lombok.Data;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
@Data
public class AdminBooksBean {
    private Book book = new Book();
    @Inject
    private BookDao bookDao;

    @Transactional
    public void save(){
        bookDao.save(book);
    }
}
