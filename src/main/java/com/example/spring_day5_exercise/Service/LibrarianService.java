package com.example.spring_day5_exercise.Service;


import com.example.spring_day5_exercise.ApiException.ApiException;
import com.example.spring_day5_exercise.Model.Book;
import com.example.spring_day5_exercise.Model.Librarian;
import com.example.spring_day5_exercise.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {


    private final LibrarianRepository librarianRepository;

    public List getLibrarian(){
        List<Librarian> librarians = librarianRepository.findAll();
        return librarians;
    }

    public void addLibrarian(Librarian librarian){
        librarianRepository.save(librarian);
    }

    public void updateLibrarian(Integer id, Librarian librarian){
        Librarian oldLibrarian = librarianRepository.findLibrarianById(id);

        if (oldLibrarian == null){
            throw new ApiException("ID Not Found");
        }

        oldLibrarian.setUsername(librarian.getUsername());
        oldLibrarian.setPassword(librarian.getPassword());
        oldLibrarian.setEmail(librarian.getEmail());

        librarianRepository.save(oldLibrarian);
    }

    public void deleteLibrarian(Integer id){
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian == null){
            throw new ApiException("ID Not Found");
        }
        librarianRepository.delete(librarian);
    }

    public Librarian findByID(Integer id){
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian == null){
            throw new ApiException("ID Not Found");
        }
        return librarian;
    }

    public Librarian findByEmail(String email){
        Librarian librarian = librarianRepository.findLibrarianByEmail(email);
        if (librarian == null){
            throw new ApiException("Not Found");
        }
        return librarian;
    }

    public Librarian loginLibrarian(String username, String password){
        Librarian librarian = librarianRepository.loginLibrarian(username,password);
        if (librarian == null){
            throw new ApiException("Sorry username or password are not correct");
        }

        return librarian;
    }

}
