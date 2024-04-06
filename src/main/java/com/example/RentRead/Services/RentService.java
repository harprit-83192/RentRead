package com.example.RentRead.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RentService {
    ResponseEntity<?> rentBook(Long bookId, String username);
    ResponseEntity<?> returnBook(Long bookId, String username);
}
