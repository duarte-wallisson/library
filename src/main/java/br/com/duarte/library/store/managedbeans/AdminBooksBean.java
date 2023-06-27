package br.com.duarte.library.store.managedbeans;

import br.com.duarte.library.store.daos.AuthorDAO;
import br.com.duarte.library.store.daos.BookDAO;
import br.com.duarte.library.store.models.Author;
import br.com.duarte.library.store.models.Book;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Model
@Data
public class AdminBooksBean {
    private Book book = new Book();
    @Inject
    private BookDAO bookDao;
    @Inject
    private AuthorDAO authorDAO = new AuthorDAO();
    private List<Author> authors = new ArrayList<>();
    private List<Integer> selectedAuthorsIds = new ArrayList<>();

    @Transactional
    public void save(){
        populateBookAuthor();
        bookDao.save(book);
        clearObjects();
    }

    private void clearObjects() {
        this.book = new Book();
        this.selectedAuthorsIds.clear();
    }

    @PostConstruct
    public void loadObjects() {
        this.authors = authorDAO.list();
    }
    
    private void populateBookAuthor() {
        selectedAuthorsIds.stream().map(Author::new).forEach(book :: add);
    }


}
