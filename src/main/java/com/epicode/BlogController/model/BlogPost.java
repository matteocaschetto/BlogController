package com.epicode.BlogController.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {
    private Long id;
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
}
