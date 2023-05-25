package com.example.spring_day5_exercise.Controller;


import com.example.spring_day5_exercise.Model.Book;
import com.example.spring_day5_exercise.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getBooks(){
       List<Book> books = bookService.getBooks();
        return ResponseEntity.status(200).body(books);
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id,@Valid @RequestBody Book book){
        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body("Book Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted");
    }

    @GetMapping("/category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        List<Book> books = bookService.findByCategory(category);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/pages/{pages}")
    public ResponseEntity getByNumberOfPagesGreaterThan(@PathVariable Integer pages){
        List<Book> books = bookService.findByNumberOfPagesGreaterThan(pages);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity getByAuthor(@PathVariable String author){
        List<Book> books = bookService.findByAuthor(author);
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        List<Book> books = bookService.findByTitle(title);
        return ResponseEntity.status(200).body(books);
    }

}
