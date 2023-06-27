package br.com.duarte.library.store.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Long numberOfPages;
    private Double price;
    @OneToMany
    private List<Author> authors = new ArrayList<>();

    public void add(Author author) {
        authors.add(author);
    }
}
