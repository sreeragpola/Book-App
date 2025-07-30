package com.ikm.bookApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikm.bookApp.dto.BookRequestdto;
import com.ikm.bookApp.dto.BookResponseDto;
import com.ikm.bookApp.model.Book;
import com.ikm.bookApp.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookRequestdto bookRequestdto){
        return ResponseEntity.ok(bookService.createBook(bookRequestdto));
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookResponseDto> getBooksbyIsbn(@PathVariable String isbn){
        return ResponseEntity.ok(bookService.getBooksbyIsbn(isbn));

    }  
}
