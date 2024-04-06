package com.example.RentRead.Controller;

import com.example.RentRead.Entities.Book;
import com.example.RentRead.ExceptionHandler.BookNotFoundException;
import com.example.RentRead.Services.BookService;
import com.example.RentRead.Services.RentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/private")
public class BookController {

    private final BookService bookService;

    private final RentService rentService;

    public BookController(BookService bookService, RentService rentService){
        this.bookService = bookService;
        this.rentService = rentService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        try{
            Book book = bookService.getBookById(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }catch (Exception e){
            throw new BookNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/books")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        Book updatedBook = bookService.updateBook(id, book);
        if(updatedBook != null){
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        }
        throw new BookNotFoundException("Book not found with id: " + id);
    }

    @DeleteMapping("/books/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        try{
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            throw new BookNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/books/{id}/rent")
    public ResponseEntity<?> rentBook(@PathVariable Long id, Principal principal){
        String username = principal.getName();
        return rentService.rentBook(id, username);
    }

    @PostMapping("/books/{id}/return")
    public ResponseEntity<?> returnBook(@PathVariable Long id, Principal principal){
        String username = principal.getName();
        return rentService.returnBook(id, username);
    }

}
