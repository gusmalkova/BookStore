package com.tdnhat.bookstore.book.boudary;

import com.tdnhat.bookstore.book.entity.Book;
import com.tdnhat.bookstore.book.entity.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Response findAll() {
        return Response.ok().entity(bookRepository.findAll()).build();
    }

    @GetMapping("/books/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return Response.ok().entity(bookRepository.findById(id)).build();
    }

    @PutMapping("/books")
    public Response add(Book book) {
        this.bookRepository.save(book);
        return Response.ok().build();
    }

    @DeleteMapping("/books")
    public Response delete(Book book) {
        this.bookRepository.delete(book);
        return Response.ok().build();
    }

    @DeleteMapping("/books/{id}")
    public Response deleteById(@PathVariable("id") Long id) {
        this.bookRepository.deleteById(id);
        return Response.ok().build();
    }
    
}
