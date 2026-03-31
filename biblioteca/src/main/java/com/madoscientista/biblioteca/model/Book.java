package com.madoscientista.biblioteca.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;

    @NotBlank(message = "El campo isbn no puede estar vacío")
    private String isbn;

    @NotBlank(message = "El campo título no puede estar vacío")
    private String title;

    @NotBlank(message = "El campo autor no puede estar vacío")
    private String author;

    private int publicationDate;
    
    @NotBlank(message = "El campo editorial no puede estar vacío")
    private String editorial;

    private boolean isAvailable;
    
}
