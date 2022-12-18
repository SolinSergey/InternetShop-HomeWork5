package ru.gb.internetshop.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.internetshop.core.entities.Role;
import ru.gb.internetshop.core.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole(Long id){
        return roleRepository.findByName("ROLE_USER").get();
    }
}
