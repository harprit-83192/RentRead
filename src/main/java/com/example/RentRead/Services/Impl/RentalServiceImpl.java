package com.example.RentRead.Services.Impl;

import com.example.RentRead.Entities.Book;
import com.example.RentRead.Entities.User;
import com.example.RentRead.Repositories.BookRepository;
import com.example.RentRead.Repositories.UserRepository;
import com.example.RentRead.Services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RentalServiceImpl implements RentService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> rentBook(Long bookId, String username){
        User user = userRepository.findByEmail(username);
        Book book = bookRepository.getReferenceById(bookId);

        if(user == null || book == null){
            return ResponseEntity.notFound().build();
        }

        if(user.getRentals().size() >= 2){
            return ResponseEntity.badRequest().body("You already have rented the book.");
        }

        if(book.getAvailability().equals(false)){
            return ResponseEntity.badRequest().body("The book is not available");
        }

        user.getRentals().add(book);
        book.getRentedBy().add(user);
        book.setAvailability(false);

        userRepository.save(user);
        bookRepository.save(book);

        return ResponseEntity.ok().body("Book rented successfully.");
    }

    public ResponseEntity<?> returnBook(Long bookId, String username){
        User user = userRepository.findByEmail(username);
        Book book = bookRepository.getReferenceById(bookId);

        if(user == null || book == null){
            return ResponseEntity.notFound().build();
        }

        if(!user.getRentals().contains(book)){
            return ResponseEntity.badRequest().body("You have not rented this book.");
        }

        user.getRentals().remove(book);
        book.getRentedBy().remove(user);
        book.setAvailability(true);

        userRepository.save(user);
        bookRepository.save(book);

        return ResponseEntity.ok().body("Book return successfully.");
    }
}
