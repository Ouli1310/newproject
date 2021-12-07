package com.example.newproject.controller;


import com.example.newproject.dto.MenuDto;
import com.example.newproject.model.Menu;
import com.example.newproject.repository.MenuRepository;
import com.example.newproject.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
public class MenuController {
    private final MenuRepository menuRepository;
    private final MenuService menuService;

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getListMenu();
    }

    @PostMapping("/createMenu")
    public Menu newMenu(@RequestBody MenuDto menuDto) {
        return menuService.createMenu(menuDto);
    }

    @PutMapping("/menu/{id}")
    public Menu updateMenu(@PathVariable(value = "id") Long id, @RequestBody Menu menu) {
        Menu updatedMenu = menuService.getMenuById(id);
        updatedMenu.setId(menu.getId());
        updatedMenu.setLibelle(menu.getLibelle());
        updatedMenu.setIcon(menu.getIcon());
        updatedMenu.setCode(menu.getCode());
        updatedMenu.setRoute(menu.getRoute());
        updatedMenu.setParent_Id(menu.getParent_Id());
        updatedMenu.setPriorite(menu.getPriorite());
        updatedMenu.setProfil(menu.getProfil());
        return menuService.updateMenu(id, updatedMenu);
    }

    @GetMapping("/menu/{id}")
    public Menu getMenuById(@PathVariable(value = "id") Long id) {
        return menuService.getMenuById(id);
    }

    @DeleteMapping("/menu/{id}")
    public void deleteMenu(@PathVariable(value = "id") Long id) {
        menuService.deleteMenuById(id);
    }
    }
