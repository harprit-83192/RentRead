package com.example.RentRead.Controller;

import com.example.RentRead.Entities.Book;
import com.example.RentRead.Services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetAllBooks() throws Exception{
        List<Book> books = Arrays.asList(
                new Book(1L,"Book1","Author1","Fiction", true, new HashSet<>()),
                new Book(2L, "Book2", "Author2", "Non-Fiction", false, new HashSet<>())
        );

        Mockito.when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get("/api/private/books"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testCreateBook() throws Exception{
        Book book = new Book(1L, "New Book", "New Author", "Science Fiction", true, new HashSet<>());

        Mockito.when(bookService.createBook(any(Book.class))).thenReturn(book);

        mockMvc.perform(post("/api/private/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isUnauthorized());
    }

}
