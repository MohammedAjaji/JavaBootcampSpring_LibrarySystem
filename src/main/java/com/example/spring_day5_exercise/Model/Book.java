package com.example.spring_day5_exercise.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "author cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;

    @NotEmpty(message = "category cannot be empty")
    @Column(columnDefinition = "varchar(20) not null check ( category = 'academic' or category = 'mystery' or category = 'Novel' )")
    private String category;

    @NotNull(message = "ISBN cannot be empty")
    @Column(columnDefinition = "int not null unique")
    private Integer isbn;

    @NotNull(message = "numberOfPages cannot be empty")
    @Min(value = 50,message = "numberOfPages have to be more than 50")
    @Column(columnDefinition = "int not null")
    private Integer numberOfPages;
}
