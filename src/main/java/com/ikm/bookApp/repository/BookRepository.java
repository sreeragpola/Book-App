package com.ikm.bookApp.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ikm.bookApp.model.Book;

public interface BookRepository  extends JpaRepository<Book , Long>{
    
}
