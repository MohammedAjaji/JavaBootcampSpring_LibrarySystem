package com.example.spring_day5_exercise.Service;


import com.example.spring_day5_exercise.ApiException.ApiException;
import com.example.spring_day5_exercise.Model.Book;
import com.example.spring_day5_exercise.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List getBooks(){
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Integer id, Book book){
        Book oldBook = bookRepository.findBookById(id);

        if (oldBook == null){
            throw new ApiException("ID Not Found");
        }

        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setCategory(book.getCategory());
        oldBook.setIsbn(book.getIsbn());
        oldBook.setNumberOfPages(book.getNumberOfPages());

        bookRepository.save(oldBook);
    }

    public void deleteBook(Integer id){
        Book book = bookRepository.findBookById(id);
        if (book == null){
            throw new ApiException("ID Not Found");
        }
        bookRepository.delete(book);
    }

    public List<Book> findByCategory(String category){
        List<Book> books = bookRepository.findAllByCategory(category);
        if (books.isEmpty()){
            throw new ApiException("Category Not Found");
        }
        return books;
    }

    public List<Book> findByNumberOfPagesGreaterThan(Integer pages){
        List<Book> books = bookRepository.findAllByNumberOfPagesGreaterThan(pages);
        if (books.isEmpty()){
            throw new ApiException("Not Found");
        }
        return books;
    }

    public List<Book> findByAuthor(String author){
        List<Book> books = bookRepository.findAllByAuthor(author);
        if (books.isEmpty()){
            throw new ApiException("Not Found");
        }
        return books;
    }

    public List<Book> findByTitle(String title){
        List<Book> books = bookRepository.findAllByTitle(title);
        if (books.isEmpty()){
            throw new ApiException("Not Found");
        }
        return books;
    }


}
