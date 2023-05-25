package com.example.spring_day5_exercise.Controller;


import com.example.spring_day5_exercise.Model.Librarian;
import com.example.spring_day5_exercise.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {

    private final LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity getLibrarian(){
        List<Librarian> librarian = librarianService.getLibrarian();
        return ResponseEntity.status(200).body(librarian);
    }

    @PostMapping("/add")
    public ResponseEntity addLibrarian(@Valid @RequestBody Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body("Librarian Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id,@Valid @RequestBody Librarian librarian){
        librarianService.updateLibrarian(id,librarian);
        return ResponseEntity.status(200).body("Librarian Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id){
        librarianService.deleteLibrarian(id);
        return ResponseEntity.status(200).body("Librarian deleted");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getByLibrarianId(@PathVariable Integer id){
        Librarian librarian = librarianService.findByID(id);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity getByLibrarianEmail(@PathVariable String email){
        Librarian librarian = librarianService.findByEmail(email);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity loginLibrarian(@PathVariable String username, @PathVariable String password){
        Librarian librarian = librarianService.loginLibrarian(username,password);
        return ResponseEntity.status(200).body(librarian);
    }
}
