package com.example.newproject.service;

import com.example.newproject.dto.MenuDto;
import com.example.newproject.model.Menu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MenuService {

    Menu createMenu(MenuDto menuDto);
    Menu updateMenu(Long id, Menu menu);
    List<Menu> getListMenu();
    Menu getMenuById(Long id);
    void deleteMenuById(Long id);
}
