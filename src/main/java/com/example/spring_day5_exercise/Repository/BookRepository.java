package com.example.spring_day5_exercise.Repository;

import com.example.spring_day5_exercise.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);

    List<Book> findAllByCategory(String Category);

    List<Book> findAllByNumberOfPagesGreaterThan(Integer num);

    List<Book> findAllByAuthor(String author);

    List<Book> findAllByTitle(String title);


}