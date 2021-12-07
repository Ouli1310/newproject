package com.example.newproject.serviceImpl;

import com.example.newproject.dto.MenuDto;
import com.example.newproject.model.Menu;
import com.example.newproject.repository.MenuRepository;
import com.example.newproject.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final ModelMapper modelMapper;

    private MenuDto convertToDto(Menu menu) {
        MenuDto menuDto = new MenuDto();
        menuDto = modelMapper.map(menu, MenuDto.class);
        return menuDto;
    }

    private Menu convertToEntity(MenuDto menuDto) {
        Menu menu = new Menu();
        menu = modelMapper.map(menuDto, Menu.class);
        return menu;
    }

    @Override
    public Menu createMenu(MenuDto menuDto) {
        Menu menu = new Menu();
        menu = convertToEntity(menuDto);
        try {
            menuRepository.save(menu);
        }catch (Exception e) {
            return null;
        }

        return menu;
    }

    @Override
    public Menu updateMenu(Long id, Menu menu) {
        Menu currentMenu = menuRepository.findById(id).orElse(null);
        currentMenu.setId(menu.getId());
        currentMenu.setLibelle(menu.getLibelle());
        currentMenu.setCode(menu.getCode());
        currentMenu.setIcon(menu.getIcon());
        currentMenu.setRoute(menu.getRoute());
        currentMenu.setParent_Id(menu.getParent_Id());
        currentMenu.setPriorite(menu.getPriorite());
        currentMenu.setProfil(menu.getProfil());

        Menu updatedMenu = menuRepository.save(currentMenu);
        return updatedMenu;
    }

    @Override
    public List<Menu> getListMenu() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMenuById(Long id) {
        menuRepository.deleteById(id);
    }
}
