package com.example.newproject.dto;


import com.example.newproject.model.Menu;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import java.util.Set;

@Data
public class MenuDto {

    @Id
    private Long id;
    private String libelle;
    private String code;
    private String icon;
    private String route;
    private Long parent_Id;
    private Long priorite;
    private Long profil;
}
