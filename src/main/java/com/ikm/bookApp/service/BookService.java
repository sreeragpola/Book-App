package com.ikm.bookApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ikm.bookApp.dto.BookRequestdto;
import com.ikm.bookApp.model.Book;
import com.ikm.bookApp.model.Review;
import com.ikm.bookApp.dto.Reviewdto;
import com.ikm.bookApp.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book createBook(BookRequestdto bookRequestdto) {
        Book book = new Book();
        book.setIsbn(bookRequestdto.getIsbn());
        book.setAuthor(bookRequestdto.getAuthor());
        book.setTitle(bookRequestdto.getTitle());
   
        List<Review> reviews = new ArrayList<>();
        if (bookRequestdto.getInitialReview() != null) {
            for (Reviewdto reviewdto : bookRequestdto.getInitialReview()) {
                Review review = new Review();
                review.setComment(reviewdto.getComment());
                review.setRating(reviewdto.getRating());
                reviews.add(review);
            }
        }
        book.setReviews(reviews);
        return bookRepository.save(book);
    }
}
