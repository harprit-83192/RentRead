package com.example.RentRead.Services.Impl;

import com.example.RentRead.Entities.Book;
import com.example.RentRead.ExceptionHandler.BookNotFoundException;
import com.example.RentRead.Repositories.BookRepository;
import com.example.RentRead.Services.BookService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        try{
            Optional<Book> optionalBook = bookRepository.findById(id);
            return optionalBook.get();
        }catch(Exception e){
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        try{
            Book existedBook = bookRepository.getReferenceById(id);
            existedBook.setTitle(book.getTitle());
            existedBook.setAuthor(book.getAuthor());
            existedBook.setGenre(book.getGenre());
            existedBook.setAvailability(book.getAvailability());
            return bookRepository.save(existedBook);
        }catch(Exception e){
            throw new BookNotFoundException("Book not found with id: " + id);
        }

    }

    @Override
    public void deleteBook(Long id) {
        try {
            Book book = bookRepository.getReferenceById(id);
            bookRepository.delete(book);
        }catch(Exception e){
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }
}
