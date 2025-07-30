package com.ikm.bookApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ikm.bookApp.dto.BookRequestdto;
import com.ikm.bookApp.dto.BookResponseDto;
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

    public BookResponseDto getBooksbyIsbn(String isbn) {
        Optional<Book> book = bookRepository.finByIsBn(isbn);
        if (book.isPresent()) {
            BookResponseDto bookresponse = mapToBookResponce(book.get());
            return bookresponse;
        } else {
            return null;
        }
    }

    public BookResponseDto mapToBookResponce(Book book){
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setIsbn(book.getIsbn());
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setAuthor(book.getAuthor());
        bookResponseDto.setPublicationYear(book.getPublicationYear());
        List<Review> reviews = book.getReviews();
        List<Reviewdto> reviewdtoList = new ArrayList<>();
        for(Review review : reviews){
            Reviewdto reviewdto = new Reviewdto();
            reviewdto.setComment(review.getComment());
            reviewdto.setRating(review.getRating());
            reviewdto.setReviewerName(review.getReviewerName());
            reviewdtoList.add(reviewdto);
        }
        bookResponseDto.setReviews(reviewdtoList);

        return bookResponseDto;

    }
}
 