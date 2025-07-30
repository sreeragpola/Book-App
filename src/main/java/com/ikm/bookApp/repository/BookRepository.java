package com.ikm.bookApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ikm.bookApp.model.Book;

public interface BookRepository  extends JpaRepository<Book , Long>{
    Optional<Book> finByIsBn(String isbn);  
}
