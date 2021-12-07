package com.example.newproject.dto;


import lombok.Data;

import javax.persistence.Id;

@Data
public class ProfilDto {

    @Id
    private Long id;
    private String nom;
    private String code;
    private String domaine;
}
