package org.lessons.java.spring_alexandria_library.controller;

import java.util.List;

import org.lessons.java.spring_alexandria_library.model.Book;
import org.lessons.java.spring_alexandria_library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Book> books = repository.findAll(); // Questo seleziona tutti i libri

        model.addAttribute("books", books);
        return "books/index";

    }

    @GetMapping("/{id}") //localhost:8080/books/12
    public String show(@PathVariable("id") Integer id, Model model) {
        Book book = repository.findById(id).get();
        model.addAttribute("book", book);
        return "books/show";
    }

    @GetMapping("/searchByTitle")
    public String searchByTitle(@RequestParam(name = "title") String title, Model model){
        List<Book> books = repository.findByTitleContaining(title);
        model.addAttribute("books", books);
        return "books/index";
    } 

    @GetMapping("/searchByTitleOrAuthor")
    public String searchByTitleOrAuthor(@RequestParam(name = "query") String query, Model model){
        List<Book> books = repository.findByTitleContainingOrAuthorContaining(query, query);
        model.addAttribute("books", books);
        return "books/index";
    } 

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("book", new Book());
        return "books/create";
    }

}

