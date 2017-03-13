package com.taikang.exercise.dao;

import java.util.List;

import com.slt.poker.dao.DaoMapper;
import com.taikang.exercise.dto.Role;

public interface RoleDao extends DaoMapper {
	public Role findRoleById(int id);

	public List<Role> findRole(String name);

	public void updateRole(Role role);

	public void insertRole(Role role);

	public void deleteRole(int id);
}
