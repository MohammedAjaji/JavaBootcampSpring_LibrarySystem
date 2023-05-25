package com.example.spring_day5_exercise.Repository;


import com.example.spring_day5_exercise.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    Librarian findLibrarianById(Integer id);

    Librarian findLibrarianByEmail(String email);

    @Query("select l from Librarian l where l.username =?1 and l.password =?2")
    Librarian loginLibrarian(String username, String password);

}
