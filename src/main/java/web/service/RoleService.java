package web.service;

import org.springframework.stereotype.Service;
import web.model.Role;

import java.util.List;

@Service
public interface RoleService {
    List<Role> findAll();
    Role findByName(String name);
    Role getRoleById(Long id);
}
