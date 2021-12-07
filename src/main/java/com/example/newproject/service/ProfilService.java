package com.example.newproject.service;

import com.example.newproject.dto.ProfilDto;
import com.example.newproject.model.Menu;
import com.example.newproject.model.Profil;

import java.util.List;

public interface ProfilService {

    Profil createProfil(ProfilDto profilDto);
    List<Profil> getListProfil();
    Profil getProfilById(Long id);
}
