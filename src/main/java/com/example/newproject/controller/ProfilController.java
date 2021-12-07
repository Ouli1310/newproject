package com.example.newproject.controller;


import com.example.newproject.dto.ProfilDto;
import com.example.newproject.model.Menu;
import com.example.newproject.model.Profil;
import com.example.newproject.repository.ProfilRepository;
import com.example.newproject.service.ProfilService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class ProfilController {

    private final ProfilRepository profilRepository;
    private final ProfilService profilService;

    @GetMapping("/profils")
    public List<Profil> getAllProfils() {
        return profilService.getListProfil();
    }

    @PostMapping("/createProfil")
    public Profil newProfil(@RequestBody ProfilDto profilDto) {
        return profilService.createProfil(profilDto);
    }

    @GetMapping("/profil/{id}")
    public Profil getProfilById(@PathVariable(value = "id") Long id) {
        return profilService.getProfilById(id);
    }

}
