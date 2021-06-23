package com.alpha.ogo.service;


import com.alpha.ogo.domain.Role;
import com.alpha.ogo.dto.CommonResponce;

public interface RoleService {

	CommonResponce<Role> createRole(Role role);

	CommonResponce<Role> getAllRole();

	CommonResponce<Role> getRoleById(Role role);

	CommonResponce<Role> getrolebyRoleCode(String role);

	CommonResponce<Role> deleteRole(Role role);

}
