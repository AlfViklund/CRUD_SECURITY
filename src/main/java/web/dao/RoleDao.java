package web.dao;

import web.model.Role;

public interface RoleDao {
    Role saveRole(Role role);

    Role findRole(String role);

    void updateRole(Role role);

    void deleteRole(Role role);
}
