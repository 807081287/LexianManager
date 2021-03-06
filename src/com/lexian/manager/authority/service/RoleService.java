package com.lexian.manager.authority.service;

import com.lexian.manager.authority.bean.Role;
import com.lexian.web.ResultHelper;

public interface RoleService {
	
	public ResultHelper getRoles(Integer pageNo);

	public ResultHelper addRole(Role role);

	public ResultHelper updateRole(Role role);

	
	public ResultHelper getMenus(Integer id);

	public ResultHelper updateMenus(Integer id, int[] menuIds);

	public ResultHelper updatePrivileges(Integer id, int[] privilegeId);

	public ResultHelper getPrivileges(Integer id);
	
}
