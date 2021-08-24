package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);

    Role findRole(String role);

    void updateRole(Role role);

    void deleteRole(Role role);

    List<Role> getRolesList();
}
