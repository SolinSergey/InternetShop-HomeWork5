package ru.gb.internetshop.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.internetshop.core.entities.Role;

import java.util.Optional;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String role_user);
}
